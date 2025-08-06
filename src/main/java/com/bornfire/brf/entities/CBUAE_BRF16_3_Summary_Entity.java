
package com.bornfire.brf.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "CBUAE_BRF16_3_SUMMARYTABLE")
public class CBUAE_BRF16_3_Summary_Entity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
	
	private String	r0020_product;
	private BigDecimal	r0020_lfi;
	private BigDecimal	r0020_evidence;
	private BigDecimal	r0020_evidencebylfi;
	private String	r0030_product;
	private BigDecimal	r0030_lfi;
	private BigDecimal	r0030_evidence;
	private BigDecimal	r0030_evidencebylfi;
	private String	r0040_product;
	private BigDecimal	r0040_lfi;
	private BigDecimal	r0040_evidence;
	private BigDecimal	r0040_evidencebylfi;
	private String	r0050_product;
	private BigDecimal	r0050_lfi;
	private BigDecimal	r0050_evidence;
	private BigDecimal	r0050_evidencebylfi;
	private String	r0060_product;
	private BigDecimal	r0060_lfi;
	private BigDecimal	r0060_evidence;
	private BigDecimal	r0060_evidencebylfi;
	private String	r0070_product;
	private BigDecimal	r0070_lfi;
	private BigDecimal	r0070_evidence;
	private BigDecimal	r0070_evidencebylfi;
	private String	r0080_product;
	private BigDecimal	r0080_lfi;
	private BigDecimal	r0080_evidence;
	private BigDecimal	r0080_evidencebylfi;
	private String	r0090_product;
	private BigDecimal	r0090_lfi;
	private BigDecimal	r0090_evidence;
	private BigDecimal	r0090_evidencebylfi;
	private String	r0100_product;
	private BigDecimal	r0100_lfi;
	private BigDecimal	r0100_evidence;
	private BigDecimal	r0100_evidencebylfi;
	private String	r0110_product;
	private BigDecimal	r0110_lfi;
	private BigDecimal	r0110_evidence;
	private BigDecimal	r0110_evidencebylfi;
	private String	r0120_product;
	private BigDecimal	r0120_lfi;
	private BigDecimal	r0120_evidence;
	private BigDecimal	r0120_evidencebylfi;
	private String	r0130_product;
	private BigDecimal	r0130_lfi;
	private BigDecimal	r0130_evidence;
	private BigDecimal	r0130_evidencebylfi;
	private String	r0140_product;
	private BigDecimal	r0140_lfi;
	private BigDecimal	r0140_evidence;
	private BigDecimal	r0140_evidencebylfi;
	private String	r0150_product;
	private BigDecimal	r0150_lfi;
	private BigDecimal	r0150_evidence;
	private BigDecimal	r0150_evidencebylfi;
	private String	r0160_product;
	private BigDecimal	r0160_lfi;
	private BigDecimal	r0160_evidence;
	private BigDecimal	r0160_evidencebylfi;
	private String	r0170_product;
	private BigDecimal	r0170_lfi;
	private BigDecimal	r0170_evidence;
	private BigDecimal	r0170_evidencebylfi;
	private String	r0180_product;
	private BigDecimal	r0180_lfi;
	private BigDecimal	r0180_evidence;
	private BigDecimal	r0180_evidencebylfi;
	private String	r10190_product;
	private BigDecimal	r10190_lfi;
	private BigDecimal	r10190_evidence;
	private BigDecimal	r10190_evidencebylfi;
	private String	r0200_product;
	private BigDecimal	r0200_lfi;
	private BigDecimal	r0200_evidence;
	private BigDecimal	r0200_evidencebylfi;
	private String	r0210_product;
	private BigDecimal	r0210_lfi;
	private BigDecimal	r0210_evidence;
	private BigDecimal	r0210_evidencebylfi;
	private String	r0220_product;
	private BigDecimal	r0220_lfi;
	private BigDecimal	r0220_evidence;
	private BigDecimal	r0220_evidencebylfi;
	private String	r0230_product;
	private BigDecimal	r0230_lfi;
	private BigDecimal	r0230_evidence;
	private BigDecimal	r0230_evidencebylfi;
	private String	r0240_product;
	private BigDecimal	r0240_lfi;
	private BigDecimal	r0240_evidence;
	private BigDecimal	r0240_evidencebylfi;
	private String	r0250_product;
	private BigDecimal	r0250_lfi;
	private BigDecimal	r0250_evidence;
	private BigDecimal	r0250_evidencebylfi;
	private String	r0260_product;
	private BigDecimal	r0260_lfi;
	private BigDecimal	r0260_evidence;
	private BigDecimal	r0260_evidencebylfi;
	private String	r0270_product;
	private BigDecimal	r0270_lfi;
	private BigDecimal	r0270_evidence;
	private BigDecimal	r0270_evidencebylfi;
	private String	r0280_product;
	private BigDecimal	r0280_lfi;
	private BigDecimal	r0280_evidence;
	private BigDecimal	r0280_evidencebylfi;
	private String	r0290_product;
	private BigDecimal	r0290_lfi;
	private BigDecimal	r0290_evidence;
	private BigDecimal	r0290_evidencebylfi;
	private String	r0300_product;
	private BigDecimal	r0300_lfi;
	private BigDecimal	r0300_evidence;
	private BigDecimal	r0300_evidencebylfi;
	private String	r0310_product;
	private BigDecimal	r0310_lfi;
	private BigDecimal	r0310_evidence;
	private BigDecimal	r0310_evidencebylfi;
	private String	r0320_product;
	private BigDecimal	r0320_lfi;
	private BigDecimal	r0320_evidence;
	private BigDecimal	r0320_evidencebylfi;
	private String	r0330_product;
	private BigDecimal	r0330_lfi;
	private BigDecimal	r0330_evidence;
	private BigDecimal	r0330_evidencebylfi;
	private String	r0340_product;
	private BigDecimal	r0340_lfi;
	private BigDecimal	r0340_evidence;
	private BigDecimal	r0340_evidencebylfi;
	private String	r0350_product;
	private BigDecimal	r0350_lfi;
	private BigDecimal	r0350_evidence;
	private BigDecimal	r0350_evidencebylfi;
	private String	r0360_product;
	private BigDecimal	r0360_lfi;
	private BigDecimal	r0360_evidence;
	private BigDecimal	r0360_evidencebylfi;
	private String	r0370_product;
	private BigDecimal	r0370_lfi;
	private BigDecimal	r0370_evidence;
	private BigDecimal	r0370_evidencebylfi;
	private String	r0380_product;
	private BigDecimal	r0380_lfi;
	private BigDecimal	r0380_evidence;
	private BigDecimal	r0380_evidencebylfi;
	private String	r0390_product;
	private BigDecimal	r0390_lfi;
	private BigDecimal	r0390_evidence;
	private BigDecimal	r0390_evidencebylfi;
	private String	r0400_product;
	private BigDecimal	r0400_lfi;
	private BigDecimal	r0400_evidence;
	private BigDecimal	r0400_evidencebylfi;
	private String	r0410_product;
	private BigDecimal	r0410_lfi;
	private BigDecimal	r0410_evidence;
	private BigDecimal	r0410_evidencebylfi;
	private String	r0420_product;
	private BigDecimal	r0420_lfi;
	private BigDecimal	r0420_evidence;
	private BigDecimal	r0420_evidencebylfi;
	private String	r0430_product;
	private BigDecimal	r0430_lfi;
	private BigDecimal	r0430_evidence;
	private BigDecimal	r0430_evidencebylfi;
	private String	r0440_product;
	private BigDecimal	r0440_lfi;
	private BigDecimal	r0440_evidence;
	private BigDecimal	r0440_evidencebylfi;
	private String	r0450_product;
	private BigDecimal	r0450_lfi;
	private BigDecimal	r0450_evidence;
	private BigDecimal	r0450_evidencebylfi;
	private String	r0460_product;
	private BigDecimal	r0460_lfi;
	private BigDecimal	r0460_evidence;
	private BigDecimal	r0460_evidencebylfi;
	private String	r0470_product;
	private BigDecimal	r0470_lfi;
	private BigDecimal	r0470_evidence;
	private BigDecimal	r0470_evidencebylfi;
	private Date	report_date;
	private String	report_version;
	private String	report_frequency;
	private String	report_code;
	private String	report_desc;
	private String	modify_flg;
	private String	entity_flg;
	private String	delete_flg;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getR0020_product() {
		return r0020_product;
	}
	public void setR0020_product(String r0020_product) {
		this.r0020_product = r0020_product;
	}
	public BigDecimal getR0020_lfi() {
		return r0020_lfi;
	}
	public void setR0020_lfi(BigDecimal r0020_lfi) {
		this.r0020_lfi = r0020_lfi;
	}
	public BigDecimal getR0020_evidence() {
		return r0020_evidence;
	}
	public void setR0020_evidence(BigDecimal r0020_evidence) {
		this.r0020_evidence = r0020_evidence;
	}
	public BigDecimal getR0020_evidencebylfi() {
		return r0020_evidencebylfi;
	}
	public void setR0020_evidencebylfi(BigDecimal r0020_evidencebylfi) {
		this.r0020_evidencebylfi = r0020_evidencebylfi;
	}
	public String getR0030_product() {
		return r0030_product;
	}
	public void setR0030_product(String r0030_product) {
		this.r0030_product = r0030_product;
	}
	public BigDecimal getR0030_lfi() {
		return r0030_lfi;
	}
	public void setR0030_lfi(BigDecimal r0030_lfi) {
		this.r0030_lfi = r0030_lfi;
	}
	public BigDecimal getR0030_evidence() {
		return r0030_evidence;
	}
	public void setR0030_evidence(BigDecimal r0030_evidence) {
		this.r0030_evidence = r0030_evidence;
	}
	public BigDecimal getR0030_evidencebylfi() {
		return r0030_evidencebylfi;
	}
	public void setR0030_evidencebylfi(BigDecimal r0030_evidencebylfi) {
		this.r0030_evidencebylfi = r0030_evidencebylfi;
	}
	public String getR0040_product() {
		return r0040_product;
	}
	public void setR0040_product(String r0040_product) {
		this.r0040_product = r0040_product;
	}
	public BigDecimal getR0040_lfi() {
		return r0040_lfi;
	}
	public void setR0040_lfi(BigDecimal r0040_lfi) {
		this.r0040_lfi = r0040_lfi;
	}
	public BigDecimal getR0040_evidence() {
		return r0040_evidence;
	}
	public void setR0040_evidence(BigDecimal r0040_evidence) {
		this.r0040_evidence = r0040_evidence;
	}
	public BigDecimal getR0040_evidencebylfi() {
		return r0040_evidencebylfi;
	}
	public void setR0040_evidencebylfi(BigDecimal r0040_evidencebylfi) {
		this.r0040_evidencebylfi = r0040_evidencebylfi;
	}
	public String getR0050_product() {
		return r0050_product;
	}
	public void setR0050_product(String r0050_product) {
		this.r0050_product = r0050_product;
	}
	public BigDecimal getR0050_lfi() {
		return r0050_lfi;
	}
	public void setR0050_lfi(BigDecimal r0050_lfi) {
		this.r0050_lfi = r0050_lfi;
	}
	public BigDecimal getR0050_evidence() {
		return r0050_evidence;
	}
	public void setR0050_evidence(BigDecimal r0050_evidence) {
		this.r0050_evidence = r0050_evidence;
	}
	public BigDecimal getR0050_evidencebylfi() {
		return r0050_evidencebylfi;
	}
	public void setR0050_evidencebylfi(BigDecimal r0050_evidencebylfi) {
		this.r0050_evidencebylfi = r0050_evidencebylfi;
	}
	public String getR0060_product() {
		return r0060_product;
	}
	public void setR0060_product(String r0060_product) {
		this.r0060_product = r0060_product;
	}
	public BigDecimal getR0060_lfi() {
		return r0060_lfi;
	}
	public void setR0060_lfi(BigDecimal r0060_lfi) {
		this.r0060_lfi = r0060_lfi;
	}
	public BigDecimal getR0060_evidence() {
		return r0060_evidence;
	}
	public void setR0060_evidence(BigDecimal r0060_evidence) {
		this.r0060_evidence = r0060_evidence;
	}
	public BigDecimal getR0060_evidencebylfi() {
		return r0060_evidencebylfi;
	}
	public void setR0060_evidencebylfi(BigDecimal r0060_evidencebylfi) {
		this.r0060_evidencebylfi = r0060_evidencebylfi;
	}
	public String getR0070_product() {
		return r0070_product;
	}
	public void setR0070_product(String r0070_product) {
		this.r0070_product = r0070_product;
	}
	public BigDecimal getR0070_lfi() {
		return r0070_lfi;
	}
	public void setR0070_lfi(BigDecimal r0070_lfi) {
		this.r0070_lfi = r0070_lfi;
	}
	public BigDecimal getR0070_evidence() {
		return r0070_evidence;
	}
	public void setR0070_evidence(BigDecimal r0070_evidence) {
		this.r0070_evidence = r0070_evidence;
	}
	public BigDecimal getR0070_evidencebylfi() {
		return r0070_evidencebylfi;
	}
	public void setR0070_evidencebylfi(BigDecimal r0070_evidencebylfi) {
		this.r0070_evidencebylfi = r0070_evidencebylfi;
	}
	public String getR0080_product() {
		return r0080_product;
	}
	public void setR0080_product(String r0080_product) {
		this.r0080_product = r0080_product;
	}
	public BigDecimal getR0080_lfi() {
		return r0080_lfi;
	}
	public void setR0080_lfi(BigDecimal r0080_lfi) {
		this.r0080_lfi = r0080_lfi;
	}
	public BigDecimal getR0080_evidence() {
		return r0080_evidence;
	}
	public void setR0080_evidence(BigDecimal r0080_evidence) {
		this.r0080_evidence = r0080_evidence;
	}
	public BigDecimal getR0080_evidencebylfi() {
		return r0080_evidencebylfi;
	}
	public void setR0080_evidencebylfi(BigDecimal r0080_evidencebylfi) {
		this.r0080_evidencebylfi = r0080_evidencebylfi;
	}
	public String getR0090_product() {
		return r0090_product;
	}
	public void setR0090_product(String r0090_product) {
		this.r0090_product = r0090_product;
	}
	public BigDecimal getR0090_lfi() {
		return r0090_lfi;
	}
	public void setR0090_lfi(BigDecimal r0090_lfi) {
		this.r0090_lfi = r0090_lfi;
	}
	public BigDecimal getR0090_evidence() {
		return r0090_evidence;
	}
	public void setR0090_evidence(BigDecimal r0090_evidence) {
		this.r0090_evidence = r0090_evidence;
	}
	public BigDecimal getR0090_evidencebylfi() {
		return r0090_evidencebylfi;
	}
	public void setR0090_evidencebylfi(BigDecimal r0090_evidencebylfi) {
		this.r0090_evidencebylfi = r0090_evidencebylfi;
	}
	public String getR0100_product() {
		return r0100_product;
	}
	public void setR0100_product(String r0100_product) {
		this.r0100_product = r0100_product;
	}
	public BigDecimal getR0100_lfi() {
		return r0100_lfi;
	}
	public void setR0100_lfi(BigDecimal r0100_lfi) {
		this.r0100_lfi = r0100_lfi;
	}
	public BigDecimal getR0100_evidence() {
		return r0100_evidence;
	}
	public void setR0100_evidence(BigDecimal r0100_evidence) {
		this.r0100_evidence = r0100_evidence;
	}
	public BigDecimal getR0100_evidencebylfi() {
		return r0100_evidencebylfi;
	}
	public void setR0100_evidencebylfi(BigDecimal r0100_evidencebylfi) {
		this.r0100_evidencebylfi = r0100_evidencebylfi;
	}
	public String getR0110_product() {
		return r0110_product;
	}
	public void setR0110_product(String r0110_product) {
		this.r0110_product = r0110_product;
	}
	public BigDecimal getR0110_lfi() {
		return r0110_lfi;
	}
	public void setR0110_lfi(BigDecimal r0110_lfi) {
		this.r0110_lfi = r0110_lfi;
	}
	public BigDecimal getR0110_evidence() {
		return r0110_evidence;
	}
	public void setR0110_evidence(BigDecimal r0110_evidence) {
		this.r0110_evidence = r0110_evidence;
	}
	public BigDecimal getR0110_evidencebylfi() {
		return r0110_evidencebylfi;
	}
	public void setR0110_evidencebylfi(BigDecimal r0110_evidencebylfi) {
		this.r0110_evidencebylfi = r0110_evidencebylfi;
	}
	public String getR0120_product() {
		return r0120_product;
	}
	public void setR0120_product(String r0120_product) {
		this.r0120_product = r0120_product;
	}
	public BigDecimal getR0120_lfi() {
		return r0120_lfi;
	}
	public void setR0120_lfi(BigDecimal r0120_lfi) {
		this.r0120_lfi = r0120_lfi;
	}
	public BigDecimal getR0120_evidence() {
		return r0120_evidence;
	}
	public void setR0120_evidence(BigDecimal r0120_evidence) {
		this.r0120_evidence = r0120_evidence;
	}
	public BigDecimal getR0120_evidencebylfi() {
		return r0120_evidencebylfi;
	}
	public void setR0120_evidencebylfi(BigDecimal r0120_evidencebylfi) {
		this.r0120_evidencebylfi = r0120_evidencebylfi;
	}
	public String getR0130_product() {
		return r0130_product;
	}
	public void setR0130_product(String r0130_product) {
		this.r0130_product = r0130_product;
	}
	public BigDecimal getR0130_lfi() {
		return r0130_lfi;
	}
	public void setR0130_lfi(BigDecimal r0130_lfi) {
		this.r0130_lfi = r0130_lfi;
	}
	public BigDecimal getR0130_evidence() {
		return r0130_evidence;
	}
	public void setR0130_evidence(BigDecimal r0130_evidence) {
		this.r0130_evidence = r0130_evidence;
	}
	public BigDecimal getR0130_evidencebylfi() {
		return r0130_evidencebylfi;
	}
	public void setR0130_evidencebylfi(BigDecimal r0130_evidencebylfi) {
		this.r0130_evidencebylfi = r0130_evidencebylfi;
	}
	public String getR0140_product() {
		return r0140_product;
	}
	public void setR0140_product(String r0140_product) {
		this.r0140_product = r0140_product;
	}
	public BigDecimal getR0140_lfi() {
		return r0140_lfi;
	}
	public void setR0140_lfi(BigDecimal r0140_lfi) {
		this.r0140_lfi = r0140_lfi;
	}
	public BigDecimal getR0140_evidence() {
		return r0140_evidence;
	}
	public void setR0140_evidence(BigDecimal r0140_evidence) {
		this.r0140_evidence = r0140_evidence;
	}
	public BigDecimal getR0140_evidencebylfi() {
		return r0140_evidencebylfi;
	}
	public void setR0140_evidencebylfi(BigDecimal r0140_evidencebylfi) {
		this.r0140_evidencebylfi = r0140_evidencebylfi;
	}
	public String getR0150_product() {
		return r0150_product;
	}
	public void setR0150_product(String r0150_product) {
		this.r0150_product = r0150_product;
	}
	public BigDecimal getR0150_lfi() {
		return r0150_lfi;
	}
	public void setR0150_lfi(BigDecimal r0150_lfi) {
		this.r0150_lfi = r0150_lfi;
	}
	public BigDecimal getR0150_evidence() {
		return r0150_evidence;
	}
	public void setR0150_evidence(BigDecimal r0150_evidence) {
		this.r0150_evidence = r0150_evidence;
	}
	public BigDecimal getR0150_evidencebylfi() {
		return r0150_evidencebylfi;
	}
	public void setR0150_evidencebylfi(BigDecimal r0150_evidencebylfi) {
		this.r0150_evidencebylfi = r0150_evidencebylfi;
	}
	public String getR0160_product() {
		return r0160_product;
	}
	public void setR0160_product(String r0160_product) {
		this.r0160_product = r0160_product;
	}
	public BigDecimal getR0160_lfi() {
		return r0160_lfi;
	}
	public void setR0160_lfi(BigDecimal r0160_lfi) {
		this.r0160_lfi = r0160_lfi;
	}
	public BigDecimal getR0160_evidence() {
		return r0160_evidence;
	}
	public void setR0160_evidence(BigDecimal r0160_evidence) {
		this.r0160_evidence = r0160_evidence;
	}
	public BigDecimal getR0160_evidencebylfi() {
		return r0160_evidencebylfi;
	}
	public void setR0160_evidencebylfi(BigDecimal r0160_evidencebylfi) {
		this.r0160_evidencebylfi = r0160_evidencebylfi;
	}
	public String getR0170_product() {
		return r0170_product;
	}
	public void setR0170_product(String r0170_product) {
		this.r0170_product = r0170_product;
	}
	public BigDecimal getR0170_lfi() {
		return r0170_lfi;
	}
	public void setR0170_lfi(BigDecimal r0170_lfi) {
		this.r0170_lfi = r0170_lfi;
	}
	public BigDecimal getR0170_evidence() {
		return r0170_evidence;
	}
	public void setR0170_evidence(BigDecimal r0170_evidence) {
		this.r0170_evidence = r0170_evidence;
	}
	public BigDecimal getR0170_evidencebylfi() {
		return r0170_evidencebylfi;
	}
	public void setR0170_evidencebylfi(BigDecimal r0170_evidencebylfi) {
		this.r0170_evidencebylfi = r0170_evidencebylfi;
	}
	public String getR0180_product() {
		return r0180_product;
	}
	public void setR0180_product(String r0180_product) {
		this.r0180_product = r0180_product;
	}
	public BigDecimal getR0180_lfi() {
		return r0180_lfi;
	}
	public void setR0180_lfi(BigDecimal r0180_lfi) {
		this.r0180_lfi = r0180_lfi;
	}
	public BigDecimal getR0180_evidence() {
		return r0180_evidence;
	}
	public void setR0180_evidence(BigDecimal r0180_evidence) {
		this.r0180_evidence = r0180_evidence;
	}
	public BigDecimal getR0180_evidencebylfi() {
		return r0180_evidencebylfi;
	}
	public void setR0180_evidencebylfi(BigDecimal r0180_evidencebylfi) {
		this.r0180_evidencebylfi = r0180_evidencebylfi;
	}
	public String getR10190_product() {
		return r10190_product;
	}
	public void setR10190_product(String r10190_product) {
		this.r10190_product = r10190_product;
	}
	public BigDecimal getR10190_lfi() {
		return r10190_lfi;
	}
	public void setR10190_lfi(BigDecimal r10190_lfi) {
		this.r10190_lfi = r10190_lfi;
	}
	public BigDecimal getR10190_evidence() {
		return r10190_evidence;
	}
	public void setR10190_evidence(BigDecimal r10190_evidence) {
		this.r10190_evidence = r10190_evidence;
	}
	public BigDecimal getR10190_evidencebylfi() {
		return r10190_evidencebylfi;
	}
	public void setR10190_evidencebylfi(BigDecimal r10190_evidencebylfi) {
		this.r10190_evidencebylfi = r10190_evidencebylfi;
	}
	public String getR0200_product() {
		return r0200_product;
	}
	public void setR0200_product(String r0200_product) {
		this.r0200_product = r0200_product;
	}
	public BigDecimal getR0200_lfi() {
		return r0200_lfi;
	}
	public void setR0200_lfi(BigDecimal r0200_lfi) {
		this.r0200_lfi = r0200_lfi;
	}
	public BigDecimal getR0200_evidence() {
		return r0200_evidence;
	}
	public void setR0200_evidence(BigDecimal r0200_evidence) {
		this.r0200_evidence = r0200_evidence;
	}
	public BigDecimal getR0200_evidencebylfi() {
		return r0200_evidencebylfi;
	}
	public void setR0200_evidencebylfi(BigDecimal r0200_evidencebylfi) {
		this.r0200_evidencebylfi = r0200_evidencebylfi;
	}
	public String getR0210_product() {
		return r0210_product;
	}
	public void setR0210_product(String r0210_product) {
		this.r0210_product = r0210_product;
	}
	public BigDecimal getR0210_lfi() {
		return r0210_lfi;
	}
	public void setR0210_lfi(BigDecimal r0210_lfi) {
		this.r0210_lfi = r0210_lfi;
	}
	public BigDecimal getR0210_evidence() {
		return r0210_evidence;
	}
	public void setR0210_evidence(BigDecimal r0210_evidence) {
		this.r0210_evidence = r0210_evidence;
	}
	public BigDecimal getR0210_evidencebylfi() {
		return r0210_evidencebylfi;
	}
	public void setR0210_evidencebylfi(BigDecimal r0210_evidencebylfi) {
		this.r0210_evidencebylfi = r0210_evidencebylfi;
	}
	public String getR0220_product() {
		return r0220_product;
	}
	public void setR0220_product(String r0220_product) {
		this.r0220_product = r0220_product;
	}
	public BigDecimal getR0220_lfi() {
		return r0220_lfi;
	}
	public void setR0220_lfi(BigDecimal r0220_lfi) {
		this.r0220_lfi = r0220_lfi;
	}
	public BigDecimal getR0220_evidence() {
		return r0220_evidence;
	}
	public void setR0220_evidence(BigDecimal r0220_evidence) {
		this.r0220_evidence = r0220_evidence;
	}
	public BigDecimal getR0220_evidencebylfi() {
		return r0220_evidencebylfi;
	}
	public void setR0220_evidencebylfi(BigDecimal r0220_evidencebylfi) {
		this.r0220_evidencebylfi = r0220_evidencebylfi;
	}
	public String getR0230_product() {
		return r0230_product;
	}
	public void setR0230_product(String r0230_product) {
		this.r0230_product = r0230_product;
	}
	public BigDecimal getR0230_lfi() {
		return r0230_lfi;
	}
	public void setR0230_lfi(BigDecimal r0230_lfi) {
		this.r0230_lfi = r0230_lfi;
	}
	public BigDecimal getR0230_evidence() {
		return r0230_evidence;
	}
	public void setR0230_evidence(BigDecimal r0230_evidence) {
		this.r0230_evidence = r0230_evidence;
	}
	public BigDecimal getR0230_evidencebylfi() {
		return r0230_evidencebylfi;
	}
	public void setR0230_evidencebylfi(BigDecimal r0230_evidencebylfi) {
		this.r0230_evidencebylfi = r0230_evidencebylfi;
	}
	public String getR0240_product() {
		return r0240_product;
	}
	public void setR0240_product(String r0240_product) {
		this.r0240_product = r0240_product;
	}
	public BigDecimal getR0240_lfi() {
		return r0240_lfi;
	}
	public void setR0240_lfi(BigDecimal r0240_lfi) {
		this.r0240_lfi = r0240_lfi;
	}
	public BigDecimal getR0240_evidence() {
		return r0240_evidence;
	}
	public void setR0240_evidence(BigDecimal r0240_evidence) {
		this.r0240_evidence = r0240_evidence;
	}
	public BigDecimal getR0240_evidencebylfi() {
		return r0240_evidencebylfi;
	}
	public void setR0240_evidencebylfi(BigDecimal r0240_evidencebylfi) {
		this.r0240_evidencebylfi = r0240_evidencebylfi;
	}
	public String getR0250_product() {
		return r0250_product;
	}
	public void setR0250_product(String r0250_product) {
		this.r0250_product = r0250_product;
	}
	public BigDecimal getR0250_lfi() {
		return r0250_lfi;
	}
	public void setR0250_lfi(BigDecimal r0250_lfi) {
		this.r0250_lfi = r0250_lfi;
	}
	public BigDecimal getR0250_evidence() {
		return r0250_evidence;
	}
	public void setR0250_evidence(BigDecimal r0250_evidence) {
		this.r0250_evidence = r0250_evidence;
	}
	public BigDecimal getR0250_evidencebylfi() {
		return r0250_evidencebylfi;
	}
	public void setR0250_evidencebylfi(BigDecimal r0250_evidencebylfi) {
		this.r0250_evidencebylfi = r0250_evidencebylfi;
	}
	public String getR0260_product() {
		return r0260_product;
	}
	public void setR0260_product(String r0260_product) {
		this.r0260_product = r0260_product;
	}
	public BigDecimal getR0260_lfi() {
		return r0260_lfi;
	}
	public void setR0260_lfi(BigDecimal r0260_lfi) {
		this.r0260_lfi = r0260_lfi;
	}
	public BigDecimal getR0260_evidence() {
		return r0260_evidence;
	}
	public void setR0260_evidence(BigDecimal r0260_evidence) {
		this.r0260_evidence = r0260_evidence;
	}
	public BigDecimal getR0260_evidencebylfi() {
		return r0260_evidencebylfi;
	}
	public void setR0260_evidencebylfi(BigDecimal r0260_evidencebylfi) {
		this.r0260_evidencebylfi = r0260_evidencebylfi;
	}
	public String getR0270_product() {
		return r0270_product;
	}
	public void setR0270_product(String r0270_product) {
		this.r0270_product = r0270_product;
	}
	public BigDecimal getR0270_lfi() {
		return r0270_lfi;
	}
	public void setR0270_lfi(BigDecimal r0270_lfi) {
		this.r0270_lfi = r0270_lfi;
	}
	public BigDecimal getR0270_evidence() {
		return r0270_evidence;
	}
	public void setR0270_evidence(BigDecimal r0270_evidence) {
		this.r0270_evidence = r0270_evidence;
	}
	public BigDecimal getR0270_evidencebylfi() {
		return r0270_evidencebylfi;
	}
	public void setR0270_evidencebylfi(BigDecimal r0270_evidencebylfi) {
		this.r0270_evidencebylfi = r0270_evidencebylfi;
	}
	public String getR0280_product() {
		return r0280_product;
	}
	public void setR0280_product(String r0280_product) {
		this.r0280_product = r0280_product;
	}
	public BigDecimal getR0280_lfi() {
		return r0280_lfi;
	}
	public void setR0280_lfi(BigDecimal r0280_lfi) {
		this.r0280_lfi = r0280_lfi;
	}
	public BigDecimal getR0280_evidence() {
		return r0280_evidence;
	}
	public void setR0280_evidence(BigDecimal r0280_evidence) {
		this.r0280_evidence = r0280_evidence;
	}
	public BigDecimal getR0280_evidencebylfi() {
		return r0280_evidencebylfi;
	}
	public void setR0280_evidencebylfi(BigDecimal r0280_evidencebylfi) {
		this.r0280_evidencebylfi = r0280_evidencebylfi;
	}
	public String getR0290_product() {
		return r0290_product;
	}
	public void setR0290_product(String r0290_product) {
		this.r0290_product = r0290_product;
	}
	public BigDecimal getR0290_lfi() {
		return r0290_lfi;
	}
	public void setR0290_lfi(BigDecimal r0290_lfi) {
		this.r0290_lfi = r0290_lfi;
	}
	public BigDecimal getR0290_evidence() {
		return r0290_evidence;
	}
	public void setR0290_evidence(BigDecimal r0290_evidence) {
		this.r0290_evidence = r0290_evidence;
	}
	public BigDecimal getR0290_evidencebylfi() {
		return r0290_evidencebylfi;
	}
	public void setR0290_evidencebylfi(BigDecimal r0290_evidencebylfi) {
		this.r0290_evidencebylfi = r0290_evidencebylfi;
	}
	public String getR0300_product() {
		return r0300_product;
	}
	public void setR0300_product(String r0300_product) {
		this.r0300_product = r0300_product;
	}
	public BigDecimal getR0300_lfi() {
		return r0300_lfi;
	}
	public void setR0300_lfi(BigDecimal r0300_lfi) {
		this.r0300_lfi = r0300_lfi;
	}
	public BigDecimal getR0300_evidence() {
		return r0300_evidence;
	}
	public void setR0300_evidence(BigDecimal r0300_evidence) {
		this.r0300_evidence = r0300_evidence;
	}
	public BigDecimal getR0300_evidencebylfi() {
		return r0300_evidencebylfi;
	}
	public void setR0300_evidencebylfi(BigDecimal r0300_evidencebylfi) {
		this.r0300_evidencebylfi = r0300_evidencebylfi;
	}
	public String getR0310_product() {
		return r0310_product;
	}
	public void setR0310_product(String r0310_product) {
		this.r0310_product = r0310_product;
	}
	public BigDecimal getR0310_lfi() {
		return r0310_lfi;
	}
	public void setR0310_lfi(BigDecimal r0310_lfi) {
		this.r0310_lfi = r0310_lfi;
	}
	public BigDecimal getR0310_evidence() {
		return r0310_evidence;
	}
	public void setR0310_evidence(BigDecimal r0310_evidence) {
		this.r0310_evidence = r0310_evidence;
	}
	public BigDecimal getR0310_evidencebylfi() {
		return r0310_evidencebylfi;
	}
	public void setR0310_evidencebylfi(BigDecimal r0310_evidencebylfi) {
		this.r0310_evidencebylfi = r0310_evidencebylfi;
	}
	public String getR0320_product() {
		return r0320_product;
	}
	public void setR0320_product(String r0320_product) {
		this.r0320_product = r0320_product;
	}
	public BigDecimal getR0320_lfi() {
		return r0320_lfi;
	}
	public void setR0320_lfi(BigDecimal r0320_lfi) {
		this.r0320_lfi = r0320_lfi;
	}
	public BigDecimal getR0320_evidence() {
		return r0320_evidence;
	}
	public void setR0320_evidence(BigDecimal r0320_evidence) {
		this.r0320_evidence = r0320_evidence;
	}
	public BigDecimal getR0320_evidencebylfi() {
		return r0320_evidencebylfi;
	}
	public void setR0320_evidencebylfi(BigDecimal r0320_evidencebylfi) {
		this.r0320_evidencebylfi = r0320_evidencebylfi;
	}
	public String getR0330_product() {
		return r0330_product;
	}
	public void setR0330_product(String r0330_product) {
		this.r0330_product = r0330_product;
	}
	public BigDecimal getR0330_lfi() {
		return r0330_lfi;
	}
	public void setR0330_lfi(BigDecimal r0330_lfi) {
		this.r0330_lfi = r0330_lfi;
	}
	public BigDecimal getR0330_evidence() {
		return r0330_evidence;
	}
	public void setR0330_evidence(BigDecimal r0330_evidence) {
		this.r0330_evidence = r0330_evidence;
	}
	public BigDecimal getR0330_evidencebylfi() {
		return r0330_evidencebylfi;
	}
	public void setR0330_evidencebylfi(BigDecimal r0330_evidencebylfi) {
		this.r0330_evidencebylfi = r0330_evidencebylfi;
	}
	public String getR0340_product() {
		return r0340_product;
	}
	public void setR0340_product(String r0340_product) {
		this.r0340_product = r0340_product;
	}
	public BigDecimal getR0340_lfi() {
		return r0340_lfi;
	}
	public void setR0340_lfi(BigDecimal r0340_lfi) {
		this.r0340_lfi = r0340_lfi;
	}
	public BigDecimal getR0340_evidence() {
		return r0340_evidence;
	}
	public void setR0340_evidence(BigDecimal r0340_evidence) {
		this.r0340_evidence = r0340_evidence;
	}
	public BigDecimal getR0340_evidencebylfi() {
		return r0340_evidencebylfi;
	}
	public void setR0340_evidencebylfi(BigDecimal r0340_evidencebylfi) {
		this.r0340_evidencebylfi = r0340_evidencebylfi;
	}
	public String getR0350_product() {
		return r0350_product;
	}
	public void setR0350_product(String r0350_product) {
		this.r0350_product = r0350_product;
	}
	public BigDecimal getR0350_lfi() {
		return r0350_lfi;
	}
	public void setR0350_lfi(BigDecimal r0350_lfi) {
		this.r0350_lfi = r0350_lfi;
	}
	public BigDecimal getR0350_evidence() {
		return r0350_evidence;
	}
	public void setR0350_evidence(BigDecimal r0350_evidence) {
		this.r0350_evidence = r0350_evidence;
	}
	public BigDecimal getR0350_evidencebylfi() {
		return r0350_evidencebylfi;
	}
	public void setR0350_evidencebylfi(BigDecimal r0350_evidencebylfi) {
		this.r0350_evidencebylfi = r0350_evidencebylfi;
	}
	public String getR0360_product() {
		return r0360_product;
	}
	public void setR0360_product(String r0360_product) {
		this.r0360_product = r0360_product;
	}
	public BigDecimal getR0360_lfi() {
		return r0360_lfi;
	}
	public void setR0360_lfi(BigDecimal r0360_lfi) {
		this.r0360_lfi = r0360_lfi;
	}
	public BigDecimal getR0360_evidence() {
		return r0360_evidence;
	}
	public void setR0360_evidence(BigDecimal r0360_evidence) {
		this.r0360_evidence = r0360_evidence;
	}
	public BigDecimal getR0360_evidencebylfi() {
		return r0360_evidencebylfi;
	}
	public void setR0360_evidencebylfi(BigDecimal r0360_evidencebylfi) {
		this.r0360_evidencebylfi = r0360_evidencebylfi;
	}
	public String getR0370_product() {
		return r0370_product;
	}
	public void setR0370_product(String r0370_product) {
		this.r0370_product = r0370_product;
	}
	public BigDecimal getR0370_lfi() {
		return r0370_lfi;
	}
	public void setR0370_lfi(BigDecimal r0370_lfi) {
		this.r0370_lfi = r0370_lfi;
	}
	public BigDecimal getR0370_evidence() {
		return r0370_evidence;
	}
	public void setR0370_evidence(BigDecimal r0370_evidence) {
		this.r0370_evidence = r0370_evidence;
	}
	public BigDecimal getR0370_evidencebylfi() {
		return r0370_evidencebylfi;
	}
	public void setR0370_evidencebylfi(BigDecimal r0370_evidencebylfi) {
		this.r0370_evidencebylfi = r0370_evidencebylfi;
	}
	public String getR0380_product() {
		return r0380_product;
	}
	public void setR0380_product(String r0380_product) {
		this.r0380_product = r0380_product;
	}
	public BigDecimal getR0380_lfi() {
		return r0380_lfi;
	}
	public void setR0380_lfi(BigDecimal r0380_lfi) {
		this.r0380_lfi = r0380_lfi;
	}
	public BigDecimal getR0380_evidence() {
		return r0380_evidence;
	}
	public void setR0380_evidence(BigDecimal r0380_evidence) {
		this.r0380_evidence = r0380_evidence;
	}
	public BigDecimal getR0380_evidencebylfi() {
		return r0380_evidencebylfi;
	}
	public void setR0380_evidencebylfi(BigDecimal r0380_evidencebylfi) {
		this.r0380_evidencebylfi = r0380_evidencebylfi;
	}
	public String getR0390_product() {
		return r0390_product;
	}
	public void setR0390_product(String r0390_product) {
		this.r0390_product = r0390_product;
	}
	public BigDecimal getR0390_lfi() {
		return r0390_lfi;
	}
	public void setR0390_lfi(BigDecimal r0390_lfi) {
		this.r0390_lfi = r0390_lfi;
	}
	public BigDecimal getR0390_evidence() {
		return r0390_evidence;
	}
	public void setR0390_evidence(BigDecimal r0390_evidence) {
		this.r0390_evidence = r0390_evidence;
	}
	public BigDecimal getR0390_evidencebylfi() {
		return r0390_evidencebylfi;
	}
	public void setR0390_evidencebylfi(BigDecimal r0390_evidencebylfi) {
		this.r0390_evidencebylfi = r0390_evidencebylfi;
	}
	public String getR0400_product() {
		return r0400_product;
	}
	public void setR0400_product(String r0400_product) {
		this.r0400_product = r0400_product;
	}
	public BigDecimal getR0400_lfi() {
		return r0400_lfi;
	}
	public void setR0400_lfi(BigDecimal r0400_lfi) {
		this.r0400_lfi = r0400_lfi;
	}
	public BigDecimal getR0400_evidence() {
		return r0400_evidence;
	}
	public void setR0400_evidence(BigDecimal r0400_evidence) {
		this.r0400_evidence = r0400_evidence;
	}
	public BigDecimal getR0400_evidencebylfi() {
		return r0400_evidencebylfi;
	}
	public void setR0400_evidencebylfi(BigDecimal r0400_evidencebylfi) {
		this.r0400_evidencebylfi = r0400_evidencebylfi;
	}
	public String getR0410_product() {
		return r0410_product;
	}
	public void setR0410_product(String r0410_product) {
		this.r0410_product = r0410_product;
	}
	public BigDecimal getR0410_lfi() {
		return r0410_lfi;
	}
	public void setR0410_lfi(BigDecimal r0410_lfi) {
		this.r0410_lfi = r0410_lfi;
	}
	public BigDecimal getR0410_evidence() {
		return r0410_evidence;
	}
	public void setR0410_evidence(BigDecimal r0410_evidence) {
		this.r0410_evidence = r0410_evidence;
	}
	public BigDecimal getR0410_evidencebylfi() {
		return r0410_evidencebylfi;
	}
	public void setR0410_evidencebylfi(BigDecimal r0410_evidencebylfi) {
		this.r0410_evidencebylfi = r0410_evidencebylfi;
	}
	public String getR0420_product() {
		return r0420_product;
	}
	public void setR0420_product(String r0420_product) {
		this.r0420_product = r0420_product;
	}
	public BigDecimal getR0420_lfi() {
		return r0420_lfi;
	}
	public void setR0420_lfi(BigDecimal r0420_lfi) {
		this.r0420_lfi = r0420_lfi;
	}
	public BigDecimal getR0420_evidence() {
		return r0420_evidence;
	}
	public void setR0420_evidence(BigDecimal r0420_evidence) {
		this.r0420_evidence = r0420_evidence;
	}
	public BigDecimal getR0420_evidencebylfi() {
		return r0420_evidencebylfi;
	}
	public void setR0420_evidencebylfi(BigDecimal r0420_evidencebylfi) {
		this.r0420_evidencebylfi = r0420_evidencebylfi;
	}
	public String getR0430_product() {
		return r0430_product;
	}
	public void setR0430_product(String r0430_product) {
		this.r0430_product = r0430_product;
	}
	public BigDecimal getR0430_lfi() {
		return r0430_lfi;
	}
	public void setR0430_lfi(BigDecimal r0430_lfi) {
		this.r0430_lfi = r0430_lfi;
	}
	public BigDecimal getR0430_evidence() {
		return r0430_evidence;
	}
	public void setR0430_evidence(BigDecimal r0430_evidence) {
		this.r0430_evidence = r0430_evidence;
	}
	public BigDecimal getR0430_evidencebylfi() {
		return r0430_evidencebylfi;
	}
	public void setR0430_evidencebylfi(BigDecimal r0430_evidencebylfi) {
		this.r0430_evidencebylfi = r0430_evidencebylfi;
	}
	public String getR0440_product() {
		return r0440_product;
	}
	public void setR0440_product(String r0440_product) {
		this.r0440_product = r0440_product;
	}
	public BigDecimal getR0440_lfi() {
		return r0440_lfi;
	}
	public void setR0440_lfi(BigDecimal r0440_lfi) {
		this.r0440_lfi = r0440_lfi;
	}
	public BigDecimal getR0440_evidence() {
		return r0440_evidence;
	}
	public void setR0440_evidence(BigDecimal r0440_evidence) {
		this.r0440_evidence = r0440_evidence;
	}
	public BigDecimal getR0440_evidencebylfi() {
		return r0440_evidencebylfi;
	}
	public void setR0440_evidencebylfi(BigDecimal r0440_evidencebylfi) {
		this.r0440_evidencebylfi = r0440_evidencebylfi;
	}
	public String getR0450_product() {
		return r0450_product;
	}
	public void setR0450_product(String r0450_product) {
		this.r0450_product = r0450_product;
	}
	public BigDecimal getR0450_lfi() {
		return r0450_lfi;
	}
	public void setR0450_lfi(BigDecimal r0450_lfi) {
		this.r0450_lfi = r0450_lfi;
	}
	public BigDecimal getR0450_evidence() {
		return r0450_evidence;
	}
	public void setR0450_evidence(BigDecimal r0450_evidence) {
		this.r0450_evidence = r0450_evidence;
	}
	public BigDecimal getR0450_evidencebylfi() {
		return r0450_evidencebylfi;
	}
	public void setR0450_evidencebylfi(BigDecimal r0450_evidencebylfi) {
		this.r0450_evidencebylfi = r0450_evidencebylfi;
	}
	public String getR0460_product() {
		return r0460_product;
	}
	public void setR0460_product(String r0460_product) {
		this.r0460_product = r0460_product;
	}
	public BigDecimal getR0460_lfi() {
		return r0460_lfi;
	}
	public void setR0460_lfi(BigDecimal r0460_lfi) {
		this.r0460_lfi = r0460_lfi;
	}
	public BigDecimal getR0460_evidence() {
		return r0460_evidence;
	}
	public void setR0460_evidence(BigDecimal r0460_evidence) {
		this.r0460_evidence = r0460_evidence;
	}
	public BigDecimal getR0460_evidencebylfi() {
		return r0460_evidencebylfi;
	}
	public void setR0460_evidencebylfi(BigDecimal r0460_evidencebylfi) {
		this.r0460_evidencebylfi = r0460_evidencebylfi;
	}
	public String getR0470_product() {
		return r0470_product;
	}
	public void setR0470_product(String r0470_product) {
		this.r0470_product = r0470_product;
	}
	public BigDecimal getR0470_lfi() {
		return r0470_lfi;
	}
	public void setR0470_lfi(BigDecimal r0470_lfi) {
		this.r0470_lfi = r0470_lfi;
	}
	public BigDecimal getR0470_evidence() {
		return r0470_evidence;
	}
	public void setR0470_evidence(BigDecimal r0470_evidence) {
		this.r0470_evidence = r0470_evidence;
	}
	public BigDecimal getR0470_evidencebylfi() {
		return r0470_evidencebylfi;
	}
	public void setR0470_evidencebylfi(BigDecimal r0470_evidencebylfi) {
		this.r0470_evidencebylfi = r0470_evidencebylfi;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public String getReport_version() {
		return report_version;
	}
	public void setReport_version(String report_version) {
		this.report_version = report_version;
	}
	public String getReport_frequency() {
		return report_frequency;
	}
	public void setReport_frequency(String report_frequency) {
		this.report_frequency = report_frequency;
	}
	public String getReport_code() {
		return report_code;
	}
	public void setReport_code(String report_code) {
		this.report_code = report_code;
	}
	public String getReport_desc() {
		return report_desc;
	}
	public void setReport_desc(String report_desc) {
		this.report_desc = report_desc;
	}
	public String getModify_flg() {
		return modify_flg;
	}
	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}
	public String getEntity_flg() {
		return entity_flg;
	}
	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}
	public String getDelete_flg() {
		return delete_flg;
	}
	public void setDelete_flg(String delete_flg) {
		this.delete_flg = delete_flg;
	}
	public CBUAE_BRF16_3_Summary_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}


}
