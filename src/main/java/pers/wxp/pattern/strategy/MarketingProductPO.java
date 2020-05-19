package pers.wxp.pattern.strategy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/5/19 10:01
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MarketingProductPO {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 营销工具id
     */
    private Integer marketingId;

    /**
     * 产品编号
     */
    private String productNo;

    /**
     * 描述
     */
    private String des;

    /**
     * 是否有效
     */
    private Integer validStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
