package com.bornfire.brf.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CBUAE_BRF7_3_SUMMARYTABLE6")
public class CBUAE_BRF7_3_Summary_Entity6 {

	private  String  r0880_product;
	private  String  r0890_1_to_3_years_nat_amt;
	private  String  r0890_bought_hedg_net_delta_pos;
	private  String  r0890_bought_trad_net_delta_pos;
	private  String  r0890_gross_mkt_val;
	private  String  r0890_hedg_nat_amt;
	private  String  r0890_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  String  r0890_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  String  r0890_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  String  r0890_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  String  r0890_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  String  r0890_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  String  r0890_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  String  r0890_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  String  r0890_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  String  r0890_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  String  r0890_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  String  r0890_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0890_nat_amt;
	private  String  r0890_non_res_nat_amt;
	private  String  r0890_over_3_years_nat_amt;
	private  String  r0890_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  String  r0890_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  String  r0890_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  String  r0890_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  String  r0890_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  String  r0890_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  String  r0890_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  String  r0890_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  String  r0890_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  String  r0890_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  String  r0890_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  String  r0890_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0890_product;
	private  String  r0890_pro_bought_net_gain_loss;
	private  String  r0890_pro_sold_net_gain_loss;
	private  String  r0890_res_1_to_3_years_mkt_val;
	private  String  r0890_res_lessthan_1_year_mkt_val;
	private  String  r0890_res_morethan_3_years_mkt_val;
	private  String  r0890_res_nat_amt;
	private  String  r0890_sold_hedg_net_delta_pos;
	private  String  r0890_sold_trad_net_delta_pos;
	private  String  r0890_trad_nat_amt;
	private  String  r0890_within_1_year_nat_amt;
	private  String  report_code;
	@Id    
	private  Date  report_date;
	private  String  report_desc;
	private  String  report_frequency;
	private  String  report_version;

	
	public String getR0880_product() {
		return r0880_product;
	}


	public void setR0880_product(String r0880_product) {
		this.r0880_product = r0880_product;
	}


	public String getR0890_1_to_3_years_nat_amt() {
		return r0890_1_to_3_years_nat_amt;
	}


	public void setR0890_1_to_3_years_nat_amt(String r0890_1_to_3_years_nat_amt) {
		this.r0890_1_to_3_years_nat_amt = r0890_1_to_3_years_nat_amt;
	}


	public String getR0890_bought_hedg_net_delta_pos() {
		return r0890_bought_hedg_net_delta_pos;
	}


	public void setR0890_bought_hedg_net_delta_pos(String r0890_bought_hedg_net_delta_pos) {
		this.r0890_bought_hedg_net_delta_pos = r0890_bought_hedg_net_delta_pos;
	}


	public String getR0890_bought_trad_net_delta_pos() {
		return r0890_bought_trad_net_delta_pos;
	}


	public void setR0890_bought_trad_net_delta_pos(String r0890_bought_trad_net_delta_pos) {
		this.r0890_bought_trad_net_delta_pos = r0890_bought_trad_net_delta_pos;
	}


	public String getR0890_gross_mkt_val() {
		return r0890_gross_mkt_val;
	}


	public void setR0890_gross_mkt_val(String r0890_gross_mkt_val) {
		this.r0890_gross_mkt_val = r0890_gross_mkt_val;
	}


	public String getR0890_hedg_nat_amt() {
		return r0890_hedg_nat_amt;
	}


	public void setR0890_hedg_nat_amt(String r0890_hedg_nat_amt) {
		this.r0890_hedg_nat_amt = r0890_hedg_nat_amt;
	}


