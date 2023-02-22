package entity;

import constant.ReporterType;

import java.util.Scanner;

public class Reporter extends Person {

    private int id;
    private ReporterType reporterType;

    private static int AUTO_ID = 10000;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ReporterType getReporterType() {
        return reporterType;
    }

    public void setReporterType(ReporterType reporterType) {
        this.reporterType = reporterType;
    }


    @Override
    public String toString() {
        return "Reporter{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", id=" + id +
                ", reporterType=" + reporterType +
                '}';
    }

    @Override
    public void inputInfo() {
        super.inputInfo();
        this.id = AUTO_ID;
        AUTO_ID++;
        System.out.println("Nhập loại phóng viên là 1 trong các loại dưới đây");
        System.out.println("1. Chuyên nghiệp");
        System.out.println("2. Nghiệp du");
        System.out.println("3. Cộng tác viên");
        System.out.print("Xin mời chọn: ");

        int temp = 0;
        System.out.print("Xin mời nhập lựa chọn: ");
        do {
            temp = new Scanner(System.in).nextInt();
            if (temp >= 1 && temp <= 3) {
                break;
            }
            System.out.print("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
        } while (true);

        switch (temp) {
            case 1:
                this.reporterType = ReporterType.CHUYEN_NGHIEP;
                break;
            case 2:
                this.reporterType = ReporterType.NGHIEP_DU;
                break;
            case 3:
                this.reporterType = ReporterType.CONG_TAC_VIEN;
                break;
        }
    }
}
