package com.bornfire.brf.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CBUAE_BRF7_3_SUMMARYTABLE4")
public class CBUAE_BRF7_3_Summary_Entity4 {

	private  BigDecimal  r0820_1_to_3_years_nat_amt;
	private  BigDecimal  r0820_bought_hedg_net_delta_pos;
	private  BigDecimal  r0820_bought_trad_net_delta_pos;
	private  BigDecimal  r0820_gross_mkt_val;
	private  BigDecimal  r0820_hedg_nat_amt;
	private  BigDecimal  r0820_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0820_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0820_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0820_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0820_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0820_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0820_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0820_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0820_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0820_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0820_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0820_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0820_nat_amt;
	private  BigDecimal  r0820_non_res_nat_amt;
	private  BigDecimal  r0820_over_3_years_nat_amt;
	private  BigDecimal  r0820_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0820_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0820_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0820_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0820_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0820_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0820_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0820_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0820_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0820_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0820_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0820_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0820_product;
	private  BigDecimal  r0820_pro_bought_net_gain_loss;
	private  BigDecimal  r0820_pro_sold_net_gain_loss;
	private  BigDecimal  r0820_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0820_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0820_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0820_res_nat_amt;
	private  BigDecimal  r0820_sold_hedg_net_delta_pos;
	private  BigDecimal  r0820_sold_trad_net_delta_pos;
	private  BigDecimal  r0820_trad_nat_amt;
	private  BigDecimal  r0820_within_1_year_nat_amt;
	private  BigDecimal  r0830_1_to_3_years_nat_amt;
	private  BigDecimal  r0830_bought_hedg_net_delta_pos;
	private  BigDecimal  r0830_bought_trad_net_delta_pos;
	private  BigDecimal  r0830_gross_mkt_val;
	private  BigDecimal  r0830_hedg_nat_amt;
	private  BigDecimal  r0830_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0830_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0830_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0830_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0830_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0830_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0830_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0830_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0830_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0830_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0830_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0830_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0830_nat_amt;
	private  BigDecimal  r0830_non_res_nat_amt;
	private  BigDecimal  r0830_over_3_years_nat_amt;
	private  BigDecimal  r0830_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0830_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0830_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0830_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0830_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0830_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0830_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0830_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0830_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0830_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0830_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0830_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0830_product;
	private  BigDecimal  r0830_pro_bought_net_gain_loss;
	private  BigDecimal  r0830_pro_sold_net_gain_loss;
	private  BigDecimal  r0830_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0830_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0830_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0830_res_nat_amt;
	private  BigDecimal  r0830_sold_hedg_net_delta_pos;
	private  BigDecimal  r0830_sold_trad_net_delta_pos;
	private  BigDecimal  r0830_trad_nat_amt;
	private  BigDecimal  r0830_within_1_year_nat_amt;
	private  BigDecimal  r0840_1_to_3_years_nat_amt;
	private  BigDecimal  r0840_bought_hedg_net_delta_pos;
	private  BigDecimal  r0840_bought_trad_net_delta_pos;
	private  BigDecimal  r0840_gross_mkt_val;
	private  BigDecimal  r0840_hedg_nat_amt;
	private  BigDecimal  r0840_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0840_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0840_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0840_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0840_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0840_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0840_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0840_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0840_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0840_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0840_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0840_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0840_nat_amt;
	private  BigDecimal  r0840_non_res_nat_amt;
	private  BigDecimal  r0840_over_3_years_nat_amt;
	private  BigDecimal  r0840_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0840_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0840_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0840_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0840_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0840_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0840_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0840_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0840_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0840_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0840_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0840_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0840_product;
	private  BigDecimal  r0840_pro_bought_net_gain_loss;
	private  BigDecimal  r0840_pro_sold_net_gain_loss;
	private  BigDecimal  r0840_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0840_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0840_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0840_res_nat_amt;
	private  BigDecimal  r0840_sold_hedg_net_delta_pos;
	private  BigDecimal  r0840_sold_trad_net_delta_pos;
	private  BigDecimal  r0840_trad_nat_amt;
	private  BigDecimal  r0840_within_1_year_nat_amt;
	private  BigDecimal  r0850_1_to_3_years_nat_amt;
	private  BigDecimal  r0850_bought_hedg_net_delta_pos;
	private  BigDecimal  r0850_bought_trad_net_delta_pos;
	private  BigDecimal  r0850_gross_mkt_val;
	private  BigDecimal  r0850_hedg_nat_amt;
	private  BigDecimal  r0850_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0850_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0850_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0850_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0850_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0850_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0850_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0850_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0850_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0850_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0850_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0850_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0850_nat_amt;
	private  BigDecimal  r0850_non_res_nat_amt;
	private  BigDecimal  r0850_over_3_years_nat_amt;
	private  BigDecimal  r0850_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0850_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0850_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0850_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0850_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0850_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0850_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0850_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0850_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0850_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0850_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0850_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0850_product;
	private  BigDecimal  r0850_pro_bought_net_gain_loss;
	private  BigDecimal  r0850_pro_sold_net_gain_loss;
	private  BigDecimal  r0850_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0850_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0850_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0850_res_nat_amt;
	private  BigDecimal  r0850_sold_hedg_net_delta_pos;
	private  BigDecimal  r0850_sold_trad_net_delta_pos;
	private  BigDecimal  r0850_trad_nat_amt;
	private  BigDecimal  r0850_within_1_year_nat_amt;
	private  String  report_code;
	@Id    
	private  Date  report_date;
	private  String  report_desc;
	private  String  report_frequency;
	private  String  report_version;

	
	

