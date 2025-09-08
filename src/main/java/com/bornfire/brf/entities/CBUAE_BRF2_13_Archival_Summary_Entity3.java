package com.bornfire.brf.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "CBUAE_BRF2_13_ARCHIVALTABLE_SUMMARYTABLE3")

public class CBUAE_BRF2_13_Archival_Summary_Entity3 {
	
	private String	r1610_product;
	private BigDecimal	r1610_aed_amount;
	private BigDecimal	r1610_fcy_amount;
	private BigDecimal	r1610_total;
	private BigDecimal	r1610_non_commercial_entities;
	private BigDecimal	r1610_commercial_entities;
	private BigDecimal	r1610_private_corporates;
	private BigDecimal	r1610_sme;
	private BigDecimal	r1610_individuals;
	private BigDecimal	r1610_minimum_rate;
	private BigDecimal	r1610_maximum_rate;
	private BigDecimal	r1610_average_rate;
	private String	r1620_product;
	private BigDecimal	r1620_aed_amount;
	private BigDecimal	r1620_fcy_amount;
	private BigDecimal	r1620_total;
	private BigDecimal	r1620_non_commercial_entities;
	private BigDecimal	r1620_commercial_entities;
	private BigDecimal	r1620_private_corporates;
	private BigDecimal	r1620_sme;
	private BigDecimal	r1620_individuals;
	private BigDecimal	r1620_minimum_rate;
	private BigDecimal	r1620_maximum_rate;
	private BigDecimal	r1620_average_rate;
	private String	r1630_product;
	private BigDecimal	r1630_aed_amount;
	private BigDecimal	r1630_fcy_amount;
	private BigDecimal	r1630_total;
	private BigDecimal	r1630_non_commercial_entities;
	private BigDecimal	r1630_commercial_entities;
	private BigDecimal	r1630_private_corporates;
	private BigDecimal	r1630_sme;
	private BigDecimal	r1630_individuals;
	private BigDecimal	r1630_minimum_rate;
	private BigDecimal	r1630_maximum_rate;
	private BigDecimal	r1630_average_rate;
	private String	r1640_product;
	private BigDecimal	r1640_aed_amount;
	private BigDecimal	r1640_fcy_amount;
	private BigDecimal	r1640_total;
	private BigDecimal	r1640_non_commercial_entities;
	private BigDecimal	r1640_commercial_entities;
	private BigDecimal	r1640_private_corporates;
	private BigDecimal	r1640_sme;
	private BigDecimal	r1640_individuals;
	private BigDecimal	r1640_minimum_rate;
	private BigDecimal	r1640_maximum_rate;
	private BigDecimal	r1640_average_rate;
	private String	r1650_product;
	private BigDecimal	r1650_aed_amount;
	private BigDecimal	r1650_fcy_amount;
	private BigDecimal	r1650_total;
	private BigDecimal	r1650_non_commercial_entities;
	private BigDecimal	r1650_commercial_entities;
	private BigDecimal	r1650_private_corporates;
	private BigDecimal	r1650_sme;
	private BigDecimal	r1650_individuals;
	private BigDecimal	r1650_minimum_rate;
	private BigDecimal	r1650_maximum_rate;
	private BigDecimal	r1650_average_rate;
	private String	r1660_product;
	private BigDecimal	r1660_aed_amount;
	private BigDecimal	r1660_fcy_amount;
	private BigDecimal	r1660_total;
	private BigDecimal	r1660_non_commercial_entities;
	private BigDecimal	r1660_commercial_entities;
	private BigDecimal	r1660_private_corporates;
	private BigDecimal	r1660_sme;
	private BigDecimal	r1660_individuals;
	private BigDecimal	r1660_minimum_rate;
	private BigDecimal	r1660_maximum_rate;
	private BigDecimal	r1660_average_rate;
	private String	r1670_product;
	private BigDecimal	r1670_aed_amount;
	private BigDecimal	r1670_fcy_amount;
	private BigDecimal	r1670_total;
	private BigDecimal	r1670_non_commercial_entities;
	private BigDecimal	r1670_commercial_entities;
	private BigDecimal	r1670_private_corporates;
	private BigDecimal	r1670_sme;
	private BigDecimal	r1670_individuals;
	private BigDecimal	r1670_minimum_rate;
	private BigDecimal	r1670_maximum_rate;
	private BigDecimal	r1670_average_rate;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Id
	private Date	report_date;
	private String	report_version;
	private String	report_frequency;
	private String	report_code;
	private String	report_desc;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	public String getR1610_product() {
		return r1610_product;
	}
	public void setR1610_product(String r1610_product) {
		this.r1610_product = r1610_product;
	}
	public BigDecimal getR1610_aed_amount() {
		return r1610_aed_amount;
	}
	public void setR1610_aed_amount(BigDecimal r1610_aed_amount) {
		this.r1610_aed_amount = r1610_aed_amount;
	}
	public BigDecimal getR1610_fcy_amount() {
		return r1610_fcy_amount;
	}
	public void setR1610_fcy_amount(BigDecimal r1610_fcy_amount) {
		this.r1610_fcy_amount = r1610_fcy_amount;
	}
	public BigDecimal getR1610_total() {
		return r1610_total;
	}
	public void setR1610_total(BigDecimal r1610_total) {
		this.r1610_total = r1610_total;
	}
	public BigDecimal getR1610_non_commercial_entities() {
		return r1610_non_commercial_entities;
	}
	public void setR1610_non_commercial_entities(BigDecimal r1610_non_commercial_entities) {
		this.r1610_non_commercial_entities = r1610_non_commercial_entities;
	}
	public BigDecimal getR1610_commercial_entities() {
		return r1610_commercial_entities;
	}
	public void setR1610_commercial_entities(BigDecimal r1610_commercial_entities) {
		this.r1610_commercial_entities = r1610_commercial_entities;
	}
	public BigDecimal getR1610_private_corporates() {
		return r1610_private_corporates;
	}
	public void setR1610_private_corporates(BigDecimal r1610_private_corporates) {
		this.r1610_private_corporates = r1610_private_corporates;
	}
	public BigDecimal getR1610_sme() {
		return r1610_sme;
	}
	public void setR1610_sme(BigDecimal r1610_sme) {
		this.r1610_sme = r1610_sme;
	}
	public BigDecimal getR1610_individuals() {
		return r1610_individuals;
	}
	public void setR1610_individuals(BigDecimal r1610_individuals) {
		this.r1610_individuals = r1610_individuals;
	}
	public BigDecimal getR1610_minimum_rate() {
		return r1610_minimum_rate;
	}
	public void setR1610_minimum_rate(BigDecimal r1610_minimum_rate) {
		this.r1610_minimum_rate = r1610_minimum_rate;
	}
	public BigDecimal getR1610_maximum_rate() {
		return r1610_maximum_rate;
	}
	public void setR1610_maximum_rate(BigDecimal r1610_maximum_rate) {
		this.r1610_maximum_rate = r1610_maximum_rate;
	}
	public BigDecimal getR1610_average_rate() {
		return r1610_average_rate;
	}
	public void setR1610_average_rate(BigDecimal r1610_average_rate) {
		this.r1610_average_rate = r1610_average_rate;
	}
	public String getR1620_product() {
		return r1620_product;
	}
	public void setR1620_product(String r1620_product) {
		this.r1620_product = r1620_product;
	}
	public BigDecimal getR1620_aed_amount() {
		return r1620_aed_amount;
	}
	public void setR1620_aed_amount(BigDecimal r1620_aed_amount) {
		this.r1620_aed_amount = r1620_aed_amount;
	}
	public BigDecimal getR1620_fcy_amount() {
		return r1620_fcy_amount;
	}
	public void setR1620_fcy_amount(BigDecimal r1620_fcy_amount) {
		this.r1620_fcy_amount = r1620_fcy_amount;
	}
	public BigDecimal getR1620_total() {
		return r1620_total;
	}
	public void setR1620_total(BigDecimal r1620_total) {
		this.r1620_total = r1620_total;
	}
	public BigDecimal getR1620_non_commercial_entities() {
		return r1620_non_commercial_entities;
	}
	public void setR1620_non_commercial_entities(BigDecimal r1620_non_commercial_entities) {
		this.r1620_non_commercial_entities = r1620_non_commercial_entities;
	}
	public BigDecimal getR1620_commercial_entities() {
		return r1620_commercial_entities;
	}
	public void setR1620_commercial_entities(BigDecimal r1620_commercial_entities) {
		this.r1620_commercial_entities = r1620_commercial_entities;
	}
	public BigDecimal getR1620_private_corporates() {
		return r1620_private_corporates;
	}
	public void setR1620_private_corporates(BigDecimal r1620_private_corporates) {
		this.r1620_private_corporates = r1620_private_corporates;
	}
	public BigDecimal getR1620_sme() {
		return r1620_sme;
	}
	public void setR1620_sme(BigDecimal r1620_sme) {
		this.r1620_sme = r1620_sme;
	}
	public BigDecimal getR1620_individuals() {
		return r1620_individuals;
	}
	public void setR1620_individuals(BigDecimal r1620_individuals) {
		this.r1620_individuals = r1620_individuals;
	}
	public BigDecimal getR1620_minimum_rate() {
		return r1620_minimum_rate;
	}
	public void setR1620_minimum_rate(BigDecimal r1620_minimum_rate) {
		this.r1620_minimum_rate = r1620_minimum_rate;
	}
	public BigDecimal getR1620_maximum_rate() {
		return r1620_maximum_rate;
	}
	public void setR1620_maximum_rate(BigDecimal r1620_maximum_rate) {
		this.r1620_maximum_rate = r1620_maximum_rate;
	}
	public BigDecimal getR1620_average_rate() {
		return r1620_average_rate;
	}
	public void setR1620_average_rate(BigDecimal r1620_average_rate) {
		this.r1620_average_rate = r1620_average_rate;
	}
	public String getR1630_product() {
		return r1630_product;
	}
	public void setR1630_product(String r1630_product) {
		this.r1630_product = r1630_product;
	}
	public BigDecimal getR1630_aed_amount() {
		return r1630_aed_amount;
	}
	public void setR1630_aed_amount(BigDecimal r1630_aed_amount) {
		this.r1630_aed_amount = r1630_aed_amount;
	}
	public BigDecimal getR1630_fcy_amount() {
		return r1630_fcy_amount;
	}
	public void setR1630_fcy_amount(BigDecimal r1630_fcy_amount) {
		this.r1630_fcy_amount = r1630_fcy_amount;
	}
	public BigDecimal getR1630_total() {
		return r1630_total;
	}
	public void setR1630_total(BigDecimal r1630_total) {
		this.r1630_total = r1630_total;
	}
	public BigDecimal getR1630_non_commercial_entities() {
		return r1630_non_commercial_entities;
	}
	public void setR1630_non_commercial_entities(BigDecimal r1630_non_commercial_entities) {
		this.r1630_non_commercial_entities = r1630_non_commercial_entities;
	}
	public BigDecimal getR1630_commercial_entities() {
		return r1630_commercial_entities;
	}
	public void setR1630_commercial_entities(BigDecimal r1630_commercial_entities) {
		this.r1630_commercial_entities = r1630_commercial_entities;
	}
	public BigDecimal getR1630_private_corporates() {
		return r1630_private_corporates;
	}
	public void setR1630_private_corporates(BigDecimal r1630_private_corporates) {
		this.r1630_private_corporates = r1630_private_corporates;
	}
	public BigDecimal getR1630_sme() {
		return r1630_sme;
	}
	public void setR1630_sme(BigDecimal r1630_sme) {
		this.r1630_sme = r1630_sme;
	}
	public BigDecimal getR1630_individuals() {
		return r1630_individuals;
	}
	public void setR1630_individuals(BigDecimal r1630_individuals) {
		this.r1630_individuals = r1630_individuals;
	}
	public BigDecimal getR1630_minimum_rate() {
		return r1630_minimum_rate;
	}
	public void setR1630_minimum_rate(BigDecimal r1630_minimum_rate) {
		this.r1630_minimum_rate = r1630_minimum_rate;
	}
	public BigDecimal getR1630_maximum_rate() {
		return r1630_maximum_rate;
	}
	public void setR1630_maximum_rate(BigDecimal r1630_maximum_rate) {
		this.r1630_maximum_rate = r1630_maximum_rate;
	}
	public BigDecimal getR1630_average_rate() {
		return r1630_average_rate;
	}
	public void setR1630_average_rate(BigDecimal r1630_average_rate) {
		this.r1630_average_rate = r1630_average_rate;
	}
	public String getR1640_product() {
		return r1640_product;
	}
	public void setR1640_product(String r1640_product) {
		this.r1640_product = r1640_product;
	}
	public BigDecimal getR1640_aed_amount() {
		return r1640_aed_amount;
	}
	public void setR1640_aed_amount(BigDecimal r1640_aed_amount) {
		this.r1640_aed_amount = r1640_aed_amount;
	}
	public BigDecimal getR1640_fcy_amount() {
		return r1640_fcy_amount;
	}
	public void setR1640_fcy_amount(BigDecimal r1640_fcy_amount) {
		this.r1640_fcy_amount = r1640_fcy_amount;
	}
	public BigDecimal getR1640_total() {
		return r1640_total;
	}
	public void setR1640_total(BigDecimal r1640_total) {
		this.r1640_total = r1640_total;
	}
	public BigDecimal getR1640_non_commercial_entities() {
		return r1640_non_commercial_entities;
	}
	public void setR1640_non_commercial_entities(BigDecimal r1640_non_commercial_entities) {
		this.r1640_non_commercial_entities = r1640_non_commercial_entities;
	}
	public BigDecimal getR1640_commercial_entities() {
		return r1640_commercial_entities;
	}
	public void setR1640_commercial_entities(BigDecimal r1640_commercial_entities) {
		this.r1640_commercial_entities = r1640_commercial_entities;
	}
	public BigDecimal getR1640_private_corporates() {
		return r1640_private_corporates;
	}
	public void setR1640_private_corporates(BigDecimal r1640_private_corporates) {
		this.r1640_private_corporates = r1640_private_corporates;
	}
	public BigDecimal getR1640_sme() {
		return r1640_sme;
	}
	public void setR1640_sme(BigDecimal r1640_sme) {
		this.r1640_sme = r1640_sme;
	}
	public BigDecimal getR1640_individuals() {
		return r1640_individuals;
	}
	public void setR1640_individuals(BigDecimal r1640_individuals) {
		this.r1640_individuals = r1640_individuals;
	}
	public BigDecimal getR1640_minimum_rate() {
		return r1640_minimum_rate;
	}
	public void setR1640_minimum_rate(BigDecimal r1640_minimum_rate) {
		this.r1640_minimum_rate = r1640_minimum_rate;
	}
	public BigDecimal getR1640_maximum_rate() {
		return r1640_maximum_rate;
	}
	public void setR1640_maximum_rate(BigDecimal r1640_maximum_rate) {
		this.r1640_maximum_rate = r1640_maximum_rate;
	}
	public BigDecimal getR1640_average_rate() {
		return r1640_average_rate;
	}
	public void setR1640_average_rate(BigDecimal r1640_average_rate) {
		this.r1640_average_rate = r1640_average_rate;
	}
	public String getR1650_product() {
		return r1650_product;
	}
	public void setR1650_product(String r1650_product) {
		this.r1650_product = r1650_product;
	}
	public BigDecimal getR1650_aed_amount() {
		return r1650_aed_amount;
	}
	public void setR1650_aed_amount(BigDecimal r1650_aed_amount) {
		this.r1650_aed_amount = r1650_aed_amount;
	}
	public BigDecimal getR1650_fcy_amount() {
		return r1650_fcy_amount;
	}
	public void setR1650_fcy_amount(BigDecimal r1650_fcy_amount) {
		this.r1650_fcy_amount = r1650_fcy_amount;
	}
	public BigDecimal getR1650_total() {
		return r1650_total;
	}
	public void setR1650_total(BigDecimal r1650_total) {
		this.r1650_total = r1650_total;
	}
	public BigDecimal getR1650_non_commercial_entities() {
		return r1650_non_commercial_entities;
	}
	public void setR1650_non_commercial_entities(BigDecimal r1650_non_commercial_entities) {
		this.r1650_non_commercial_entities = r1650_non_commercial_entities;
	}
	public BigDecimal getR1650_commercial_entities() {
		return r1650_commercial_entities;
	}
	public void setR1650_commercial_entities(BigDecimal r1650_commercial_entities) {
		this.r1650_commercial_entities = r1650_commercial_entities;
	}
	public BigDecimal getR1650_private_corporates() {
		return r1650_private_corporates;
	}
	public void setR1650_private_corporates(BigDecimal r1650_private_corporates) {
		this.r1650_private_corporates = r1650_private_corporates;
	}
	public BigDecimal getR1650_sme() {
		return r1650_sme;
	}
	public void setR1650_sme(BigDecimal r1650_sme) {
		this.r1650_sme = r1650_sme;
	}
	public BigDecimal getR1650_individuals() {
		return r1650_individuals;
	}
	public void setR1650_individuals(BigDecimal r1650_individuals) {
		this.r1650_individuals = r1650_individuals;
	}
	public BigDecimal getR1650_minimum_rate() {
		return r1650_minimum_rate;
	}
	public void setR1650_minimum_rate(BigDecimal r1650_minimum_rate) {
		this.r1650_minimum_rate = r1650_minimum_rate;
	}
	public BigDecimal getR1650_maximum_rate() {
		return r1650_maximum_rate;
	}
	public void setR1650_maximum_rate(BigDecimal r1650_maximum_rate) {
		this.r1650_maximum_rate = r1650_maximum_rate;
	}
	public BigDecimal getR1650_average_rate() {
		return r1650_average_rate;
	}
	public void setR1650_average_rate(BigDecimal r1650_average_rate) {
		this.r1650_average_rate = r1650_average_rate;
	}
	public String getR1660_product() {
		return r1660_product;
	}
	public void setR1660_product(String r1660_product) {
		this.r1660_product = r1660_product;
	}
	public BigDecimal getR1660_aed_amount() {
		return r1660_aed_amount;
	}
	public void setR1660_aed_amount(BigDecimal r1660_aed_amount) {
		this.r1660_aed_amount = r1660_aed_amount;
	}
	public BigDecimal getR1660_fcy_amount() {
		return r1660_fcy_amount;
	}
	public void setR1660_fcy_amount(BigDecimal r1660_fcy_amount) {
		this.r1660_fcy_amount = r1660_fcy_amount;
	}
	public BigDecimal getR1660_total() {
		return r1660_total;
	}
	public void setR1660_total(BigDecimal r1660_total) {
		this.r1660_total = r1660_total;
	}
	public BigDecimal getR1660_non_commercial_entities() {
		return r1660_non_commercial_entities;
	}
	public void setR1660_non_commercial_entities(BigDecimal r1660_non_commercial_entities) {
		this.r1660_non_commercial_entities = r1660_non_commercial_entities;
	}
	public BigDecimal getR1660_commercial_entities() {
		return r1660_commercial_entities;
	}
	public void setR1660_commercial_entities(BigDecimal r1660_commercial_entities) {
		this.r1660_commercial_entities = r1660_commercial_entities;
	}
	public BigDecimal getR1660_private_corporates() {
		return r1660_private_corporates;
	}
	public void setR1660_private_corporates(BigDecimal r1660_private_corporates) {
		this.r1660_private_corporates = r1660_private_corporates;
	}
	public BigDecimal getR1660_sme() {
		return r1660_sme;
	}
	public void setR1660_sme(BigDecimal r1660_sme) {
		this.r1660_sme = r1660_sme;
	}
	public BigDecimal getR1660_individuals() {
		return r1660_individuals;
	}
	public void setR1660_individuals(BigDecimal r1660_individuals) {
		this.r1660_individuals = r1660_individuals;
	}
	public BigDecimal getR1660_minimum_rate() {
		return r1660_minimum_rate;
	}
	public void setR1660_minimum_rate(BigDecimal r1660_minimum_rate) {
		this.r1660_minimum_rate = r1660_minimum_rate;
	}
	public BigDecimal getR1660_maximum_rate() {
		return r1660_maximum_rate;
	}
	public void setR1660_maximum_rate(BigDecimal r1660_maximum_rate) {
		this.r1660_maximum_rate = r1660_maximum_rate;
	}
	public BigDecimal getR1660_average_rate() {
		return r1660_average_rate;
	}
	public void setR1660_average_rate(BigDecimal r1660_average_rate) {
		this.r1660_average_rate = r1660_average_rate;
	}
	public String getR1670_product() {
		return r1670_product;
	}
	public void setR1670_product(String r1670_product) {
		this.r1670_product = r1670_product;
	}
	public BigDecimal getR1670_aed_amount() {
		return r1670_aed_amount;
	}
	public void setR1670_aed_amount(BigDecimal r1670_aed_amount) {
		this.r1670_aed_amount = r1670_aed_amount;
	}
	public BigDecimal getR1670_fcy_amount() {
		return r1670_fcy_amount;
	}
	public void setR1670_fcy_amount(BigDecimal r1670_fcy_amount) {
		this.r1670_fcy_amount = r1670_fcy_amount;
	}
	public BigDecimal getR1670_total() {
		return r1670_total;
	}
	public void setR1670_total(BigDecimal r1670_total) {
		this.r1670_total = r1670_total;
	}
	public BigDecimal getR1670_non_commercial_entities() {
		return r1670_non_commercial_entities;
	}
	public void setR1670_non_commercial_entities(BigDecimal r1670_non_commercial_entities) {
		this.r1670_non_commercial_entities = r1670_non_commercial_entities;
	}
	public BigDecimal getR1670_commercial_entities() {
		return r1670_commercial_entities;
	}
	public void setR1670_commercial_entities(BigDecimal r1670_commercial_entities) {
		this.r1670_commercial_entities = r1670_commercial_entities;
	}
	public BigDecimal getR1670_private_corporates() {
		return r1670_private_corporates;
	}
	public void setR1670_private_corporates(BigDecimal r1670_private_corporates) {
		this.r1670_private_corporates = r1670_private_corporates;
	}
	public BigDecimal getR1670_sme() {
		return r1670_sme;
	}
	public void setR1670_sme(BigDecimal r1670_sme) {
		this.r1670_sme = r1670_sme;
	}
	public BigDecimal getR1670_individuals() {
		return r1670_individuals;
	}
	public void setR1670_individuals(BigDecimal r1670_individuals) {
		this.r1670_individuals = r1670_individuals;
	}
	public BigDecimal getR1670_minimum_rate() {
		return r1670_minimum_rate;
	}
	public void setR1670_minimum_rate(BigDecimal r1670_minimum_rate) {
		this.r1670_minimum_rate = r1670_minimum_rate;
	}
	public BigDecimal getR1670_maximum_rate() {
		return r1670_maximum_rate;
	}
	public void setR1670_maximum_rate(BigDecimal r1670_maximum_rate) {
		this.r1670_maximum_rate = r1670_maximum_rate;
	}
	public BigDecimal getR1670_average_rate() {
		return r1670_average_rate;
	}
	public void setR1670_average_rate(BigDecimal r1670_average_rate) {
		this.r1670_average_rate = r1670_average_rate;
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
	public String getEntity_flg() {
		return entity_flg;
	}
	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}
	public String getModify_flg() {
		return modify_flg;
	}
	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public CBUAE_BRF2_13_Archival_Summary_Entity3(String r1610_product, BigDecimal r1610_aed_amount,
			BigDecimal r1610_fcy_amount, BigDecimal r1610_total, BigDecimal r1610_non_commercial_entities,
			BigDecimal r1610_commercial_entities, BigDecimal r1610_private_corporates, BigDecimal r1610_sme,
			BigDecimal r1610_individuals, BigDecimal r1610_minimum_rate, BigDecimal r1610_maximum_rate,
			BigDecimal r1610_average_rate, String r1620_product, BigDecimal r1620_aed_amount,
			BigDecimal r1620_fcy_amount, BigDecimal r1620_total, BigDecimal r1620_non_commercial_entities,
			BigDecimal r1620_commercial_entities, BigDecimal r1620_private_corporates, BigDecimal r1620_sme,
			BigDecimal r1620_individuals, BigDecimal r1620_minimum_rate, BigDecimal r1620_maximum_rate,
			BigDecimal r1620_average_rate, String r1630_product, BigDecimal r1630_aed_amount,
			BigDecimal r1630_fcy_amount, BigDecimal r1630_total, BigDecimal r1630_non_commercial_entities,
			BigDecimal r1630_commercial_entities, BigDecimal r1630_private_corporates, BigDecimal r1630_sme,
			BigDecimal r1630_individuals, BigDecimal r1630_minimum_rate, BigDecimal r1630_maximum_rate,
			BigDecimal r1630_average_rate, String r1640_product, BigDecimal r1640_aed_amount,
			BigDecimal r1640_fcy_amount, BigDecimal r1640_total, BigDecimal r1640_non_commercial_entities,
			BigDecimal r1640_commercial_entities, BigDecimal r1640_private_corporates, BigDecimal r1640_sme,
			BigDecimal r1640_individuals, BigDecimal r1640_minimum_rate, BigDecimal r1640_maximum_rate,
			BigDecimal r1640_average_rate, String r1650_product, BigDecimal r1650_aed_amount,
			BigDecimal r1650_fcy_amount, BigDecimal r1650_total, BigDecimal r1650_non_commercial_entities,
			BigDecimal r1650_commercial_entities, BigDecimal r1650_private_corporates, BigDecimal r1650_sme,
			BigDecimal r1650_individuals, BigDecimal r1650_minimum_rate, BigDecimal r1650_maximum_rate,
			BigDecimal r1650_average_rate, String r1660_product, BigDecimal r1660_aed_amount,
			BigDecimal r1660_fcy_amount, BigDecimal r1660_total, BigDecimal r1660_non_commercial_entities,
			BigDecimal r1660_commercial_entities, BigDecimal r1660_private_corporates, BigDecimal r1660_sme,
			BigDecimal r1660_individuals, BigDecimal r1660_minimum_rate, BigDecimal r1660_maximum_rate,
			BigDecimal r1660_average_rate, String r1670_product, BigDecimal r1670_aed_amount,
			BigDecimal r1670_fcy_amount, BigDecimal r1670_total, BigDecimal r1670_non_commercial_entities,
			BigDecimal r1670_commercial_entities, BigDecimal r1670_private_corporates, BigDecimal r1670_sme,
			BigDecimal r1670_individuals, BigDecimal r1670_minimum_rate, BigDecimal r1670_maximum_rate,
			BigDecimal r1670_average_rate, Date report_date, String report_version, String report_frequency,
			String report_code, String report_desc, String entity_flg, String modify_flg, String del_flg) {
		super();
		this.r1610_product = r1610_product;
		this.r1610_aed_amount = r1610_aed_amount;
		this.r1610_fcy_amount = r1610_fcy_amount;
		this.r1610_total = r1610_total;
		this.r1610_non_commercial_entities = r1610_non_commercial_entities;
		this.r1610_commercial_entities = r1610_commercial_entities;
		this.r1610_private_corporates = r1610_private_corporates;
		this.r1610_sme = r1610_sme;
		this.r1610_individuals = r1610_individuals;
		this.r1610_minimum_rate = r1610_minimum_rate;
		this.r1610_maximum_rate = r1610_maximum_rate;
		this.r1610_average_rate = r1610_average_rate;
		this.r1620_product = r1620_product;
		this.r1620_aed_amount = r1620_aed_amount;
		this.r1620_fcy_amount = r1620_fcy_amount;
		this.r1620_total = r1620_total;
		this.r1620_non_commercial_entities = r1620_non_commercial_entities;
		this.r1620_commercial_entities = r1620_commercial_entities;
		this.r1620_private_corporates = r1620_private_corporates;
		this.r1620_sme = r1620_sme;
		this.r1620_individuals = r1620_individuals;
		this.r1620_minimum_rate = r1620_minimum_rate;
		this.r1620_maximum_rate = r1620_maximum_rate;
		this.r1620_average_rate = r1620_average_rate;
		this.r1630_product = r1630_product;
		this.r1630_aed_amount = r1630_aed_amount;
		this.r1630_fcy_amount = r1630_fcy_amount;
		this.r1630_total = r1630_total;
		this.r1630_non_commercial_entities = r1630_non_commercial_entities;
		this.r1630_commercial_entities = r1630_commercial_entities;
		this.r1630_private_corporates = r1630_private_corporates;
		this.r1630_sme = r1630_sme;
		this.r1630_individuals = r1630_individuals;
		this.r1630_minimum_rate = r1630_minimum_rate;
		this.r1630_maximum_rate = r1630_maximum_rate;
		this.r1630_average_rate = r1630_average_rate;
		this.r1640_product = r1640_product;
		this.r1640_aed_amount = r1640_aed_amount;
		this.r1640_fcy_amount = r1640_fcy_amount;
		this.r1640_total = r1640_total;
		this.r1640_non_commercial_entities = r1640_non_commercial_entities;
		this.r1640_commercial_entities = r1640_commercial_entities;
		this.r1640_private_corporates = r1640_private_corporates;
		this.r1640_sme = r1640_sme;
		this.r1640_individuals = r1640_individuals;
		this.r1640_minimum_rate = r1640_minimum_rate;
		this.r1640_maximum_rate = r1640_maximum_rate;
		this.r1640_average_rate = r1640_average_rate;
		this.r1650_product = r1650_product;
		this.r1650_aed_amount = r1650_aed_amount;
		this.r1650_fcy_amount = r1650_fcy_amount;
		this.r1650_total = r1650_total;
		this.r1650_non_commercial_entities = r1650_non_commercial_entities;
		this.r1650_commercial_entities = r1650_commercial_entities;
		this.r1650_private_corporates = r1650_private_corporates;
		this.r1650_sme = r1650_sme;
		this.r1650_individuals = r1650_individuals;
		this.r1650_minimum_rate = r1650_minimum_rate;
		this.r1650_maximum_rate = r1650_maximum_rate;
		this.r1650_average_rate = r1650_average_rate;
		this.r1660_product = r1660_product;
		this.r1660_aed_amount = r1660_aed_amount;
		this.r1660_fcy_amount = r1660_fcy_amount;
		this.r1660_total = r1660_total;
		this.r1660_non_commercial_entities = r1660_non_commercial_entities;
		this.r1660_commercial_entities = r1660_commercial_entities;
		this.r1660_private_corporates = r1660_private_corporates;
		this.r1660_sme = r1660_sme;
		this.r1660_individuals = r1660_individuals;
		this.r1660_minimum_rate = r1660_minimum_rate;
		this.r1660_maximum_rate = r1660_maximum_rate;
		this.r1660_average_rate = r1660_average_rate;
		this.r1670_product = r1670_product;
		this.r1670_aed_amount = r1670_aed_amount;
		this.r1670_fcy_amount = r1670_fcy_amount;
		this.r1670_total = r1670_total;
		this.r1670_non_commercial_entities = r1670_non_commercial_entities;
		this.r1670_commercial_entities = r1670_commercial_entities;
		this.r1670_private_corporates = r1670_private_corporates;
		this.r1670_sme = r1670_sme;
		this.r1670_individuals = r1670_individuals;
		this.r1670_minimum_rate = r1670_minimum_rate;
		this.r1670_maximum_rate = r1670_maximum_rate;
		this.r1670_average_rate = r1670_average_rate;
		this.report_date = report_date;
		this.report_version = report_version;
		this.report_frequency = report_frequency;
		this.report_code = report_code;
		this.report_desc = report_desc;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
	}
	public CBUAE_BRF2_13_Archival_Summary_Entity3() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	 

}
