public class MixedData implements Comparable<MixedData> {
    private final Integer numericValue;
    private final String stringValue;

    public MixedData(int numericValue) {
        this.numericValue = numericValue;
        this.stringValue = null;
    }

    public MixedData(String stringValue) {
        this.numericValue = null;
        this.stringValue = stringValue;
    }

    @Override
    public int compareTo(MixedData other) {
        if (this.numericValue != null && other.numericValue != null) {
            return this.numericValue.compareTo(other.numericValue);
        } else if (this.stringValue != null && other.stringValue != null) {
            return this.stringValue.compareTo(other.stringValue);
        } else if (this.numericValue != null) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return numericValue != null ? numericValue.toString() : stringValue;
    }
}