	public BigDecimal getR0820_1_to_3_years_nat_amt() {
		return r0820_1_to_3_years_nat_amt;
	}




	public void setR0820_1_to_3_years_nat_amt(BigDecimal r0820_1_to_3_years_nat_amt) {
		this.r0820_1_to_3_years_nat_amt = r0820_1_to_3_years_nat_amt;
	}




	public BigDecimal getR0820_bought_hedg_net_delta_pos() {
		return r0820_bought_hedg_net_delta_pos;
	}




	public void setR0820_bought_hedg_net_delta_pos(BigDecimal r0820_bought_hedg_net_delta_pos) {
		this.r0820_bought_hedg_net_delta_pos = r0820_bought_hedg_net_delta_pos;
	}




	public BigDecimal getR0820_bought_trad_net_delta_pos() {
		return r0820_bought_trad_net_delta_pos;
	}




	public void setR0820_bought_trad_net_delta_pos(BigDecimal r0820_bought_trad_net_delta_pos) {
		this.r0820_bought_trad_net_delta_pos = r0820_bought_trad_net_delta_pos;
	}




	public BigDecimal getR0820_gross_mkt_val() {
		return r0820_gross_mkt_val;
	}




	public void setR0820_gross_mkt_val(BigDecimal r0820_gross_mkt_val) {
		this.r0820_gross_mkt_val = r0820_gross_mkt_val;
	}




	public BigDecimal getR0820_hedg_nat_amt() {
		return r0820_hedg_nat_amt;
	}




	public void setR0820_hedg_nat_amt(BigDecimal r0820_hedg_nat_amt) {
		this.r0820_hedg_nat_amt = r0820_hedg_nat_amt;
	}




	public BigDecimal getR0820_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0820_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0820_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0820_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0820_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0820_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0820_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0820_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0820_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0820_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0820_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0820_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0820_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0820_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0820_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0820_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0820_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0820_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0820_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0820_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0820_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0820_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0820_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0820_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0820_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0820_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0820_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0820_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0820_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0820_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0820_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0820_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0820_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0820_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0820_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0820_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0820_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0820_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0820_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0820_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0820_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0820_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0820_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0820_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0820_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0820_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0820_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0820_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0820_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0820_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0820_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0820_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0820_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0820_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0820_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0820_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0820_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0820_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0820_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0820_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0820_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0820_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0820_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0820_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0820_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0820_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0820_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0820_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0820_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0820_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0820_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0820_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public BigDecimal getR0820_nat_amt() {
		return r0820_nat_amt;
	}




	public void setR0820_nat_amt(BigDecimal r0820_nat_amt) {
		this.r0820_nat_amt = r0820_nat_amt;
	}




	public BigDecimal getR0820_non_res_nat_amt() {
		return r0820_non_res_nat_amt;
	}




	public void setR0820_non_res_nat_amt(BigDecimal r0820_non_res_nat_amt) {
		this.r0820_non_res_nat_amt = r0820_non_res_nat_amt;
	}




	public BigDecimal getR0820_over_3_years_nat_amt() {
		return r0820_over_3_years_nat_amt;
	}




	public void setR0820_over_3_years_nat_amt(BigDecimal r0820_over_3_years_nat_amt) {
		this.r0820_over_3_years_nat_amt = r0820_over_3_years_nat_amt;
	}




	public BigDecimal getR0820_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0820_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0820_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0820_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0820_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0820_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0820_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0820_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0820_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0820_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0820_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0820_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0820_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0820_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0820_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0820_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0820_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0820_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0820_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0820_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0820_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0820_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0820_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0820_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0820_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0820_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0820_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0820_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0820_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0820_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0820_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0820_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0820_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0820_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0820_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0820_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0820_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0820_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0820_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0820_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0820_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0820_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0820_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0820_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0820_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0820_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0820_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0820_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0820_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0820_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0820_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0820_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0820_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0820_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0820_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0820_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0820_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0820_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0820_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0820_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0820_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0820_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0820_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0820_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0820_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0820_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0820_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0820_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0820_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0820_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0820_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0820_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public String getR0820_product() {
		return r0820_product;
	}




