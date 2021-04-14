package com.ys.springcloud.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 支付表
 *
 * @author yangsong
 * @since 2020-06-12
 */
@AllArgsConstructor
@NoArgsConstructor
public class Payment extends Model<Payment> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
   @TableId(value="id", type= IdType.AUTO)
   private Long id;
    /**
     * 支付流水号
     */
   private String serial;


   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getSerial() {
      return serial;
   }

   public void setSerial(String serial) {
      this.serial = serial;
   }

   public static final String ID = "id";

   public static final String SERIAL = "serial";

   @Override
   protected Serializable pkVal() {
      return this.id;
   }

   @Override
   public String toString() {
      return "Payment{" +
         "id=" + id +
         ", serial=" + serial +
         "}";
   }
}