	public String getR0890_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0890_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}


	public void setR0890_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			String r0890_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0890_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0890_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}


	public String getR0890_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0890_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}


	public void setR0890_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			String r0890_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0890_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0890_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}


	public String getR0890_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0890_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}


	public void setR0890_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			String r0890_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0890_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0890_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}


	public String getR0890_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0890_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}


	public void setR0890_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			String r0890_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0890_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0890_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}


	public String getR0890_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0890_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}


	public void setR0890_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			String r0890_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0890_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0890_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}


	public String getR0890_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0890_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}


	public void setR0890_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			String r0890_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0890_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0890_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}


	public String getR0890_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0890_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}


	public void setR0890_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			String r0890_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0890_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0890_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}


	public String getR0890_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0890_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}


	public void setR0890_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			String r0890_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0890_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0890_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}


	public String getR0890_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0890_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}


	public void setR0890_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			String r0890_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0890_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0890_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}


	public String getR0890_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0890_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}


	public void setR0890_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			String r0890_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0890_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0890_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}


	public String getR0890_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0890_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}


	public void setR0890_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			String r0890_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0890_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0890_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}


	public String getR0890_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0890_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}


	public void setR0890_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			String r0890_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0890_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0890_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}


	public String getR0890_nat_amt() {
		return r0890_nat_amt;
	}


	public void setR0890_nat_amt(String r0890_nat_amt) {
		this.r0890_nat_amt = r0890_nat_amt;
	}


	public String getR0890_non_res_nat_amt() {
		return r0890_non_res_nat_amt;
	}


	public void setR0890_non_res_nat_amt(String r0890_non_res_nat_amt) {
		this.r0890_non_res_nat_amt = r0890_non_res_nat_amt;
	}


	public String getR0890_over_3_years_nat_amt() {
		return r0890_over_3_years_nat_amt;
	}


	public void setR0890_over_3_years_nat_amt(String r0890_over_3_years_nat_amt) {
		this.r0890_over_3_years_nat_amt = r0890_over_3_years_nat_amt;
	}


	public String getR0890_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0890_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}


	public void setR0890_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			String r0890_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0890_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0890_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}


	public String getR0890_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0890_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}


	public void setR0890_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			String r0890_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0890_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0890_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}


	public String getR0890_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0890_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}


	public void setR0890_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			String r0890_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0890_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0890_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}


	public String getR0890_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0890_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}


	public void setR0890_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			String r0890_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0890_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0890_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}


	public String getR0890_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0890_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}


	public void setR0890_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			String r0890_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0890_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0890_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}


	public String getR0890_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0890_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}


	public void setR0890_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			String r0890_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0890_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0890_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}


	public String getR0890_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0890_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}


	public void setR0890_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			String r0890_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0890_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0890_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}


	public String getR0890_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0890_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}


	public void setR0890_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			String r0890_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0890_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0890_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}


	public String getR0890_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0890_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}


	public void setR0890_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			String r0890_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0890_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0890_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}


	public String getR0890_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0890_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}


	public void setR0890_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			String r0890_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0890_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0890_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}


	public String getR0890_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0890_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}


	public void setR0890_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			String r0890_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0890_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0890_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}


	public String getR0890_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0890_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}


	public void setR0890_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			String r0890_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0890_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0890_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}


	public String getR0890_product() {
		return r0890_product;
	}


	public void setR0890_product(String r0890_product) {
		this.r0890_product = r0890_product;
	}


	public String getR0890_pro_bought_net_gain_loss() {
		return r0890_pro_bought_net_gain_loss;
	}


	public void setR0890_pro_bought_net_gain_loss(String r0890_pro_bought_net_gain_loss) {
		this.r0890_pro_bought_net_gain_loss = r0890_pro_bought_net_gain_loss;
	}


	public String getR0890_pro_sold_net_gain_loss() {
		return r0890_pro_sold_net_gain_loss;
	}


	public void setR0890_pro_sold_net_gain_loss(String r0890_pro_sold_net_gain_loss) {
		this.r0890_pro_sold_net_gain_loss = r0890_pro_sold_net_gain_loss;
	}


	public String getR0890_res_1_to_3_years_mkt_val() {
		return r0890_res_1_to_3_years_mkt_val;
	}


	public void setR0890_res_1_to_3_years_mkt_val(String r0890_res_1_to_3_years_mkt_val) {
		this.r0890_res_1_to_3_years_mkt_val = r0890_res_1_to_3_years_mkt_val;
	}


	public String getR0890_res_lessthan_1_year_mkt_val() {
		return r0890_res_lessthan_1_year_mkt_val;
	}


	public void setR0890_res_lessthan_1_year_mkt_val(String r0890_res_lessthan_1_year_mkt_val) {
		this.r0890_res_lessthan_1_year_mkt_val = r0890_res_lessthan_1_year_mkt_val;
	}


	public String getR0890_res_morethan_3_years_mkt_val() {
		return r0890_res_morethan_3_years_mkt_val;
	}


	public void setR0890_res_morethan_3_years_mkt_val(String r0890_res_morethan_3_years_mkt_val) {
		this.r0890_res_morethan_3_years_mkt_val = r0890_res_morethan_3_years_mkt_val;
	}


	public String getR0890_res_nat_amt() {
		return r0890_res_nat_amt;
	}


	public void setR0890_res_nat_amt(String r0890_res_nat_amt) {
		this.r0890_res_nat_amt = r0890_res_nat_amt;
	}


	public String getR0890_sold_hedg_net_delta_pos() {
		return r0890_sold_hedg_net_delta_pos;
	}


	public void setR0890_sold_hedg_net_delta_pos(String r0890_sold_hedg_net_delta_pos) {
		this.r0890_sold_hedg_net_delta_pos = r0890_sold_hedg_net_delta_pos;
	}


	public String getR0890_sold_trad_net_delta_pos() {
		return r0890_sold_trad_net_delta_pos;
	}


	public void setR0890_sold_trad_net_delta_pos(String r0890_sold_trad_net_delta_pos) {
		this.r0890_sold_trad_net_delta_pos = r0890_sold_trad_net_delta_pos;
	}


	public String getR0890_trad_nat_amt() {
		return r0890_trad_nat_amt;
	}


	public void setR0890_trad_nat_amt(String r0890_trad_nat_amt) {
		this.r0890_trad_nat_amt = r0890_trad_nat_amt;
	}


	public String getR0890_within_1_year_nat_amt() {
		return r0890_within_1_year_nat_amt;
	}


	public void setR0890_within_1_year_nat_amt(String r0890_within_1_year_nat_amt) {
		this.r0890_within_1_year_nat_amt = r0890_within_1_year_nat_amt;
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


	public CBUAE_BRF7_3_Summary_Entity6() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
