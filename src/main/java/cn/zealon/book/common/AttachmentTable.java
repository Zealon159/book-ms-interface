package cn.zealon.book.common;

/**
 * 附件类型
 * @author: tangyl
 * @since: 2019/10/31
 */
public class AttachmentTable {

    /** 项目表 */
    public static final String TABLE_PROJECT = "project";

    /** 企业表 */
    public static final String TABLE_ENTERPRISE = "enterprise";

    /** 监管意见 */
    public static final String TABLE_SUPERVISION = "supervision-items";

    /** 监管意见回复 */
    public static final String TABLE_SUPERVISION_REPLY = "supervision-items-reply";

    /** 项目申请意见 */
    public static final String TABLE_PROJECT_APPLY_REMARK = "project-apply-remark";

    /**  用户表头像 */
    public static final String TABLE_USER = "user";

    /** 联合验收材料（政府上传） */
    public static final String TABLE_ACCEPTANCE_MATERIAL = "acceptance-material";

    /** 联合验收资料申请（企业上传） */
    public static final String TABLE_ACCEPTANCE_APPLY = "acceptance-apply";

    public static class Field {
        /** 施工许可证 */
        public static final String PROJECT_BUILDER_LICENSE = "builder-licence";
        /** 规划许可证 */
        public static final String PROJECT_PLAN_LICENSE = "plan-licence";
    }

}
