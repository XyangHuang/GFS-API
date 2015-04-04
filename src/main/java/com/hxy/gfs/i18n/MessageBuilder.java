package com.hxy.gfs.i18n;

import java.io.File;
import java.io.FilenameFilter;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.hxy.gfs.constants.Constants;
import com.hxy.gfs.utils.StringUtil;

@Component
public class MessageBuilder {
    private static Map<Locale, ResourceBundle> resourceBundleMap = new HashMap<Locale, ResourceBundle>();
    private static final Set<Locale> SUPPORTED_LOCALES = new HashSet<Locale>();
    static {
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        final Pattern pattern = Pattern
                        .compile("^" + Constants.I18N_BUNDLE_BASE_NAME + "((_\\w+){1,2}|)\\.properties$");
        new File(path).list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (new File(dir, name).isDirectory()) {
                    return false;
                }
                if (name.equals(Constants.I18N_BUNDLE_BASE_NAME + ".properties")) {
                    SUPPORTED_LOCALES.add(Locale.ROOT);
                    return true;
                }
                Matcher matcher = pattern.matcher(name);
                if (matcher.find()) {
                    String lang = matcher.group(1).substring(1).toLowerCase().replace('_', '-');
                    SUPPORTED_LOCALES.add(Locale.forLanguageTag(lang));
                    return true;
                }
                return false;
            }
        });
        resourceBundleMap.put(Locale.ROOT, ResourceBundle.getBundle(Constants.I18N_BUNDLE_BASE_NAME, Locale.ROOT));
    }

    public String buildMessage(String key, Object[] params, String defaultMessage, Locale locale) {
        if (key == null) {
            return StringUtil.isEmpty(defaultMessage) ? StringUtil.EMPTY : defaultMessage;
        }

        if (locale == null) {
            locale = Locale.forLanguageTag(Constants.I18N_DEFAULT_LANGUAGE);
        }

        if (StringUtil.isEmpty(defaultMessage)) {
            defaultMessage = key;
        }

        if (ObjectUtils.isEmpty(params)) {
            return getMessage(key, defaultMessage, locale);
        } else {
            params = getArgsInternationalization(params, locale);
            return getMessage(key, params, defaultMessage, locale);
        }
    }

    public String buildMessage(String key, Locale locale) {
        return buildMessage(key, null, null, locale);
    }

    public String buildMessage(String key, Object[] params, Locale locale) {
        return buildMessage(key, params, null, locale);
    }

    public String buildMessage(String key, String defaultMessage, Locale locale) {
        return buildMessage(key, null, defaultMessage, locale);
    }

    private Object[] getArgsInternationalization(Object[] params, Locale locale) {
        Object[] internationalizationParams = new Object[params.length];
        for (int i = 0; i < params.length; i++) {
            internationalizationParams[i] = buildMessage((String) params[i], null, (String) params[i], locale);
        }
        return internationalizationParams;
    }

    private String getMessage(String key, String def, Locale locale) {
        return getMessage(key, new Object[0], def, locale);
    }

    private String getMessage(String key, Object[] params, String def, Locale locale) {
        ResourceBundle bundle = getResourceBundle(locale);
        try {
            if (bundle != null) {
                return MessageFormat.format(bundle.getString(key), params);
            } else {
                return def;
            }
        } catch (MissingResourceException e) {
            return def;
        }
    }

    private ResourceBundle getResourceBundle(Locale locale) {
        if (!SUPPORTED_LOCALES.contains(locale)) {
            return resourceBundleMap.get(Locale.ROOT);
        } else {
            synchronized (resourceBundleMap) {
                ResourceBundle bundle = resourceBundleMap.get(locale);
                // If there's no bundle with locale, return bundle with Locale.ROOT or last cached bundle.
                if (bundle == null) {
                    bundle = ResourceBundle.getBundle(Constants.I18N_BUNDLE_BASE_NAME, locale);
                    resourceBundleMap.put(locale, bundle);
                }
                return bundle;
            }
        }
    }
}
