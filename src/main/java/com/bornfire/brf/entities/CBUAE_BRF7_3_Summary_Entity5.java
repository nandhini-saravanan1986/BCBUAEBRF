package com.bornfire.brf.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CBUAE_BRF7_3_SUMMARYTABLE5")
public class CBUAE_BRF7_3_Summary_Entity5 {

	private  String  r0860_product;
	private  String  r0870_1_to_3_years_nat_amt;
	private  String  r0870_bought_hedg_net_delta_pos;
	private  String  r0870_bought_trad_net_delta_pos;
	private  String  r0870_gross_mkt_val;
	private  String  r0870_hedg_nat_amt;
	private  String  r0870_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  String  r0870_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  String  r0870_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  String  r0870_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  String  r0870_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  String  r0870_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  String  r0870_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  String  r0870_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  String  r0870_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  String  r0870_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  String  r0870_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  String  r0870_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0870_nat_amt;
	private  String  r0870_non_res_nat_amt;
	private  String  r0870_over_3_years_nat_amt;
	private  String  r0870_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  String  r0870_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  String  r0870_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  String  r0870_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  String  r0870_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  String  r0870_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  String  r0870_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  String  r0870_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  String  r0870_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  String  r0870_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  String  r0870_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  String  r0870_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0870_product;
	private  String  r0870_pro_bought_net_gain_loss;
	private  String  r0870_pro_sold_net_gain_loss;
	private  String  r0870_res_1_to_3_years_mkt_val;
	private  String  r0870_res_lessthan_1_year_mkt_val;
	private  String  r0870_res_morethan_3_years_mkt_val;
	private  String  r0870_res_nat_amt;
	private  String  r0870_sold_hedg_net_delta_pos;
	private  String  r0870_sold_trad_net_delta_pos;
	private  String  r0870_trad_nat_amt;
	private  String  r0870_within_1_year_nat_amt;
	private  String  report_code;
	@Id    
	private  Date  report_date;
	private  String  report_desc;
	private  String  report_frequency;
	private  String  report_version;

	
	public String getR0860_product() {
		return r0860_product;
	}


	public void setR0860_product(String r0860_product) {
		this.r0860_product = r0860_product;
	}


	public String getR0870_1_to_3_years_nat_amt() {
		return r0870_1_to_3_years_nat_amt;
	}


	public void setR0870_1_to_3_years_nat_amt(String r0870_1_to_3_years_nat_amt) {
		this.r0870_1_to_3_years_nat_amt = r0870_1_to_3_years_nat_amt;
	}


	public String getR0870_bought_hedg_net_delta_pos() {
		return r0870_bought_hedg_net_delta_pos;
	}


	public void setR0870_bought_hedg_net_delta_pos(String r0870_bought_hedg_net_delta_pos) {
		this.r0870_bought_hedg_net_delta_pos = r0870_bought_hedg_net_delta_pos;
	}


	public String getR0870_bought_trad_net_delta_pos() {
		return r0870_bought_trad_net_delta_pos;
	}


	public void setR0870_bought_trad_net_delta_pos(String r0870_bought_trad_net_delta_pos) {
		this.r0870_bought_trad_net_delta_pos = r0870_bought_trad_net_delta_pos;
	}


	public String getR0870_gross_mkt_val() {
		return r0870_gross_mkt_val;
	}


	public void setR0870_gross_mkt_val(String r0870_gross_mkt_val) {
		this.r0870_gross_mkt_val = r0870_gross_mkt_val;
	}


	public String getR0870_hedg_nat_amt() {
		return r0870_hedg_nat_amt;
	}


	public void setR0870_hedg_nat_amt(String r0870_hedg_nat_amt) {
		this.r0870_hedg_nat_amt = r0870_hedg_nat_amt;
	}


