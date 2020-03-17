package cn.zealon.book.common;

/**
 * 数据字典类型
 * @author: zealon
 * @since: 2019/10/26
 */
public enum DataDictionaryEnum {
    CATEGORY("category","书籍分类"),
    CHANNEL("channel","所属频道"),
    SERIAL_STATUS("serial_status","连载状态")
    ;

    private String value;
    private String name;

    DataDictionaryEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

}
