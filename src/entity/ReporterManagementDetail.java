package entity;

public class ReporterManagementDetail {

    private PostType postType;
    private int quantity;

    public ReporterManagementDetail(PostType postType, int quantity) {
        this.postType = postType;
        this.quantity = quantity;
    }

    public PostType getPostType() {
        return postType;
    }

    public void setPostType(PostType postType) {
        this.postType = postType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ReporterManagementDetail{" +
                "postType=" + postType +
                ", quantity=" + quantity +
                '}';
    }
}
