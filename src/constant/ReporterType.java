package constant;

public enum ReporterType {

    CHUYEN_NGHIEP("Chuyên nghiệp"),
    NGHIEP_DU("Nghiệp dư"),
    CONG_TAC_VIEN("Cộng tác viên");

    public String value;

    ReporterType(String value) {
        this.value = value;
    }
}
