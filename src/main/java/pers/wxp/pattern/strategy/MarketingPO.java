package pers.wxp.pattern.strategy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/5/19 9:00
 */
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class MarketingPO {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 营销手段名称 存储class的名称
     */
    private String marketingName;

    /**
     * 入参 多个可以逗号分割
     */
    private String inputVal;

    /**
     * 描述
     */
    private String des;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