	public void setR0820_product(String r0820_product) {
		this.r0820_product = r0820_product;
	}




	public BigDecimal getR0820_pro_bought_net_gain_loss() {
		return r0820_pro_bought_net_gain_loss;
	}




	public void setR0820_pro_bought_net_gain_loss(BigDecimal r0820_pro_bought_net_gain_loss) {
		this.r0820_pro_bought_net_gain_loss = r0820_pro_bought_net_gain_loss;
	}




	public BigDecimal getR0820_pro_sold_net_gain_loss() {
		return r0820_pro_sold_net_gain_loss;
	}




	public void setR0820_pro_sold_net_gain_loss(BigDecimal r0820_pro_sold_net_gain_loss) {
		this.r0820_pro_sold_net_gain_loss = r0820_pro_sold_net_gain_loss;
	}




	public BigDecimal getR0820_res_1_to_3_years_mkt_val() {
		return r0820_res_1_to_3_years_mkt_val;
	}




	public void setR0820_res_1_to_3_years_mkt_val(BigDecimal r0820_res_1_to_3_years_mkt_val) {
		this.r0820_res_1_to_3_years_mkt_val = r0820_res_1_to_3_years_mkt_val;
	}




	public BigDecimal getR0820_res_lessthan_1_year_mkt_val() {
		return r0820_res_lessthan_1_year_mkt_val;
	}




	public void setR0820_res_lessthan_1_year_mkt_val(BigDecimal r0820_res_lessthan_1_year_mkt_val) {
		this.r0820_res_lessthan_1_year_mkt_val = r0820_res_lessthan_1_year_mkt_val;
	}




	public BigDecimal getR0820_res_morethan_3_years_mkt_val() {
		return r0820_res_morethan_3_years_mkt_val;
	}




	public void setR0820_res_morethan_3_years_mkt_val(BigDecimal r0820_res_morethan_3_years_mkt_val) {
		this.r0820_res_morethan_3_years_mkt_val = r0820_res_morethan_3_years_mkt_val;
	}




	public BigDecimal getR0820_res_nat_amt() {
		return r0820_res_nat_amt;
	}




	public void setR0820_res_nat_amt(BigDecimal r0820_res_nat_amt) {
		this.r0820_res_nat_amt = r0820_res_nat_amt;
	}




	public BigDecimal getR0820_sold_hedg_net_delta_pos() {
		return r0820_sold_hedg_net_delta_pos;
	}




	public void setR0820_sold_hedg_net_delta_pos(BigDecimal r0820_sold_hedg_net_delta_pos) {
		this.r0820_sold_hedg_net_delta_pos = r0820_sold_hedg_net_delta_pos;
	}




	public BigDecimal getR0820_sold_trad_net_delta_pos() {
		return r0820_sold_trad_net_delta_pos;
	}




	public void setR0820_sold_trad_net_delta_pos(BigDecimal r0820_sold_trad_net_delta_pos) {
		this.r0820_sold_trad_net_delta_pos = r0820_sold_trad_net_delta_pos;
	}




	public BigDecimal getR0820_trad_nat_amt() {
		return r0820_trad_nat_amt;
	}




	public void setR0820_trad_nat_amt(BigDecimal r0820_trad_nat_amt) {
		this.r0820_trad_nat_amt = r0820_trad_nat_amt;
	}




	public BigDecimal getR0820_within_1_year_nat_amt() {
		return r0820_within_1_year_nat_amt;
	}




	public void setR0820_within_1_year_nat_amt(BigDecimal r0820_within_1_year_nat_amt) {
		this.r0820_within_1_year_nat_amt = r0820_within_1_year_nat_amt;
	}




	public BigDecimal getR0830_1_to_3_years_nat_amt() {
		return r0830_1_to_3_years_nat_amt;
	}




	public void setR0830_1_to_3_years_nat_amt(BigDecimal r0830_1_to_3_years_nat_amt) {
		this.r0830_1_to_3_years_nat_amt = r0830_1_to_3_years_nat_amt;
	}




	public BigDecimal getR0830_bought_hedg_net_delta_pos() {
		return r0830_bought_hedg_net_delta_pos;
	}




	public void setR0830_bought_hedg_net_delta_pos(BigDecimal r0830_bought_hedg_net_delta_pos) {
		this.r0830_bought_hedg_net_delta_pos = r0830_bought_hedg_net_delta_pos;
	}




