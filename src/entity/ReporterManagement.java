package entity;

import java.util.Arrays;

// class này để quản lý danh sách loại bài viết của 1 ông phóng viên
public class ReporterManagement {

    private Reporter reporter; // 1 ông phóng viên
    private ReporterManagementDetail[] reporterManagementDetails; // danh sách các thể loại mà ông này viết
    // kèm theo số lượng bài ở mỗi loại
    private int totalPost;


    public ReporterManagement(Reporter reporter, ReporterManagementDetail[] reporterManagementDetails) {
        this.reporter = reporter;
        this.reporterManagementDetails = reporterManagementDetails;

        int tempTotal = 0;
        for (int i = 0; i < reporterManagementDetails.length; i++) {
            tempTotal += reporterManagementDetails[i].getQuantity();
        }
        this.totalPost = tempTotal;
    }

    public Reporter getReporter() {
        return reporter;
    }

    public void setReporter(Reporter reporter) {
        this.reporter = reporter;
    }

    public ReporterManagementDetail[] getReporterManagementDetails() {
        return reporterManagementDetails;
    }

    public void setReporterManagementDetails(ReporterManagementDetail[] reporterManagementDetails) {
        this.reporterManagementDetails = reporterManagementDetails;
    }

    public int getTotalPost() {
        return totalPost;
    }

    public void setTotalPost(int totalPost) {
        this.totalPost = totalPost;
    }

    @Override
    public String toString() {
        return "ReporterManagement{" +
                "reporter=" + reporter +
                ", reporterManagementDetails=" + Arrays.toString(reporterManagementDetails) +
                '}';
    }

}
