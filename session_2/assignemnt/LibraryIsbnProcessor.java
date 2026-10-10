public class LibraryIsbnProcessor {
    public static String normalizeCode(String raw) {
        if (raw == null) return "";
        String cleaned = raw.replaceAll("[^A-Za-z0-9]", "");
        return cleaned.toUpperCase();
    }

    public static String validateAndFormat(String code) {
        String normalized = normalizeCode(code);

        if (normalized == null || normalized.length() != 13) {
            return "Invalid: wrong length";
        }

        // Validate first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(normalized.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Validate remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(normalized.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        // Extract parts: [PUBCODE] (3) + Year (4) + Catalog (6)
        String pubCode = normalized.substring(0, 3);
        String year = normalized.substring(3, 7);
        String catalog = normalized.substring(7, 13);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] YEAR: ").append(year).append(" | CATALOG: ").append(catalog);

        return sb.toString();
    }

    public static void main(String[] args) {
        String raw1 = " pen2026004251 ";
        String norm1 = normalizeCode(raw1);
        System.out.println(validateAndFormat(norm1));

        String raw2 = "12N2026004251";
        String norm2 = normalizeCode(raw2);
        System.out.println(validateAndFormat(norm2));
    }
}
