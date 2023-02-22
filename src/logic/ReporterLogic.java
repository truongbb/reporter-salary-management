package logic;

import entity.Reporter;

import java.util.Scanner;

public class ReporterLogic {

    private Reporter[] reporters;

    private int totalReporter;

    public int getTotalReporter() {
        return totalReporter;
    }

    public ReporterLogic(Reporter[] reporters) {
        this.reporters = reporters;
    }

    public Reporter[] getReporters() {
        return reporters;
    }

    public void addNewReporter() {
        System.out.print("Nhập số lượng phóng viên muốn thêm mới: ");
        int reporterNum = new Scanner(System.in).nextInt();
        for (int i = 0; i < reporterNum; i++) {
            System.out.println("Nhập thông tin cho phóng viên thứ " + (i + 1));
            Reporter reporter = new Reporter();
            reporter.inputInfo();
            saveReporter(reporter);
            System.out.println("----------------------");
        }
        totalReporter += reporterNum;
    }

    private void saveReporter(Reporter r) {
        for (int i = 0; i < reporters.length; i++) {
            if (reporters[i] == null) {
                reporters[i] = r;
                break;
            }
        }
    }

    public void showReporters() {
        for (int i = 0; i < reporters.length; i++) {
            if (reporters[i] != null) {
                System.out.println(reporters[i]);
            }
        }
    }

    public Reporter searchById(int id) {
        Reporter ketQua = null;
        for (int j = 0; j < reporters.length; j++) {
            if (reporters[j] != null && reporters[j].getId() == id) {
                ketQua = reporters[j];
                break;
            }
        }
        return ketQua;
    }

}