	public BigDecimal getR0830_bought_trad_net_delta_pos() {
		return r0830_bought_trad_net_delta_pos;
	}




	public void setR0830_bought_trad_net_delta_pos(BigDecimal r0830_bought_trad_net_delta_pos) {
		this.r0830_bought_trad_net_delta_pos = r0830_bought_trad_net_delta_pos;
	}




	public BigDecimal getR0830_gross_mkt_val() {
		return r0830_gross_mkt_val;
	}




	public void setR0830_gross_mkt_val(BigDecimal r0830_gross_mkt_val) {
		this.r0830_gross_mkt_val = r0830_gross_mkt_val;
	}




	public BigDecimal getR0830_hedg_nat_amt() {
		return r0830_hedg_nat_amt;
	}




	public void setR0830_hedg_nat_amt(BigDecimal r0830_hedg_nat_amt) {
		this.r0830_hedg_nat_amt = r0830_hedg_nat_amt;
	}




	public BigDecimal getR0830_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0830_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0830_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0830_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0830_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0830_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0830_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0830_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0830_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0830_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0830_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0830_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0830_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0830_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0830_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0830_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0830_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0830_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0830_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0830_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0830_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0830_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0830_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0830_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0830_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0830_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0830_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0830_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0830_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0830_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0830_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0830_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0830_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0830_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0830_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0830_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0830_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0830_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0830_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0830_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0830_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0830_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0830_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0830_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0830_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0830_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0830_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0830_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0830_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0830_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0830_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0830_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0830_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0830_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0830_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0830_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0830_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0830_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0830_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0830_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0830_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0830_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0830_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0830_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0830_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0830_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0830_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0830_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0830_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0830_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0830_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0830_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public BigDecimal getR0830_nat_amt() {
		return r0830_nat_amt;
	}




	public void setR0830_nat_amt(BigDecimal r0830_nat_amt) {
		this.r0830_nat_amt = r0830_nat_amt;
	}




	public BigDecimal getR0830_non_res_nat_amt() {
		return r0830_non_res_nat_amt;
	}




	public void setR0830_non_res_nat_amt(BigDecimal r0830_non_res_nat_amt) {
		this.r0830_non_res_nat_amt = r0830_non_res_nat_amt;
	}




	public BigDecimal getR0830_over_3_years_nat_amt() {
		return r0830_over_3_years_nat_amt;
	}




	public void setR0830_over_3_years_nat_amt(BigDecimal r0830_over_3_years_nat_amt) {
		this.r0830_over_3_years_nat_amt = r0830_over_3_years_nat_amt;
	}




	public BigDecimal getR0830_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0830_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0830_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0830_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0830_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0830_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0830_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0830_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0830_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0830_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0830_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0830_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0830_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0830_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0830_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0830_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0830_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0830_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0830_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0830_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0830_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0830_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0830_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0830_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0830_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0830_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0830_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0830_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0830_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0830_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0830_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0830_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0830_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0830_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0830_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0830_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0830_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0830_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0830_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0830_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0830_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0830_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0830_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0830_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0830_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0830_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0830_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0830_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0830_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0830_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0830_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0830_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0830_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0830_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0830_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0830_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0830_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0830_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0830_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0830_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0830_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0830_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0830_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0830_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0830_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0830_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0830_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0830_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0830_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0830_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0830_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0830_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public String getR0830_product() {
		return r0830_product;
	}




	public void setR0830_product(String r0830_product) {
		this.r0830_product = r0830_product;
	}




	public BigDecimal getR0830_pro_bought_net_gain_loss() {
		return r0830_pro_bought_net_gain_loss;
	}




	public void setR0830_pro_bought_net_gain_loss(BigDecimal r0830_pro_bought_net_gain_loss) {
		this.r0830_pro_bought_net_gain_loss = r0830_pro_bought_net_gain_loss;
	}




	public BigDecimal getR0830_pro_sold_net_gain_loss() {
		return r0830_pro_sold_net_gain_loss;
	}




	public void setR0830_pro_sold_net_gain_loss(BigDecimal r0830_pro_sold_net_gain_loss) {
		this.r0830_pro_sold_net_gain_loss = r0830_pro_sold_net_gain_loss;
	}




	public BigDecimal getR0830_res_1_to_3_years_mkt_val() {
		return r0830_res_1_to_3_years_mkt_val;
	}




	public void setR0830_res_1_to_3_years_mkt_val(BigDecimal r0830_res_1_to_3_years_mkt_val) {
		this.r0830_res_1_to_3_years_mkt_val = r0830_res_1_to_3_years_mkt_val;
	}




