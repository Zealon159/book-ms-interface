package cn.zealon.book.common;

/**
 * 数据字典类型
 * @author: tangyl
 * @since: 2019/10/26
 */
public class DataDictionaryType {

    /** 项目阶段 */
    public final static String PROJECT_STAGE = "project-stage";

    /** 项目申请审核状态 */
    public final static String PROJECT_APPLY_STATUS = "project-apply-status";

    /** 项目审批状态 */
    public final static String PROJECT_CHECK_STATUS = "project-check-status";

    /** 项目文件类型 */
    public final static String PROJECT_FILE_TYPE = "project-file-type";

    /** 项目文件审批状态(承诺阶段的) */
    public final static String PROJECT_FILE_AUDIT_STATUS = "project-file-audit-status";

    /** 项目性质 */
    public final static String PROJECT_NATURE = "project-nature";

    /** 项目监管施工阶段 */
    public final static String PROJECT_SUPERVISION_STAGE = "project-supervision-stage";

    /** 监管 事件严重程度：1:一般,2:严重,3:紧急 */
    public final static String PROJECT_SUPERVISION_SEVERITY = "project-supervision-severity";

    /** 监管 整改情况：1:未整改,2:整改中,3:已整改请检查,4:未通过,5:整改完毕 */
    public final static String PROJECT_SUPERVISION_STATUS = "project-supervision-status";

    /** 联合验收，意见回复 */
    public final static String PROJECT_ACCEPTANCE_REMARK_STATUS = "project-acceptance-r-status";
}
