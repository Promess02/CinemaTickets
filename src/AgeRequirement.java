public enum AgeRequirement {
    THREE_PLUS("3+"), EIGHT_PLUS("8+"),
    TWELVE_PLUS("12+"), SIXTEEN_PLUS("16+"), EIGHTEEN_PLUS("18+");

    String name;
    AgeRequirement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