	public BigDecimal getR0830_res_lessthan_1_year_mkt_val() {
		return r0830_res_lessthan_1_year_mkt_val;
	}




	public void setR0830_res_lessthan_1_year_mkt_val(BigDecimal r0830_res_lessthan_1_year_mkt_val) {
		this.r0830_res_lessthan_1_year_mkt_val = r0830_res_lessthan_1_year_mkt_val;
	}




	public BigDecimal getR0830_res_morethan_3_years_mkt_val() {
		return r0830_res_morethan_3_years_mkt_val;
	}




	public void setR0830_res_morethan_3_years_mkt_val(BigDecimal r0830_res_morethan_3_years_mkt_val) {
		this.r0830_res_morethan_3_years_mkt_val = r0830_res_morethan_3_years_mkt_val;
	}




	public BigDecimal getR0830_res_nat_amt() {
		return r0830_res_nat_amt;
	}




	public void setR0830_res_nat_amt(BigDecimal r0830_res_nat_amt) {
		this.r0830_res_nat_amt = r0830_res_nat_amt;
	}




	public BigDecimal getR0830_sold_hedg_net_delta_pos() {
		return r0830_sold_hedg_net_delta_pos;
	}




	public void setR0830_sold_hedg_net_delta_pos(BigDecimal r0830_sold_hedg_net_delta_pos) {
		this.r0830_sold_hedg_net_delta_pos = r0830_sold_hedg_net_delta_pos;
	}




	public BigDecimal getR0830_sold_trad_net_delta_pos() {
		return r0830_sold_trad_net_delta_pos;
	}




	public void setR0830_sold_trad_net_delta_pos(BigDecimal r0830_sold_trad_net_delta_pos) {
		this.r0830_sold_trad_net_delta_pos = r0830_sold_trad_net_delta_pos;
	}




	public BigDecimal getR0830_trad_nat_amt() {
		return r0830_trad_nat_amt;
	}




	public void setR0830_trad_nat_amt(BigDecimal r0830_trad_nat_amt) {
		this.r0830_trad_nat_amt = r0830_trad_nat_amt;
	}




	public BigDecimal getR0830_within_1_year_nat_amt() {
		return r0830_within_1_year_nat_amt;
	}




	public void setR0830_within_1_year_nat_amt(BigDecimal r0830_within_1_year_nat_amt) {
		this.r0830_within_1_year_nat_amt = r0830_within_1_year_nat_amt;
	}




	public BigDecimal getR0840_1_to_3_years_nat_amt() {
		return r0840_1_to_3_years_nat_amt;
	}




	public void setR0840_1_to_3_years_nat_amt(BigDecimal r0840_1_to_3_years_nat_amt) {
		this.r0840_1_to_3_years_nat_amt = r0840_1_to_3_years_nat_amt;
	}




	public BigDecimal getR0840_bought_hedg_net_delta_pos() {
		return r0840_bought_hedg_net_delta_pos;
	}




	public void setR0840_bought_hedg_net_delta_pos(BigDecimal r0840_bought_hedg_net_delta_pos) {
		this.r0840_bought_hedg_net_delta_pos = r0840_bought_hedg_net_delta_pos;
	}




	public BigDecimal getR0840_bought_trad_net_delta_pos() {
		return r0840_bought_trad_net_delta_pos;
	}




	public void setR0840_bought_trad_net_delta_pos(BigDecimal r0840_bought_trad_net_delta_pos) {
		this.r0840_bought_trad_net_delta_pos = r0840_bought_trad_net_delta_pos;
	}




	public BigDecimal getR0840_gross_mkt_val() {
		return r0840_gross_mkt_val;
	}




	public void setR0840_gross_mkt_val(BigDecimal r0840_gross_mkt_val) {
		this.r0840_gross_mkt_val = r0840_gross_mkt_val;
	}




	public BigDecimal getR0840_hedg_nat_amt() {
		return r0840_hedg_nat_amt;
	}




	public void setR0840_hedg_nat_amt(BigDecimal r0840_hedg_nat_amt) {
		this.r0840_hedg_nat_amt = r0840_hedg_nat_amt;
	}




	public BigDecimal getR0840_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0840_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0840_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0840_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0840_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0840_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0840_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0840_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0840_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0840_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0840_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0840_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0840_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0840_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0840_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0840_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0840_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0840_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0840_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0840_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0840_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0840_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0840_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0840_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0840_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0840_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0840_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0840_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0840_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0840_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0840_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0840_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0840_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0840_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0840_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0840_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0840_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0840_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0840_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0840_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0840_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0840_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0840_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0840_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0840_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0840_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0840_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0840_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0840_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0840_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0840_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0840_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0840_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0840_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0840_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0840_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0840_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0840_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0840_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0840_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0840_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0840_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0840_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0840_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0840_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0840_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0840_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0840_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0840_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0840_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0840_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0840_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public BigDecimal getR0840_nat_amt() {
		return r0840_nat_amt;
	}