	public String getR0870_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0870_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}


	public void setR0870_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			String r0870_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0870_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0870_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}


	public String getR0870_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0870_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}


	public void setR0870_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			String r0870_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0870_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0870_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}


	public String getR0870_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0870_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}


	public void setR0870_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			String r0870_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0870_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0870_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}


	public String getR0870_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0870_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}


	public void setR0870_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			String r0870_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0870_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0870_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}


	public String getR0870_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0870_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}


	public void setR0870_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			String r0870_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0870_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0870_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}


	public String getR0870_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0870_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}


	public void setR0870_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			String r0870_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0870_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0870_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}


	public String getR0870_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0870_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}


	public void setR0870_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			String r0870_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0870_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0870_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}


	public String getR0870_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0870_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}


	public void setR0870_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			String r0870_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0870_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0870_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}


	public String getR0870_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0870_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}


	public void setR0870_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			String r0870_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0870_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0870_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}


	public String getR0870_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0870_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}


	public void setR0870_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			String r0870_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0870_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0870_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}


	public String getR0870_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0870_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}


	public void setR0870_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			String r0870_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0870_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0870_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}


	public String getR0870_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0870_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}


	public void setR0870_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			String r0870_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0870_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0870_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}


	public String getR0870_nat_amt() {
		return r0870_nat_amt;
	}


	public void setR0870_nat_amt(String r0870_nat_amt) {
		this.r0870_nat_amt = r0870_nat_amt;
	}


	public String getR0870_non_res_nat_amt() {
		return r0870_non_res_nat_amt;
	}


	public void setR0870_non_res_nat_amt(String r0870_non_res_nat_amt) {
		this.r0870_non_res_nat_amt = r0870_non_res_nat_amt;
	}


	public String getR0870_over_3_years_nat_amt() {
		return r0870_over_3_years_nat_amt;
	}


	public void setR0870_over_3_years_nat_amt(String r0870_over_3_years_nat_amt) {
		this.r0870_over_3_years_nat_amt = r0870_over_3_years_nat_amt;
	}


	public String getR0870_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0870_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}


	public void setR0870_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			String r0870_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0870_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0870_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}


	public String getR0870_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0870_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}


	public void setR0870_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			String r0870_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0870_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0870_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}


	public String getR0870_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0870_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}


	public void setR0870_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			String r0870_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0870_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0870_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}


	public String getR0870_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0870_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}


	public void setR0870_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			String r0870_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0870_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0870_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}


	public String getR0870_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0870_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}


	public void setR0870_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			String r0870_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0870_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0870_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}


	public String getR0870_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0870_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}


	public void setR0870_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			String r0870_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0870_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0870_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}


	public String getR0870_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0870_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}


	public void setR0870_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			String r0870_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0870_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0870_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}


	public String getR0870_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0870_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}


	public void setR0870_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			String r0870_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0870_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0870_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}


	public String getR0870_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0870_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}


	public void setR0870_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			String r0870_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0870_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0870_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}


	public String getR0870_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0870_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}


	public void setR0870_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			String r0870_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0870_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0870_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}


	public String getR0870_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0870_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}


	public void setR0870_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			String r0870_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0870_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0870_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}


	public String getR0870_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0870_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}


	public void setR0870_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			String r0870_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0870_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0870_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}


	public String getR0870_product() {
		return r0870_product;
	}


	public void setR0870_product(String r0870_product) {
		this.r0870_product = r0870_product;
	}


	public String getR0870_pro_bought_net_gain_loss() {
		return r0870_pro_bought_net_gain_loss;
	}


	public void setR0870_pro_bought_net_gain_loss(String r0870_pro_bought_net_gain_loss) {
		this.r0870_pro_bought_net_gain_loss = r0870_pro_bought_net_gain_loss;
	}


	public String getR0870_pro_sold_net_gain_loss() {
		return r0870_pro_sold_net_gain_loss;
	}


	public void setR0870_pro_sold_net_gain_loss(String r0870_pro_sold_net_gain_loss) {
		this.r0870_pro_sold_net_gain_loss = r0870_pro_sold_net_gain_loss;
	}


	public String getR0870_res_1_to_3_years_mkt_val() {
		return r0870_res_1_to_3_years_mkt_val;
	}


	public void setR0870_res_1_to_3_years_mkt_val(String r0870_res_1_to_3_years_mkt_val) {
		this.r0870_res_1_to_3_years_mkt_val = r0870_res_1_to_3_years_mkt_val;
	}


	public String getR0870_res_lessthan_1_year_mkt_val() {
		return r0870_res_lessthan_1_year_mkt_val;
	}


	public void setR0870_res_lessthan_1_year_mkt_val(String r0870_res_lessthan_1_year_mkt_val) {
		this.r0870_res_lessthan_1_year_mkt_val = r0870_res_lessthan_1_year_mkt_val;
	}


	public String getR0870_res_morethan_3_years_mkt_val() {
		return r0870_res_morethan_3_years_mkt_val;
	}


	public void setR0870_res_morethan_3_years_mkt_val(String r0870_res_morethan_3_years_mkt_val) {
		this.r0870_res_morethan_3_years_mkt_val = r0870_res_morethan_3_years_mkt_val;
	}


	public String getR0870_res_nat_amt() {
		return r0870_res_nat_amt;
	}


	public void setR0870_res_nat_amt(String r0870_res_nat_amt) {
		this.r0870_res_nat_amt = r0870_res_nat_amt;
	}


	public String getR0870_sold_hedg_net_delta_pos() {
		return r0870_sold_hedg_net_delta_pos;
	}


	public void setR0870_sold_hedg_net_delta_pos(String r0870_sold_hedg_net_delta_pos) {
		this.r0870_sold_hedg_net_delta_pos = r0870_sold_hedg_net_delta_pos;
	}


	public String getR0870_sold_trad_net_delta_pos() {
		return r0870_sold_trad_net_delta_pos;
	}


	public void setR0870_sold_trad_net_delta_pos(String r0870_sold_trad_net_delta_pos) {
		this.r0870_sold_trad_net_delta_pos = r0870_sold_trad_net_delta_pos;
	}


	public String getR0870_trad_nat_amt() {
		return r0870_trad_nat_amt;
	}


	public void setR0870_trad_nat_amt(String r0870_trad_nat_amt) {
		this.r0870_trad_nat_amt = r0870_trad_nat_amt;
	}


	public String getR0870_within_1_year_nat_amt() {
		return r0870_within_1_year_nat_amt;
	}


	public void setR0870_within_1_year_nat_amt(String r0870_within_1_year_nat_amt) {
		this.r0870_within_1_year_nat_amt = r0870_within_1_year_nat_amt;
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


	public CBUAE_BRF7_3_Summary_Entity5() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
