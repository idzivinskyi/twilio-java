/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.twiml.voice;

import com.twilio.twiml.TwiML;

import java.util.HashMap;
import java.util.Map;

/**
 * TwiML wrapper for {@code <Lang>}
 */
public class SsmlLang extends TwiML {
    public enum XmlLang {
        DA_DK("da-DK"),
        NL_NL("nl-NL"),
        EN_AU("en-AU"),
        EN_GB("en-GB"),
        EN_IN("en-IN"),
        EN_US("en-US"),
        EN_GB_WLS("en-GB-WLS"),
        FR_FR("fr-FR"),
        FR_CA("fr-CA"),
        DE_DE("de-DE"),
        IS_IS("is-IS"),
        IT_IT("it-IT"),
        JA_JP("ja-JP"),
        KO_KR("ko-KR"),
        NB_NO("nb-NO"),
        PL_PL("pl-PL"),
        PT_BR("pt-BR"),
        PT_PT("pt-PT"),
        RO_RO("ro-RO"),
        RU_RU("ru-RU"),
        ES_ES("es-ES"),
        ES_US("es-US"),
        SV_SE("sv-SE"),
        TR_TR("tr-TR"),
        CY_GB("cy-GB");

        private final String value;

        private XmlLang(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }
    }

    private final SsmlLang.XmlLang xmlLang;
    private final String words;

    /**
     * For XML Serialization/Deserialization
     */
    private SsmlLang() {
        this(new Builder((String) null));
    }

    /**
     * Create a new {@code <SsmlLang>} element
     */
    private SsmlLang(Builder b) {
        super("lang", b);
        this.xmlLang = b.xmlLang;
        this.words = b.words;
    }

    /**
     * The body of the TwiML element
     *
     * @return Element body as a string if present else null
     */
    protected String getElementBody() {
        return this.getWords() == null ? null : this.getWords();
    }

    /**
     * Attributes to set on the generated XML element
     *
     * @return A Map of attribute keys to values
     */
    protected Map<String, String> getElementAttributes() {
        // Preserve order of attributes
        Map<String, String> attrs = new HashMap<>();

        if (this.getXmlLang() != null) {
            attrs.put("xml:lang", this.getXmlLang().toString());
        }

        return attrs;
    }

    /**
     * Specify the language
     *
     * @return Specify the language
     */
    public SsmlLang.XmlLang getXmlLang() {
        return xmlLang;
    }

    /**
     * Words to speak
     *
     * @return Words to speak
     */
    public String getWords() {
        return words;
    }

    /**
     * Create a new {@code <Lang>} element
     */
    public static class Builder extends TwiML.Builder<Builder> {
        private SsmlLang.XmlLang xmlLang;
        private String words;

        /**
         * Create a {@code <Lang>} with words
         */
        public Builder(String words) {
            this.words = words;
        }

        /**
         * Specify the language
         */
        public Builder xmlLang(SsmlLang.XmlLang xmlLang) {
            this.xmlLang = xmlLang;
            return this;
        }

        /**
         * Create and return resulting {@code <Lang>} element
         */
        public SsmlLang build() {
            return new SsmlLang(this);
        }
    }
}