	public void setR0840_nat_amt(BigDecimal r0840_nat_amt) {
		this.r0840_nat_amt = r0840_nat_amt;
	}




	public BigDecimal getR0840_non_res_nat_amt() {
		return r0840_non_res_nat_amt;
	}




	public void setR0840_non_res_nat_amt(BigDecimal r0840_non_res_nat_amt) {
		this.r0840_non_res_nat_amt = r0840_non_res_nat_amt;
	}




	public BigDecimal getR0840_over_3_years_nat_amt() {
		return r0840_over_3_years_nat_amt;
	}




	public void setR0840_over_3_years_nat_amt(BigDecimal r0840_over_3_years_nat_amt) {
		this.r0840_over_3_years_nat_amt = r0840_over_3_years_nat_amt;
	}




	public BigDecimal getR0840_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0840_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0840_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0840_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0840_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0840_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0840_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0840_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0840_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0840_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0840_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0840_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0840_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0840_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0840_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0840_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0840_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0840_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0840_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0840_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0840_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0840_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0840_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0840_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0840_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0840_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0840_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0840_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0840_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0840_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0840_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0840_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0840_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0840_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0840_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0840_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0840_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0840_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0840_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0840_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0840_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0840_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0840_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0840_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0840_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0840_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0840_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0840_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0840_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0840_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0840_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0840_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0840_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0840_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0840_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0840_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0840_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0840_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0840_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0840_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0840_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0840_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0840_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0840_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0840_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0840_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0840_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0840_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0840_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0840_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0840_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0840_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public String getR0840_product() {
		return r0840_product;
	}




	public void setR0840_product(String r0840_product) {
		this.r0840_product = r0840_product;
	}




	public BigDecimal getR0840_pro_bought_net_gain_loss() {
		return r0840_pro_bought_net_gain_loss;
	}




	public void setR0840_pro_bought_net_gain_loss(BigDecimal r0840_pro_bought_net_gain_loss) {
		this.r0840_pro_bought_net_gain_loss = r0840_pro_bought_net_gain_loss;
	}




	public BigDecimal getR0840_pro_sold_net_gain_loss() {
		return r0840_pro_sold_net_gain_loss;
	}




	public void setR0840_pro_sold_net_gain_loss(BigDecimal r0840_pro_sold_net_gain_loss) {
		this.r0840_pro_sold_net_gain_loss = r0840_pro_sold_net_gain_loss;
	}




	public BigDecimal getR0840_res_1_to_3_years_mkt_val() {
		return r0840_res_1_to_3_years_mkt_val;
	}




	public void setR0840_res_1_to_3_years_mkt_val(BigDecimal r0840_res_1_to_3_years_mkt_val) {
		this.r0840_res_1_to_3_years_mkt_val = r0840_res_1_to_3_years_mkt_val;
	}




	public BigDecimal getR0840_res_lessthan_1_year_mkt_val() {
		return r0840_res_lessthan_1_year_mkt_val;
	}




	public void setR0840_res_lessthan_1_year_mkt_val(BigDecimal r0840_res_lessthan_1_year_mkt_val) {
		this.r0840_res_lessthan_1_year_mkt_val = r0840_res_lessthan_1_year_mkt_val;
	}




	public BigDecimal getR0840_res_morethan_3_years_mkt_val() {
		return r0840_res_morethan_3_years_mkt_val;
	}




	public void setR0840_res_morethan_3_years_mkt_val(BigDecimal r0840_res_morethan_3_years_mkt_val) {
		this.r0840_res_morethan_3_years_mkt_val = r0840_res_morethan_3_years_mkt_val;
	}




	public BigDecimal getR0840_res_nat_amt() {
		return r0840_res_nat_amt;
	}




	public void setR0840_res_nat_amt(BigDecimal r0840_res_nat_amt) {
		this.r0840_res_nat_amt = r0840_res_nat_amt;
	}




	public BigDecimal getR0840_sold_hedg_net_delta_pos() {
		return r0840_sold_hedg_net_delta_pos;
	}




	public void setR0840_sold_hedg_net_delta_pos(BigDecimal r0840_sold_hedg_net_delta_pos) {
		this.r0840_sold_hedg_net_delta_pos = r0840_sold_hedg_net_delta_pos;
	}




	public BigDecimal getR0840_sold_trad_net_delta_pos() {
		return r0840_sold_trad_net_delta_pos;
	}




	public void setR0840_sold_trad_net_delta_pos(BigDecimal r0840_sold_trad_net_delta_pos) {
		this.r0840_sold_trad_net_delta_pos = r0840_sold_trad_net_delta_pos;
	}




	public BigDecimal getR0840_trad_nat_amt() {
		return r0840_trad_nat_amt;
	}




	public void setR0840_trad_nat_amt(BigDecimal r0840_trad_nat_amt) {
		this.r0840_trad_nat_amt = r0840_trad_nat_amt;
	}




	public BigDecimal getR0840_within_1_year_nat_amt() {
		return r0840_within_1_year_nat_amt;
	}




	public void setR0840_within_1_year_nat_amt(BigDecimal r0840_within_1_year_nat_amt) {
		this.r0840_within_1_year_nat_amt = r0840_within_1_year_nat_amt;
	}




	public BigDecimal getR0850_1_to_3_years_nat_amt() {
		return r0850_1_to_3_years_nat_amt;
	}




	public void setR0850_1_to_3_years_nat_amt(BigDecimal r0850_1_to_3_years_nat_amt) {
		this.r0850_1_to_3_years_nat_amt = r0850_1_to_3_years_nat_amt;
	}




	public BigDecimal getR0850_bought_hedg_net_delta_pos() {
		return r0850_bought_hedg_net_delta_pos;
	}




	public void setR0850_bought_hedg_net_delta_pos(BigDecimal r0850_bought_hedg_net_delta_pos) {
		this.r0850_bought_hedg_net_delta_pos = r0850_bought_hedg_net_delta_pos;
	}




	public BigDecimal getR0850_bought_trad_net_delta_pos() {
		return r0850_bought_trad_net_delta_pos;
	}




	public void setR0850_bought_trad_net_delta_pos(BigDecimal r0850_bought_trad_net_delta_pos) {
		this.r0850_bought_trad_net_delta_pos = r0850_bought_trad_net_delta_pos;
	}




	public BigDecimal getR0850_gross_mkt_val() {
		return r0850_gross_mkt_val;
	}




	public void setR0850_gross_mkt_val(BigDecimal r0850_gross_mkt_val) {
		this.r0850_gross_mkt_val = r0850_gross_mkt_val;
	}




	public BigDecimal getR0850_hedg_nat_amt() {
		return r0850_hedg_nat_amt;
	}




	public void setR0850_hedg_nat_amt(BigDecimal r0850_hedg_nat_amt) {
		this.r0850_hedg_nat_amt = r0850_hedg_nat_amt;
	}




	public BigDecimal getR0850_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0850_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0850_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0850_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0850_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0850_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0850_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0850_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0850_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0850_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0850_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0850_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0850_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0850_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0850_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0850_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0850_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0850_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0850_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0850_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0850_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0850_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0850_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0850_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0850_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0850_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0850_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0850_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0850_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0850_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0850_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0850_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0850_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0850_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0850_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0850_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0850_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0850_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0850_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0850_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0850_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0850_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0850_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0850_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0850_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0850_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0850_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0850_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0850_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0850_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0850_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0850_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0850_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0850_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0850_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0850_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0850_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0850_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0850_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0850_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0850_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0850_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0850_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0850_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0850_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0850_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0850_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0850_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0850_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0850_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0850_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0850_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public BigDecimal getR0850_nat_amt() {
		return r0850_nat_amt;
	}




	public void setR0850_nat_amt(BigDecimal r0850_nat_amt) {
		this.r0850_nat_amt = r0850_nat_amt;
	}




	public BigDecimal getR0850_non_res_nat_amt() {
		return r0850_non_res_nat_amt;
	}




	public void setR0850_non_res_nat_amt(BigDecimal r0850_non_res_nat_amt) {
		this.r0850_non_res_nat_amt = r0850_non_res_nat_amt;
	}




	public BigDecimal getR0850_over_3_years_nat_amt() {
		return r0850_over_3_years_nat_amt;
	}




	public void setR0850_over_3_years_nat_amt(BigDecimal r0850_over_3_years_nat_amt) {
		this.r0850_over_3_years_nat_amt = r0850_over_3_years_nat_amt;
	}




	public BigDecimal getR0850_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0850_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0850_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0850_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0850_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0850_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0850_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0850_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0850_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0850_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0850_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0850_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0850_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0850_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0850_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0850_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0850_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0850_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0850_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0850_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0850_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0850_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0850_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0850_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0850_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0850_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0850_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0850_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0850_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0850_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0850_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0850_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0850_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0850_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0850_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0850_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0850_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0850_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0850_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0850_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0850_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0850_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0850_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0850_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0850_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0850_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0850_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0850_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0850_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0850_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0850_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0850_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0850_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0850_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0850_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0850_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0850_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0850_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0850_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0850_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0850_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0850_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0850_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0850_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0850_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0850_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0850_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0850_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0850_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0850_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0850_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0850_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public String getR0850_product() {
		return r0850_product;
	}




	public void setR0850_product(String r0850_product) {
		this.r0850_product = r0850_product;
	}




	public BigDecimal getR0850_pro_bought_net_gain_loss() {
		return r0850_pro_bought_net_gain_loss;
	}




	public void setR0850_pro_bought_net_gain_loss(BigDecimal r0850_pro_bought_net_gain_loss) {
		this.r0850_pro_bought_net_gain_loss = r0850_pro_bought_net_gain_loss;
	}




	public BigDecimal getR0850_pro_sold_net_gain_loss() {
		return r0850_pro_sold_net_gain_loss;
	}




	public void setR0850_pro_sold_net_gain_loss(BigDecimal r0850_pro_sold_net_gain_loss) {
		this.r0850_pro_sold_net_gain_loss = r0850_pro_sold_net_gain_loss;
	}




	public BigDecimal getR0850_res_1_to_3_years_mkt_val() {
		return r0850_res_1_to_3_years_mkt_val;
	}




	public void setR0850_res_1_to_3_years_mkt_val(BigDecimal r0850_res_1_to_3_years_mkt_val) {
		this.r0850_res_1_to_3_years_mkt_val = r0850_res_1_to_3_years_mkt_val;
	}




	public BigDecimal getR0850_res_lessthan_1_year_mkt_val() {
		return r0850_res_lessthan_1_year_mkt_val;
	}




	public void setR0850_res_lessthan_1_year_mkt_val(BigDecimal r0850_res_lessthan_1_year_mkt_val) {
		this.r0850_res_lessthan_1_year_mkt_val = r0850_res_lessthan_1_year_mkt_val;
	}




	public BigDecimal getR0850_res_morethan_3_years_mkt_val() {
		return r0850_res_morethan_3_years_mkt_val;
	}




	public void setR0850_res_morethan_3_years_mkt_val(BigDecimal r0850_res_morethan_3_years_mkt_val) {
		this.r0850_res_morethan_3_years_mkt_val = r0850_res_morethan_3_years_mkt_val;
	}




	public BigDecimal getR0850_res_nat_amt() {
		return r0850_res_nat_amt;
	}




	public void setR0850_res_nat_amt(BigDecimal r0850_res_nat_amt) {
		this.r0850_res_nat_amt = r0850_res_nat_amt;
	}




	public BigDecimal getR0850_sold_hedg_net_delta_pos() {
		return r0850_sold_hedg_net_delta_pos;
	}




	public void setR0850_sold_hedg_net_delta_pos(BigDecimal r0850_sold_hedg_net_delta_pos) {
		this.r0850_sold_hedg_net_delta_pos = r0850_sold_hedg_net_delta_pos;
	}




	public BigDecimal getR0850_sold_trad_net_delta_pos() {
		return r0850_sold_trad_net_delta_pos;
	}




	public void setR0850_sold_trad_net_delta_pos(BigDecimal r0850_sold_trad_net_delta_pos) {
		this.r0850_sold_trad_net_delta_pos = r0850_sold_trad_net_delta_pos;
	}




	public BigDecimal getR0850_trad_nat_amt() {
		return r0850_trad_nat_amt;
	}




	public void setR0850_trad_nat_amt(BigDecimal r0850_trad_nat_amt) {
		this.r0850_trad_nat_amt = r0850_trad_nat_amt;
	}




	public BigDecimal getR0850_within_1_year_nat_amt() {
		return r0850_within_1_year_nat_amt;
	}




	public void setR0850_within_1_year_nat_amt(BigDecimal r0850_within_1_year_nat_amt) {
		this.r0850_within_1_year_nat_amt = r0850_within_1_year_nat_amt;
	}




	public String getReport_code() {
		return report_code;
	}




	public void setReport_code(String report_code) {
		this.report_code = report_code;
	}




	public Date getReport_date() {
		return report_date;
	}




	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}




	public String getReport_desc() {
		return report_desc;
	}




	public void setReport_desc(String report_desc) {
		this.report_desc = report_desc;
	}




	public String getReport_frequency() {
		return report_frequency;
	}




	public void setReport_frequency(String report_frequency) {
		this.report_frequency = report_frequency;
	}




	public String getReport_version() {
		return report_version;
	}




	public void setReport_version(String report_version) {
		this.report_version = report_version;
	}




	public CBUAE_BRF7_3_Summary_Entity4() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
