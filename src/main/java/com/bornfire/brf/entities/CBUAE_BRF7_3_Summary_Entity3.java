package com.bornfire.brf.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CBUAE_BRF7_3_SUMMARYTABLE3")
public class CBUAE_BRF7_3_Summary_Entity3 {

	private  BigDecimal  r0520_1_to_3_years_nat_amt;
	private  BigDecimal  r0520_bought_hedg_net_delta_pos;
	private  BigDecimal  r0520_bought_trad_net_delta_pos;
	private  BigDecimal  r0520_gross_mkt_val;
	private  BigDecimal  r0520_hedg_nat_amt;
	private  BigDecimal  r0520_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0520_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0520_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0520_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0520_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0520_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0520_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0520_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0520_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0520_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0520_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0520_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0520_nat_amt;
	private  BigDecimal  r0520_non_res_nat_amt;
	private  BigDecimal  r0520_over_3_years_nat_amt;
	private  BigDecimal  r0520_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0520_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0520_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0520_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0520_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0520_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0520_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0520_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0520_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0520_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0520_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0520_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0520_product;
	private  BigDecimal  r0520_pro_bought_net_gain_loss;
	private  BigDecimal  r0520_pro_sold_net_gain_loss;
	private  BigDecimal  r0520_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0520_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0520_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0520_res_nat_amt;
	private  BigDecimal  r0520_sold_hedg_net_delta_pos;
	private  BigDecimal  r0520_sold_trad_net_delta_pos;
	private  BigDecimal  r0520_trad_nat_amt;
	private  BigDecimal  r0520_within_1_year_nat_amt;
	private  BigDecimal  r0530_1_to_3_years_nat_amt;
	private  BigDecimal  r0530_bought_hedg_net_delta_pos;
	private  BigDecimal  r0530_bought_trad_net_delta_pos;
	private  BigDecimal  r0530_gross_mkt_val;
	private  BigDecimal  r0530_hedg_nat_amt;
	private  BigDecimal  r0530_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0530_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0530_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0530_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0530_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0530_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0530_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0530_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0530_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0530_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0530_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0530_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0530_nat_amt;
	private  BigDecimal  r0530_non_res_nat_amt;
	private  BigDecimal  r0530_over_3_years_nat_amt;
	private  BigDecimal  r0530_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0530_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0530_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0530_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0530_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0530_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0530_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0530_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0530_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0530_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0530_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0530_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0530_product;
	private  BigDecimal  r0530_pro_bought_net_gain_loss;
	private  BigDecimal  r0530_pro_sold_net_gain_loss;
	private  BigDecimal  r0530_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0530_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0530_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0530_res_nat_amt;
	private  BigDecimal  r0530_sold_hedg_net_delta_pos;
	private  BigDecimal  r0530_sold_trad_net_delta_pos;
	private  BigDecimal  r0530_trad_nat_amt;
	private  BigDecimal  r0530_within_1_year_nat_amt;
	private  BigDecimal  r0540_1_to_3_years_nat_amt;
	private  BigDecimal  r0540_bought_hedg_net_delta_pos;
	private  BigDecimal  r0540_bought_trad_net_delta_pos;
	private  BigDecimal  r0540_gross_mkt_val;
	private  BigDecimal  r0540_hedg_nat_amt;
	private  BigDecimal  r0540_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0540_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0540_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0540_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0540_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0540_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0540_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0540_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0540_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0540_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0540_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0540_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0540_nat_amt;
	private  BigDecimal  r0540_non_res_nat_amt;
	private  BigDecimal  r0540_over_3_years_nat_amt;
	private  BigDecimal  r0540_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0540_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0540_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0540_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0540_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0540_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0540_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0540_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0540_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0540_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0540_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0540_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0540_product;
	private  BigDecimal  r0540_pro_bought_net_gain_loss;
	private  BigDecimal  r0540_pro_sold_net_gain_loss;
	private  BigDecimal  r0540_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0540_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0540_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0540_res_nat_amt;
	private  BigDecimal  r0540_sold_hedg_net_delta_pos;
	private  BigDecimal  r0540_sold_trad_net_delta_pos;
	private  BigDecimal  r0540_trad_nat_amt;
	private  BigDecimal  r0540_within_1_year_nat_amt;
	private  String  r0550_product;
	private  BigDecimal  r0560_1_to_3_years_nat_amt;
	private  BigDecimal  r0560_bought_hedg_net_delta_pos;
	private  BigDecimal  r0560_bought_trad_net_delta_pos;
	private  BigDecimal  r0560_gross_mkt_val;
	private  BigDecimal  r0560_hedg_nat_amt;
	private  BigDecimal  r0560_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0560_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0560_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0560_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0560_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0560_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0560_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0560_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0560_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0560_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0560_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0560_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0560_nat_amt;
	private  BigDecimal  r0560_non_res_nat_amt;
	private  BigDecimal  r0560_over_3_years_nat_amt;
	private  BigDecimal  r0560_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0560_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0560_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0560_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0560_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0560_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0560_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0560_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0560_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0560_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0560_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0560_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0560_product;
	private  BigDecimal  r0560_pro_bought_net_gain_loss;
	private  BigDecimal  r0560_pro_sold_net_gain_loss;
	private  BigDecimal  r0560_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0560_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0560_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0560_res_nat_amt;
	private  BigDecimal  r0560_sold_hedg_net_delta_pos;
	private  BigDecimal  r0560_sold_trad_net_delta_pos;
	private  BigDecimal  r0560_trad_nat_amt;
	private  BigDecimal  r0560_within_1_year_nat_amt;
	private  String  r0570_product;
	private  BigDecimal  r0580_1_to_3_years_nat_amt;
	private  BigDecimal  r0580_bought_hedg_net_delta_pos;
	private  BigDecimal  r0580_bought_trad_net_delta_pos;
	private  BigDecimal  r0580_gross_mkt_val;
	private  BigDecimal  r0580_hedg_nat_amt;
	private  BigDecimal  r0580_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0580_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0580_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0580_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0580_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0580_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0580_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0580_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0580_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0580_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0580_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0580_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0580_nat_amt;
	private  BigDecimal  r0580_non_res_nat_amt;
	private  BigDecimal  r0580_over_3_years_nat_amt;
	private  BigDecimal  r0580_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0580_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0580_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0580_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0580_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0580_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0580_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0580_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0580_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0580_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0580_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0580_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0580_product;
	private  BigDecimal  r0580_pro_bought_net_gain_loss;
	private  BigDecimal  r0580_pro_sold_net_gain_loss;
	private  BigDecimal  r0580_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0580_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0580_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0580_res_nat_amt;
	private  BigDecimal  r0580_sold_hedg_net_delta_pos;
	private  BigDecimal  r0580_sold_trad_net_delta_pos;
	private  BigDecimal  r0580_trad_nat_amt;
	private  BigDecimal  r0580_within_1_year_nat_amt;
	private  String  r0590_product;
	private  BigDecimal  r0600_1_to_3_years_nat_amt;
	private  BigDecimal  r0600_bought_hedg_net_delta_pos;
	private  BigDecimal  r0600_bought_trad_net_delta_pos;
	private  BigDecimal  r0600_gross_mkt_val;
	private  BigDecimal  r0600_hedg_nat_amt;
	private  BigDecimal  r0600_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0600_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0600_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0600_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0600_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0600_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0600_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0600_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0600_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0600_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0600_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0600_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0600_nat_amt;
	private  BigDecimal  r0600_non_res_nat_amt;
	private  BigDecimal  r0600_over_3_years_nat_amt;
	private  BigDecimal  r0600_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0600_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0600_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0600_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0600_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0600_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0600_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0600_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0600_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0600_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0600_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0600_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0600_product;
	private  BigDecimal  r0600_pro_bought_net_gain_loss;
	private  BigDecimal  r0600_pro_sold_net_gain_loss;
	private  BigDecimal  r0600_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0600_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0600_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0600_res_nat_amt;
	private  BigDecimal  r0600_sold_hedg_net_delta_pos;
	private  BigDecimal  r0600_sold_trad_net_delta_pos;
	private  BigDecimal  r0600_trad_nat_amt;
	private  BigDecimal  r0600_within_1_year_nat_amt;
	private  BigDecimal  r0610_1_to_3_years_nat_amt;
	private  BigDecimal  r0610_bought_hedg_net_delta_pos;
	private  BigDecimal  r0610_bought_trad_net_delta_pos;
	private  BigDecimal  r0610_gross_mkt_val;
	private  BigDecimal  r0610_hedg_nat_amt;
	private  BigDecimal  r0610_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0610_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0610_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0610_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0610_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0610_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0610_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0610_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0610_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0610_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0610_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0610_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0610_nat_amt;
	private  BigDecimal  r0610_non_res_nat_amt;
	private  BigDecimal  r0610_over_3_years_nat_amt;
	private  BigDecimal  r0610_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0610_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0610_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0610_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0610_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0610_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0610_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0610_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0610_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0610_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0610_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0610_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0610_product;
	private  BigDecimal  r0610_pro_bought_net_gain_loss;
	private  BigDecimal  r0610_pro_sold_net_gain_loss;
	private  BigDecimal  r0610_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0610_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0610_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0610_res_nat_amt;
	private  BigDecimal  r0610_sold_hedg_net_delta_pos;
	private  BigDecimal  r0610_sold_trad_net_delta_pos;
	private  BigDecimal  r0610_trad_nat_amt;
	private  BigDecimal  r0610_within_1_year_nat_amt;
	private  BigDecimal  r0620_1_to_3_years_nat_amt;
	private  BigDecimal  r0620_bought_hedg_net_delta_pos;
	private  BigDecimal  r0620_bought_trad_net_delta_pos;
	private  BigDecimal  r0620_gross_mkt_val;
	private  BigDecimal  r0620_hedg_nat_amt;
	private  BigDecimal  r0620_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0620_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0620_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0620_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0620_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0620_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0620_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0620_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0620_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0620_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0620_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0620_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0620_nat_amt;
	private  BigDecimal  r0620_non_res_nat_amt;
	private  BigDecimal  r0620_over_3_years_nat_amt;
	private  BigDecimal  r0620_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0620_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0620_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0620_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0620_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0620_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0620_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0620_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0620_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0620_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0620_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0620_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0620_product;
	private  BigDecimal  r0620_pro_bought_net_gain_loss;
	private  BigDecimal  r0620_pro_sold_net_gain_loss;
	private  BigDecimal  r0620_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0620_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0620_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0620_res_nat_amt;
	private  BigDecimal  r0620_sold_hedg_net_delta_pos;
	private  BigDecimal  r0620_sold_trad_net_delta_pos;
	private  BigDecimal  r0620_trad_nat_amt;
	private  BigDecimal  r0620_within_1_year_nat_amt;
	private  BigDecimal  r0630_1_to_3_years_nat_amt;
	private  BigDecimal  r0630_bought_hedg_net_delta_pos;
	private  BigDecimal  r0630_bought_trad_net_delta_pos;
	private  BigDecimal  r0630_gross_mkt_val;
	private  BigDecimal  r0630_hedg_nat_amt;
	private  BigDecimal  r0630_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0630_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0630_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0630_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0630_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0630_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0630_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0630_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0630_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0630_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0630_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0630_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0630_nat_amt;
	private  BigDecimal  r0630_non_res_nat_amt;
	private  BigDecimal  r0630_over_3_years_nat_amt;
	private  BigDecimal  r0630_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0630_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0630_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0630_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0630_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0630_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0630_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0630_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0630_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0630_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0630_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0630_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0630_product;
	private  BigDecimal  r0630_pro_bought_net_gain_loss;
	private  BigDecimal  r0630_pro_sold_net_gain_loss;
	private  BigDecimal  r0630_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0630_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0630_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0630_res_nat_amt;
	private  BigDecimal  r0630_sold_hedg_net_delta_pos;
	private  BigDecimal  r0630_sold_trad_net_delta_pos;
	private  BigDecimal  r0630_trad_nat_amt;
	private  BigDecimal  r0630_within_1_year_nat_amt;
	private  BigDecimal  r0640_1_to_3_years_nat_amt;
	private  BigDecimal  r0640_bought_hedg_net_delta_pos;
	private  BigDecimal  r0640_bought_trad_net_delta_pos;
	private  BigDecimal  r0640_gross_mkt_val;
	private  BigDecimal  r0640_hedg_nat_amt;
	private  BigDecimal  r0640_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0640_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0640_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0640_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0640_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0640_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0640_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0640_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0640_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0640_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0640_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0640_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0640_nat_amt;
	private  BigDecimal  r0640_non_res_nat_amt;
	private  BigDecimal  r0640_over_3_years_nat_amt;
	private  BigDecimal  r0640_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0640_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0640_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0640_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0640_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0640_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0640_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0640_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0640_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0640_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0640_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0640_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0640_product;
	private  BigDecimal  r0640_pro_bought_net_gain_loss;
	private  BigDecimal  r0640_pro_sold_net_gain_loss;
	private  BigDecimal  r0640_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0640_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0640_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0640_res_nat_amt;
	private  BigDecimal  r0640_sold_hedg_net_delta_pos;
	private  BigDecimal  r0640_sold_trad_net_delta_pos;
	private  BigDecimal  r0640_trad_nat_amt;
	private  BigDecimal  r0640_within_1_year_nat_amt;
	private  BigDecimal  r0650_1_to_3_years_nat_amt;
	private  BigDecimal  r0650_bought_hedg_net_delta_pos;
	private  BigDecimal  r0650_bought_trad_net_delta_pos;
	private  BigDecimal  r0650_gross_mkt_val;
	private  BigDecimal  r0650_hedg_nat_amt;
	private  BigDecimal  r0650_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0650_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0650_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0650_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0650_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0650_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0650_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0650_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0650_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0650_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0650_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0650_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0650_nat_amt;
	private  BigDecimal  r0650_non_res_nat_amt;
	private  BigDecimal  r0650_over_3_years_nat_amt;
	private  BigDecimal  r0650_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0650_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0650_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0650_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0650_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0650_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0650_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0650_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0650_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0650_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0650_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0650_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0650_product;
	private  BigDecimal  r0650_pro_bought_net_gain_loss;
	private  BigDecimal  r0650_pro_sold_net_gain_loss;
	private  BigDecimal  r0650_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0650_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0650_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0650_res_nat_amt;
	private  BigDecimal  r0650_sold_hedg_net_delta_pos;
	private  BigDecimal  r0650_sold_trad_net_delta_pos;
	private  BigDecimal  r0650_trad_nat_amt;
	private  BigDecimal  r0650_within_1_year_nat_amt;
	private  BigDecimal  r0660_1_to_3_years_nat_amt;
	private  BigDecimal  r0660_bought_hedg_net_delta_pos;
	private  BigDecimal  r0660_bought_trad_net_delta_pos;
	private  BigDecimal  r0660_gross_mkt_val;
	private  BigDecimal  r0660_hedg_nat_amt;
	private  BigDecimal  r0660_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0660_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0660_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0660_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0660_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0660_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0660_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0660_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0660_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0660_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0660_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0660_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0660_nat_amt;
	private  BigDecimal  r0660_non_res_nat_amt;
	private  BigDecimal  r0660_over_3_years_nat_amt;
	private  BigDecimal  r0660_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0660_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0660_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0660_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0660_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0660_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0660_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0660_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0660_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0660_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0660_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0660_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0660_product;
	private  BigDecimal  r0660_pro_bought_net_gain_loss;
	private  BigDecimal  r0660_pro_sold_net_gain_loss;
	private  BigDecimal  r0660_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0660_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0660_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0660_res_nat_amt;
	private  BigDecimal  r0660_sold_hedg_net_delta_pos;
	private  BigDecimal  r0660_sold_trad_net_delta_pos;
	private  BigDecimal  r0660_trad_nat_amt;
	private  BigDecimal  r0660_within_1_year_nat_amt;
	private  BigDecimal  r0670_1_to_3_years_nat_amt;
	private  BigDecimal  r0670_bought_hedg_net_delta_pos;
	private  BigDecimal  r0670_bought_trad_net_delta_pos;
	private  BigDecimal  r0670_gross_mkt_val;
	private  BigDecimal  r0670_hedg_nat_amt;
	private  BigDecimal  r0670_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0670_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0670_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0670_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0670_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0670_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0670_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0670_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0670_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0670_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0670_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0670_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0670_nat_amt;
	private  BigDecimal  r0670_non_res_nat_amt;
	private  BigDecimal  r0670_over_3_years_nat_amt;
	private  BigDecimal  r0670_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0670_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0670_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0670_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0670_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0670_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0670_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0670_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0670_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0670_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0670_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0670_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0670_product;
	private  BigDecimal  r0670_pro_bought_net_gain_loss;
	private  BigDecimal  r0670_pro_sold_net_gain_loss;
	private  BigDecimal  r0670_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0670_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0670_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0670_res_nat_amt;
	private  BigDecimal  r0670_sold_hedg_net_delta_pos;
	private  BigDecimal  r0670_sold_trad_net_delta_pos;
	private  BigDecimal  r0670_trad_nat_amt;
	private  BigDecimal  r0670_within_1_year_nat_amt;
	private  String  r0680_product;
	private  BigDecimal  r0690_1_to_3_years_nat_amt;
	private  BigDecimal  r0690_bought_hedg_net_delta_pos;
	private  BigDecimal  r0690_bought_trad_net_delta_pos;
	private  BigDecimal  r0690_gross_mkt_val;
	private  BigDecimal  r0690_hedg_nat_amt;
	private  BigDecimal  r0690_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0690_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0690_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0690_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0690_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0690_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0690_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0690_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0690_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0690_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0690_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0690_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0690_nat_amt;
	private  BigDecimal  r0690_non_res_nat_amt;
	private  BigDecimal  r0690_over_3_years_nat_amt;
	private  BigDecimal  r0690_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0690_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0690_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0690_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0690_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0690_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0690_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0690_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0690_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0690_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0690_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0690_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0690_product;
	private  BigDecimal  r0690_pro_bought_net_gain_loss;
	private  BigDecimal  r0690_pro_sold_net_gain_loss;
	private  BigDecimal  r0690_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0690_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0690_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0690_res_nat_amt;
	private  BigDecimal  r0690_sold_hedg_net_delta_pos;
	private  BigDecimal  r0690_sold_trad_net_delta_pos;
	private  BigDecimal  r0690_trad_nat_amt;
	private  BigDecimal  r0690_within_1_year_nat_amt;
	private  String  r0700_product;
	private  BigDecimal  r0710_1_to_3_years_nat_amt;
	private  BigDecimal  r0710_bought_hedg_net_delta_pos;
	private  BigDecimal  r0710_bought_trad_net_delta_pos;
	private  BigDecimal  r0710_gross_mkt_val;
	private  BigDecimal  r0710_hedg_nat_amt;
	private  BigDecimal  r0710_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0710_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0710_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0710_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0710_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0710_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0710_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0710_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0710_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0710_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0710_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0710_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0710_nat_amt;
	private  BigDecimal  r0710_non_res_nat_amt;
	private  BigDecimal  r0710_over_3_years_nat_amt;
	private  BigDecimal  r0710_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0710_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0710_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0710_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0710_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0710_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0710_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0710_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0710_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0710_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0710_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0710_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0710_product;
	private  BigDecimal  r0710_pro_bought_net_gain_loss;
	private  BigDecimal  r0710_pro_sold_net_gain_loss;
	private  BigDecimal  r0710_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0710_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0710_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0710_res_nat_amt;
	private  BigDecimal  r0710_sold_hedg_net_delta_pos;
	private  BigDecimal  r0710_sold_trad_net_delta_pos;
	private  BigDecimal  r0710_trad_nat_amt;
	private  BigDecimal  r0710_within_1_year_nat_amt;
	private  String  r0720_product;
	private  BigDecimal  r0730_1_to_3_years_nat_amt;
	private  BigDecimal  r0730_bought_hedg_net_delta_pos;
	private  BigDecimal  r0730_bought_trad_net_delta_pos;
	private  BigDecimal  r0730_gross_mkt_val;
	private  BigDecimal  r0730_hedg_nat_amt;
	private  BigDecimal  r0730_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0730_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0730_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0730_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0730_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0730_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0730_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0730_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0730_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0730_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0730_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0730_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0730_nat_amt;
	private  BigDecimal  r0730_non_res_nat_amt;
	private  BigDecimal  r0730_over_3_years_nat_amt;
	private  BigDecimal  r0730_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0730_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0730_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0730_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0730_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0730_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0730_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0730_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0730_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0730_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0730_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0730_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0730_product;
	private  BigDecimal  r0730_pro_bought_net_gain_loss;
	private  BigDecimal  r0730_pro_sold_net_gain_loss;
	private  BigDecimal  r0730_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0730_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0730_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0730_res_nat_amt;
	private  BigDecimal  r0730_sold_hedg_net_delta_pos;
	private  BigDecimal  r0730_sold_trad_net_delta_pos;
	private  BigDecimal  r0730_trad_nat_amt;
	private  BigDecimal  r0730_within_1_year_nat_amt;
	private  String  r0740_product;
	private  String  r0750_product;
	private  BigDecimal  r0760_1_to_3_years_nat_amt;
	private  BigDecimal  r0760_bought_hedg_net_delta_pos;
	private  BigDecimal  r0760_bought_trad_net_delta_pos;
	private  BigDecimal  r0760_gross_mkt_val;
	private  BigDecimal  r0760_hedg_nat_amt;
	private  BigDecimal  r0760_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0760_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0760_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0760_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0760_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0760_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0760_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0760_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0760_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0760_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0760_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0760_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0760_nat_amt;
	private  BigDecimal  r0760_non_res_nat_amt;
	private  BigDecimal  r0760_over_3_years_nat_amt;
	private  BigDecimal  r0760_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0760_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0760_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0760_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0760_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0760_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0760_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0760_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0760_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0760_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0760_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0760_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0760_product;
	private  BigDecimal  r0760_pro_bought_net_gain_loss;
	private  BigDecimal  r0760_pro_sold_net_gain_loss;
	private  BigDecimal  r0760_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0760_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0760_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0760_res_nat_amt;
	private  BigDecimal  r0760_sold_hedg_net_delta_pos;
	private  BigDecimal  r0760_sold_trad_net_delta_pos;
	private  BigDecimal  r0760_trad_nat_amt;
	private  BigDecimal  r0760_within_1_year_nat_amt;
	private  BigDecimal  r0770_1_to_3_years_nat_amt;
	private  BigDecimal  r0770_bought_hedg_net_delta_pos;
	private  BigDecimal  r0770_bought_trad_net_delta_pos;
	private  BigDecimal  r0770_gross_mkt_val;
	private  BigDecimal  r0770_hedg_nat_amt;
	private  BigDecimal  r0770_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0770_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0770_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0770_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0770_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0770_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0770_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0770_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0770_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0770_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0770_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0770_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0770_nat_amt;
	private  BigDecimal  r0770_non_res_nat_amt;
	private  BigDecimal  r0770_over_3_years_nat_amt;
	private  BigDecimal  r0770_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0770_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0770_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0770_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0770_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0770_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0770_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0770_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0770_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0770_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0770_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0770_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0770_product;
	private  BigDecimal  r0770_pro_bought_net_gain_loss;
	private  BigDecimal  r0770_pro_sold_net_gain_loss;
	private  BigDecimal  r0770_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0770_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0770_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0770_res_nat_amt;
	private  BigDecimal  r0770_sold_hedg_net_delta_pos;
	private  BigDecimal  r0770_sold_trad_net_delta_pos;
	private  BigDecimal  r0770_trad_nat_amt;
	private  BigDecimal  r0770_within_1_year_nat_amt;
	private  BigDecimal  r0780_1_to_3_years_nat_amt;
	private  BigDecimal  r0780_bought_hedg_net_delta_pos;
	private  BigDecimal  r0780_bought_trad_net_delta_pos;
	private  BigDecimal  r0780_gross_mkt_val;
	private  BigDecimal  r0780_hedg_nat_amt;
	private  BigDecimal  r0780_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0780_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0780_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0780_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0780_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0780_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0780_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0780_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0780_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0780_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0780_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0780_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0780_nat_amt;
	private  BigDecimal  r0780_non_res_nat_amt;
	private  BigDecimal  r0780_over_3_years_nat_amt;
	private  BigDecimal  r0780_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0780_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0780_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0780_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0780_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0780_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0780_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0780_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0780_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0780_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0780_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0780_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0780_product;
	private  BigDecimal  r0780_pro_bought_net_gain_loss;
	private  BigDecimal  r0780_pro_sold_net_gain_loss;
	private  BigDecimal  r0780_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0780_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0780_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0780_res_nat_amt;
	private  BigDecimal  r0780_sold_hedg_net_delta_pos;
	private  BigDecimal  r0780_sold_trad_net_delta_pos;
	private  BigDecimal  r0780_trad_nat_amt;
	private  BigDecimal  r0780_within_1_year_nat_amt;
	private  BigDecimal  r0790_1_to_3_years_nat_amt;
	private  BigDecimal  r0790_bought_hedg_net_delta_pos;
	private  BigDecimal  r0790_bought_trad_net_delta_pos;
	private  BigDecimal  r0790_gross_mkt_val;
	private  BigDecimal  r0790_hedg_nat_amt;
	private  BigDecimal  r0790_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0790_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0790_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0790_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0790_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0790_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0790_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0790_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0790_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0790_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0790_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0790_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0790_nat_amt;
	private  BigDecimal  r0790_non_res_nat_amt;
	private  BigDecimal  r0790_over_3_years_nat_amt;
	private  BigDecimal  r0790_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0790_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0790_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0790_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0790_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0790_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0790_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0790_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0790_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0790_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0790_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0790_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0790_product;
	private  BigDecimal  r0790_pro_bought_net_gain_loss;
	private  BigDecimal  r0790_pro_sold_net_gain_loss;
	private  BigDecimal  r0790_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0790_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0790_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0790_res_nat_amt;
	private  BigDecimal  r0790_sold_hedg_net_delta_pos;
	private  BigDecimal  r0790_sold_trad_net_delta_pos;
	private  BigDecimal  r0790_trad_nat_amt;
	private  BigDecimal  r0790_within_1_year_nat_amt;
	private  BigDecimal  r0800_1_to_3_years_nat_amt;
	private  BigDecimal  r0800_bought_hedg_net_delta_pos;
	private  BigDecimal  r0800_bought_trad_net_delta_pos;
	private  BigDecimal  r0800_gross_mkt_val;
	private  BigDecimal  r0800_hedg_nat_amt;
	private  BigDecimal  r0800_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0800_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0800_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0800_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0800_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0800_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0800_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0800_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0800_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0800_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0800_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0800_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0800_nat_amt;
	private  BigDecimal  r0800_non_res_nat_amt;
	private  BigDecimal  r0800_over_3_years_nat_amt;
	private  BigDecimal  r0800_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0800_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0800_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0800_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0800_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0800_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0800_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0800_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0800_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0800_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0800_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0800_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0800_product;
	private  BigDecimal  r0800_pro_bought_net_gain_loss;
	private  BigDecimal  r0800_pro_sold_net_gain_loss;
	private  BigDecimal  r0800_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0800_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0800_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0800_res_nat_amt;
	private  BigDecimal  r0800_sold_hedg_net_delta_pos;
	private  BigDecimal  r0800_sold_trad_net_delta_pos;
	private  BigDecimal  r0800_trad_nat_amt;
	private  BigDecimal  r0800_within_1_year_nat_amt;
	private  BigDecimal  r0810_1_to_3_years_nat_amt;
	private  BigDecimal  r0810_bought_hedg_net_delta_pos;
	private  BigDecimal  r0810_bought_trad_net_delta_pos;
	private  BigDecimal  r0810_gross_mkt_val;
	private  BigDecimal  r0810_hedg_nat_amt;
	private  BigDecimal  r0810_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0810_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0810_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0810_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0810_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0810_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0810_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0810_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0810_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0810_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0810_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0810_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0810_nat_amt;
	private  BigDecimal  r0810_non_res_nat_amt;
	private  BigDecimal  r0810_over_3_years_nat_amt;
	private  BigDecimal  r0810_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0810_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0810_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0810_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0810_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0810_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0810_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0810_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0810_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0810_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0810_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0810_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0810_product;
	private  BigDecimal  r0810_pro_bought_net_gain_loss;
	private  BigDecimal  r0810_pro_sold_net_gain_loss;
	private  BigDecimal  r0810_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0810_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0810_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0810_res_nat_amt;
	private  BigDecimal  r0810_sold_hedg_net_delta_pos;
	private  BigDecimal  r0810_sold_trad_net_delta_pos;
	private  BigDecimal  r0810_trad_nat_amt;
	private  BigDecimal  r0810_within_1_year_nat_amt;

	private  String  report_code;
	@Id    
	private  Date  report_date;
	private  String  report_desc;
	private  String  report_frequency;
	private  String  report_version;
	    
	


	public BigDecimal getR0520_1_to_3_years_nat_amt() {
		return r0520_1_to_3_years_nat_amt;
	}




	public void setR0520_1_to_3_years_nat_amt(BigDecimal r0520_1_to_3_years_nat_amt) {
		this.r0520_1_to_3_years_nat_amt = r0520_1_to_3_years_nat_amt;
	}




	public BigDecimal getR0520_bought_hedg_net_delta_pos() {
		return r0520_bought_hedg_net_delta_pos;
	}




	public void setR0520_bought_hedg_net_delta_pos(BigDecimal r0520_bought_hedg_net_delta_pos) {
		this.r0520_bought_hedg_net_delta_pos = r0520_bought_hedg_net_delta_pos;
	}




	public BigDecimal getR0520_bought_trad_net_delta_pos() {
		return r0520_bought_trad_net_delta_pos;
	}




	public void setR0520_bought_trad_net_delta_pos(BigDecimal r0520_bought_trad_net_delta_pos) {
		this.r0520_bought_trad_net_delta_pos = r0520_bought_trad_net_delta_pos;
	}




	public BigDecimal getR0520_gross_mkt_val() {
		return r0520_gross_mkt_val;
	}




	public void setR0520_gross_mkt_val(BigDecimal r0520_gross_mkt_val) {
		this.r0520_gross_mkt_val = r0520_gross_mkt_val;
	}




	public BigDecimal getR0520_hedg_nat_amt() {
		return r0520_hedg_nat_amt;
	}




	public void setR0520_hedg_nat_amt(BigDecimal r0520_hedg_nat_amt) {
		this.r0520_hedg_nat_amt = r0520_hedg_nat_amt;
	}




	public BigDecimal getR0520_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0520_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0520_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0520_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0520_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0520_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0520_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0520_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0520_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0520_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0520_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0520_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0520_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0520_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0520_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0520_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0520_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0520_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0520_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0520_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0520_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0520_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0520_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0520_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0520_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0520_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0520_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0520_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0520_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0520_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0520_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0520_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0520_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0520_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0520_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0520_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0520_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0520_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0520_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0520_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0520_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0520_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0520_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0520_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0520_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0520_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0520_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0520_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0520_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0520_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0520_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0520_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0520_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0520_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0520_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0520_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0520_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0520_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0520_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0520_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0520_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0520_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0520_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0520_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0520_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0520_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0520_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0520_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0520_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0520_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0520_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0520_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public BigDecimal getR0520_nat_amt() {
		return r0520_nat_amt;
	}




	public void setR0520_nat_amt(BigDecimal r0520_nat_amt) {
		this.r0520_nat_amt = r0520_nat_amt;
	}




	public BigDecimal getR0520_non_res_nat_amt() {
		return r0520_non_res_nat_amt;
	}




	public void setR0520_non_res_nat_amt(BigDecimal r0520_non_res_nat_amt) {
		this.r0520_non_res_nat_amt = r0520_non_res_nat_amt;
	}




	public BigDecimal getR0520_over_3_years_nat_amt() {
		return r0520_over_3_years_nat_amt;
	}




	public void setR0520_over_3_years_nat_amt(BigDecimal r0520_over_3_years_nat_amt) {
		this.r0520_over_3_years_nat_amt = r0520_over_3_years_nat_amt;
	}




	public BigDecimal getR0520_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0520_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0520_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0520_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0520_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0520_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0520_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0520_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0520_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0520_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0520_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0520_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0520_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0520_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0520_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0520_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0520_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0520_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0520_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0520_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0520_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0520_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0520_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0520_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0520_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0520_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0520_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0520_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0520_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0520_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0520_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0520_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0520_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0520_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0520_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0520_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0520_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0520_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0520_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0520_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0520_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0520_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0520_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0520_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0520_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0520_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0520_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0520_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0520_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0520_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0520_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0520_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0520_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0520_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0520_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0520_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0520_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0520_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0520_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0520_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0520_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0520_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0520_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0520_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0520_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0520_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0520_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0520_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0520_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0520_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0520_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0520_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public String getR0520_product() {
		return r0520_product;
	}




	public void setR0520_product(String r0520_product) {
		this.r0520_product = r0520_product;
	}




	public BigDecimal getR0520_pro_bought_net_gain_loss() {
		return r0520_pro_bought_net_gain_loss;
	}




	public void setR0520_pro_bought_net_gain_loss(BigDecimal r0520_pro_bought_net_gain_loss) {
		this.r0520_pro_bought_net_gain_loss = r0520_pro_bought_net_gain_loss;
	}




	public BigDecimal getR0520_pro_sold_net_gain_loss() {
		return r0520_pro_sold_net_gain_loss;
	}




	public void setR0520_pro_sold_net_gain_loss(BigDecimal r0520_pro_sold_net_gain_loss) {
		this.r0520_pro_sold_net_gain_loss = r0520_pro_sold_net_gain_loss;
	}




	public BigDecimal getR0520_res_1_to_3_years_mkt_val() {
		return r0520_res_1_to_3_years_mkt_val;
	}




	public void setR0520_res_1_to_3_years_mkt_val(BigDecimal r0520_res_1_to_3_years_mkt_val) {
		this.r0520_res_1_to_3_years_mkt_val = r0520_res_1_to_3_years_mkt_val;
	}




	public BigDecimal getR0520_res_lessthan_1_year_mkt_val() {
		return r0520_res_lessthan_1_year_mkt_val;
	}




	public void setR0520_res_lessthan_1_year_mkt_val(BigDecimal r0520_res_lessthan_1_year_mkt_val) {
		this.r0520_res_lessthan_1_year_mkt_val = r0520_res_lessthan_1_year_mkt_val;
	}




	public BigDecimal getR0520_res_morethan_3_years_mkt_val() {
		return r0520_res_morethan_3_years_mkt_val;
	}




	public void setR0520_res_morethan_3_years_mkt_val(BigDecimal r0520_res_morethan_3_years_mkt_val) {
		this.r0520_res_morethan_3_years_mkt_val = r0520_res_morethan_3_years_mkt_val;
	}




	public BigDecimal getR0520_res_nat_amt() {
		return r0520_res_nat_amt;
	}




	public void setR0520_res_nat_amt(BigDecimal r0520_res_nat_amt) {
		this.r0520_res_nat_amt = r0520_res_nat_amt;
	}




	public BigDecimal getR0520_sold_hedg_net_delta_pos() {
		return r0520_sold_hedg_net_delta_pos;
	}




	public void setR0520_sold_hedg_net_delta_pos(BigDecimal r0520_sold_hedg_net_delta_pos) {
		this.r0520_sold_hedg_net_delta_pos = r0520_sold_hedg_net_delta_pos;
	}




	public BigDecimal getR0520_sold_trad_net_delta_pos() {
		return r0520_sold_trad_net_delta_pos;
	}




	public void setR0520_sold_trad_net_delta_pos(BigDecimal r0520_sold_trad_net_delta_pos) {
		this.r0520_sold_trad_net_delta_pos = r0520_sold_trad_net_delta_pos;
	}




	public BigDecimal getR0520_trad_nat_amt() {
		return r0520_trad_nat_amt;
	}




	public void setR0520_trad_nat_amt(BigDecimal r0520_trad_nat_amt) {
		this.r0520_trad_nat_amt = r0520_trad_nat_amt;
	}




	public BigDecimal getR0520_within_1_year_nat_amt() {
		return r0520_within_1_year_nat_amt;
	}




	public void setR0520_within_1_year_nat_amt(BigDecimal r0520_within_1_year_nat_amt) {
		this.r0520_within_1_year_nat_amt = r0520_within_1_year_nat_amt;
	}




	public BigDecimal getR0530_1_to_3_years_nat_amt() {
		return r0530_1_to_3_years_nat_amt;
	}




	public void setR0530_1_to_3_years_nat_amt(BigDecimal r0530_1_to_3_years_nat_amt) {
		this.r0530_1_to_3_years_nat_amt = r0530_1_to_3_years_nat_amt;
	}




	public BigDecimal getR0530_bought_hedg_net_delta_pos() {
		return r0530_bought_hedg_net_delta_pos;
	}




	public void setR0530_bought_hedg_net_delta_pos(BigDecimal r0530_bought_hedg_net_delta_pos) {
		this.r0530_bought_hedg_net_delta_pos = r0530_bought_hedg_net_delta_pos;
	}




	public BigDecimal getR0530_bought_trad_net_delta_pos() {
		return r0530_bought_trad_net_delta_pos;
	}




	public void setR0530_bought_trad_net_delta_pos(BigDecimal r0530_bought_trad_net_delta_pos) {
		this.r0530_bought_trad_net_delta_pos = r0530_bought_trad_net_delta_pos;
	}




	public BigDecimal getR0530_gross_mkt_val() {
		return r0530_gross_mkt_val;
	}




	public void setR0530_gross_mkt_val(BigDecimal r0530_gross_mkt_val) {
		this.r0530_gross_mkt_val = r0530_gross_mkt_val;
	}




	public BigDecimal getR0530_hedg_nat_amt() {
		return r0530_hedg_nat_amt;
	}




	public void setR0530_hedg_nat_amt(BigDecimal r0530_hedg_nat_amt) {
		this.r0530_hedg_nat_amt = r0530_hedg_nat_amt;
	}




	public BigDecimal getR0530_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0530_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0530_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0530_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0530_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0530_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0530_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0530_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0530_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0530_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0530_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0530_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0530_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0530_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0530_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0530_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0530_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0530_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0530_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0530_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0530_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0530_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0530_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0530_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0530_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0530_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0530_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0530_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0530_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0530_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0530_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0530_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0530_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0530_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0530_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0530_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0530_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0530_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0530_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0530_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0530_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0530_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0530_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0530_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0530_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0530_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0530_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0530_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0530_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0530_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0530_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0530_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0530_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0530_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0530_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0530_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0530_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0530_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0530_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0530_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0530_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0530_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0530_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0530_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0530_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0530_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0530_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0530_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0530_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0530_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0530_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0530_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public BigDecimal getR0530_nat_amt() {
		return r0530_nat_amt;
	}




	public void setR0530_nat_amt(BigDecimal r0530_nat_amt) {
		this.r0530_nat_amt = r0530_nat_amt;
	}




	public BigDecimal getR0530_non_res_nat_amt() {
		return r0530_non_res_nat_amt;
	}




	public void setR0530_non_res_nat_amt(BigDecimal r0530_non_res_nat_amt) {
		this.r0530_non_res_nat_amt = r0530_non_res_nat_amt;
	}




	public BigDecimal getR0530_over_3_years_nat_amt() {
		return r0530_over_3_years_nat_amt;
	}




	public void setR0530_over_3_years_nat_amt(BigDecimal r0530_over_3_years_nat_amt) {
		this.r0530_over_3_years_nat_amt = r0530_over_3_years_nat_amt;
	}




	public BigDecimal getR0530_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0530_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0530_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0530_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0530_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0530_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0530_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0530_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0530_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0530_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0530_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0530_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0530_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0530_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0530_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0530_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0530_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0530_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0530_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0530_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0530_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0530_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0530_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0530_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0530_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0530_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0530_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0530_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0530_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0530_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0530_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0530_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0530_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0530_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0530_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0530_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0530_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0530_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0530_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0530_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0530_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0530_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0530_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0530_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0530_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0530_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0530_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0530_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0530_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0530_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0530_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0530_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0530_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0530_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0530_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0530_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0530_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0530_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0530_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0530_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0530_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0530_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0530_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0530_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0530_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0530_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0530_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0530_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0530_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0530_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0530_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0530_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public String getR0530_product() {
		return r0530_product;
	}




	public void setR0530_product(String r0530_product) {
		this.r0530_product = r0530_product;
	}




	public BigDecimal getR0530_pro_bought_net_gain_loss() {
		return r0530_pro_bought_net_gain_loss;
	}




	public void setR0530_pro_bought_net_gain_loss(BigDecimal r0530_pro_bought_net_gain_loss) {
		this.r0530_pro_bought_net_gain_loss = r0530_pro_bought_net_gain_loss;
	}




	public BigDecimal getR0530_pro_sold_net_gain_loss() {
		return r0530_pro_sold_net_gain_loss;
	}




	public void setR0530_pro_sold_net_gain_loss(BigDecimal r0530_pro_sold_net_gain_loss) {
		this.r0530_pro_sold_net_gain_loss = r0530_pro_sold_net_gain_loss;
	}




	public BigDecimal getR0530_res_1_to_3_years_mkt_val() {
		return r0530_res_1_to_3_years_mkt_val;
	}




	public void setR0530_res_1_to_3_years_mkt_val(BigDecimal r0530_res_1_to_3_years_mkt_val) {
		this.r0530_res_1_to_3_years_mkt_val = r0530_res_1_to_3_years_mkt_val;
	}




	public BigDecimal getR0530_res_lessthan_1_year_mkt_val() {
		return r0530_res_lessthan_1_year_mkt_val;
	}




	public void setR0530_res_lessthan_1_year_mkt_val(BigDecimal r0530_res_lessthan_1_year_mkt_val) {
		this.r0530_res_lessthan_1_year_mkt_val = r0530_res_lessthan_1_year_mkt_val;
	}




	public BigDecimal getR0530_res_morethan_3_years_mkt_val() {
		return r0530_res_morethan_3_years_mkt_val;
	}




	public void setR0530_res_morethan_3_years_mkt_val(BigDecimal r0530_res_morethan_3_years_mkt_val) {
		this.r0530_res_morethan_3_years_mkt_val = r0530_res_morethan_3_years_mkt_val;
	}




	public BigDecimal getR0530_res_nat_amt() {
		return r0530_res_nat_amt;
	}




	public void setR0530_res_nat_amt(BigDecimal r0530_res_nat_amt) {
		this.r0530_res_nat_amt = r0530_res_nat_amt;
	}




	public BigDecimal getR0530_sold_hedg_net_delta_pos() {
		return r0530_sold_hedg_net_delta_pos;
	}




	public void setR0530_sold_hedg_net_delta_pos(BigDecimal r0530_sold_hedg_net_delta_pos) {
		this.r0530_sold_hedg_net_delta_pos = r0530_sold_hedg_net_delta_pos;
	}




	public BigDecimal getR0530_sold_trad_net_delta_pos() {
		return r0530_sold_trad_net_delta_pos;
	}




	public void setR0530_sold_trad_net_delta_pos(BigDecimal r0530_sold_trad_net_delta_pos) {
		this.r0530_sold_trad_net_delta_pos = r0530_sold_trad_net_delta_pos;
	}




	public BigDecimal getR0530_trad_nat_amt() {
		return r0530_trad_nat_amt;
	}




	public void setR0530_trad_nat_amt(BigDecimal r0530_trad_nat_amt) {
		this.r0530_trad_nat_amt = r0530_trad_nat_amt;
	}




	public BigDecimal getR0530_within_1_year_nat_amt() {
		return r0530_within_1_year_nat_amt;
	}




	public void setR0530_within_1_year_nat_amt(BigDecimal r0530_within_1_year_nat_amt) {
		this.r0530_within_1_year_nat_amt = r0530_within_1_year_nat_amt;
	}




	public BigDecimal getR0540_1_to_3_years_nat_amt() {
		return r0540_1_to_3_years_nat_amt;
	}




	public void setR0540_1_to_3_years_nat_amt(BigDecimal r0540_1_to_3_years_nat_amt) {
		this.r0540_1_to_3_years_nat_amt = r0540_1_to_3_years_nat_amt;
	}




	public BigDecimal getR0540_bought_hedg_net_delta_pos() {
		return r0540_bought_hedg_net_delta_pos;
	}




	public void setR0540_bought_hedg_net_delta_pos(BigDecimal r0540_bought_hedg_net_delta_pos) {
		this.r0540_bought_hedg_net_delta_pos = r0540_bought_hedg_net_delta_pos;
	}




	public BigDecimal getR0540_bought_trad_net_delta_pos() {
		return r0540_bought_trad_net_delta_pos;
	}




	public void setR0540_bought_trad_net_delta_pos(BigDecimal r0540_bought_trad_net_delta_pos) {
		this.r0540_bought_trad_net_delta_pos = r0540_bought_trad_net_delta_pos;
	}




	public BigDecimal getR0540_gross_mkt_val() {
		return r0540_gross_mkt_val;
	}




	public void setR0540_gross_mkt_val(BigDecimal r0540_gross_mkt_val) {
		this.r0540_gross_mkt_val = r0540_gross_mkt_val;
	}




	public BigDecimal getR0540_hedg_nat_amt() {
		return r0540_hedg_nat_amt;
	}




	public void setR0540_hedg_nat_amt(BigDecimal r0540_hedg_nat_amt) {
		this.r0540_hedg_nat_amt = r0540_hedg_nat_amt;
	}




	public BigDecimal getR0540_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0540_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0540_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0540_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0540_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0540_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0540_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0540_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0540_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0540_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0540_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0540_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0540_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0540_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0540_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0540_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0540_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0540_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0540_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0540_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0540_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0540_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0540_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0540_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0540_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0540_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0540_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0540_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0540_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0540_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0540_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0540_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0540_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0540_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0540_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0540_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0540_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0540_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0540_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0540_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0540_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0540_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0540_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0540_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0540_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0540_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0540_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0540_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0540_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0540_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0540_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0540_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0540_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0540_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0540_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0540_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0540_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0540_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0540_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0540_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0540_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0540_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0540_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0540_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0540_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0540_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0540_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0540_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0540_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0540_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0540_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0540_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public BigDecimal getR0540_nat_amt() {
		return r0540_nat_amt;
	}




	public void setR0540_nat_amt(BigDecimal r0540_nat_amt) {
		this.r0540_nat_amt = r0540_nat_amt;
	}




	public BigDecimal getR0540_non_res_nat_amt() {
		return r0540_non_res_nat_amt;
	}




	public void setR0540_non_res_nat_amt(BigDecimal r0540_non_res_nat_amt) {
		this.r0540_non_res_nat_amt = r0540_non_res_nat_amt;
	}




	public BigDecimal getR0540_over_3_years_nat_amt() {
		return r0540_over_3_years_nat_amt;
	}




	public void setR0540_over_3_years_nat_amt(BigDecimal r0540_over_3_years_nat_amt) {
		this.r0540_over_3_years_nat_amt = r0540_over_3_years_nat_amt;
	}




	public BigDecimal getR0540_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0540_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0540_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0540_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0540_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0540_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0540_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0540_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0540_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0540_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0540_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0540_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0540_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0540_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0540_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0540_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0540_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0540_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0540_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0540_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0540_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0540_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0540_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0540_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0540_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0540_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0540_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0540_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0540_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0540_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0540_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0540_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0540_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0540_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0540_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0540_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0540_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0540_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0540_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0540_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0540_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0540_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0540_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0540_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0540_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0540_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0540_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0540_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0540_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0540_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0540_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0540_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0540_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0540_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0540_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0540_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0540_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0540_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0540_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0540_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0540_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0540_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0540_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0540_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0540_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0540_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0540_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0540_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0540_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0540_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0540_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0540_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public String getR0540_product() {
		return r0540_product;
	}




	public void setR0540_product(String r0540_product) {
		this.r0540_product = r0540_product;
	}




	public BigDecimal getR0540_pro_bought_net_gain_loss() {
		return r0540_pro_bought_net_gain_loss;
	}




	public void setR0540_pro_bought_net_gain_loss(BigDecimal r0540_pro_bought_net_gain_loss) {
		this.r0540_pro_bought_net_gain_loss = r0540_pro_bought_net_gain_loss;
	}




	public BigDecimal getR0540_pro_sold_net_gain_loss() {
		return r0540_pro_sold_net_gain_loss;
	}




	public void setR0540_pro_sold_net_gain_loss(BigDecimal r0540_pro_sold_net_gain_loss) {
		this.r0540_pro_sold_net_gain_loss = r0540_pro_sold_net_gain_loss;
	}




	public BigDecimal getR0540_res_1_to_3_years_mkt_val() {
		return r0540_res_1_to_3_years_mkt_val;
	}




	public void setR0540_res_1_to_3_years_mkt_val(BigDecimal r0540_res_1_to_3_years_mkt_val) {
		this.r0540_res_1_to_3_years_mkt_val = r0540_res_1_to_3_years_mkt_val;
	}




	public BigDecimal getR0540_res_lessthan_1_year_mkt_val() {
		return r0540_res_lessthan_1_year_mkt_val;
	}




	public void setR0540_res_lessthan_1_year_mkt_val(BigDecimal r0540_res_lessthan_1_year_mkt_val) {
		this.r0540_res_lessthan_1_year_mkt_val = r0540_res_lessthan_1_year_mkt_val;
	}




	public BigDecimal getR0540_res_morethan_3_years_mkt_val() {
		return r0540_res_morethan_3_years_mkt_val;
	}




	public void setR0540_res_morethan_3_years_mkt_val(BigDecimal r0540_res_morethan_3_years_mkt_val) {
		this.r0540_res_morethan_3_years_mkt_val = r0540_res_morethan_3_years_mkt_val;
	}




	public BigDecimal getR0540_res_nat_amt() {
		return r0540_res_nat_amt;
	}




	public void setR0540_res_nat_amt(BigDecimal r0540_res_nat_amt) {
		this.r0540_res_nat_amt = r0540_res_nat_amt;
	}




	public BigDecimal getR0540_sold_hedg_net_delta_pos() {
		return r0540_sold_hedg_net_delta_pos;
	}




	public void setR0540_sold_hedg_net_delta_pos(BigDecimal r0540_sold_hedg_net_delta_pos) {
		this.r0540_sold_hedg_net_delta_pos = r0540_sold_hedg_net_delta_pos;
	}




	public BigDecimal getR0540_sold_trad_net_delta_pos() {
		return r0540_sold_trad_net_delta_pos;
	}




	public void setR0540_sold_trad_net_delta_pos(BigDecimal r0540_sold_trad_net_delta_pos) {
		this.r0540_sold_trad_net_delta_pos = r0540_sold_trad_net_delta_pos;
	}




	public BigDecimal getR0540_trad_nat_amt() {
		return r0540_trad_nat_amt;
	}




	public void setR0540_trad_nat_amt(BigDecimal r0540_trad_nat_amt) {
		this.r0540_trad_nat_amt = r0540_trad_nat_amt;
	}




	public BigDecimal getR0540_within_1_year_nat_amt() {
		return r0540_within_1_year_nat_amt;
	}




	public void setR0540_within_1_year_nat_amt(BigDecimal r0540_within_1_year_nat_amt) {
		this.r0540_within_1_year_nat_amt = r0540_within_1_year_nat_amt;
	}




	public String getR0550_product() {
		return r0550_product;
	}




	public void setR0550_product(String r0550_product) {
		this.r0550_product = r0550_product;
	}




	public BigDecimal getR0560_1_to_3_years_nat_amt() {
		return r0560_1_to_3_years_nat_amt;
	}




	public void setR0560_1_to_3_years_nat_amt(BigDecimal r0560_1_to_3_years_nat_amt) {
		this.r0560_1_to_3_years_nat_amt = r0560_1_to_3_years_nat_amt;
	}




	public BigDecimal getR0560_bought_hedg_net_delta_pos() {
		return r0560_bought_hedg_net_delta_pos;
	}




	public void setR0560_bought_hedg_net_delta_pos(BigDecimal r0560_bought_hedg_net_delta_pos) {
		this.r0560_bought_hedg_net_delta_pos = r0560_bought_hedg_net_delta_pos;
	}




	public BigDecimal getR0560_bought_trad_net_delta_pos() {
		return r0560_bought_trad_net_delta_pos;
	}




	public void setR0560_bought_trad_net_delta_pos(BigDecimal r0560_bought_trad_net_delta_pos) {
		this.r0560_bought_trad_net_delta_pos = r0560_bought_trad_net_delta_pos;
	}




	public BigDecimal getR0560_gross_mkt_val() {
		return r0560_gross_mkt_val;
	}




	public void setR0560_gross_mkt_val(BigDecimal r0560_gross_mkt_val) {
		this.r0560_gross_mkt_val = r0560_gross_mkt_val;
	}




	public BigDecimal getR0560_hedg_nat_amt() {
		return r0560_hedg_nat_amt;
	}




	public void setR0560_hedg_nat_amt(BigDecimal r0560_hedg_nat_amt) {
		this.r0560_hedg_nat_amt = r0560_hedg_nat_amt;
	}




	public BigDecimal getR0560_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0560_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0560_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0560_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0560_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0560_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0560_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0560_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0560_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0560_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0560_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0560_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0560_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0560_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0560_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0560_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0560_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0560_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0560_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0560_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0560_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0560_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0560_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0560_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0560_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0560_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0560_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0560_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0560_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0560_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0560_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0560_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0560_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0560_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0560_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0560_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0560_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0560_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0560_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0560_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0560_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0560_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0560_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0560_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0560_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0560_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0560_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0560_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0560_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0560_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0560_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0560_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0560_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0560_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0560_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0560_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0560_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0560_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0560_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0560_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0560_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0560_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0560_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0560_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0560_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0560_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0560_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0560_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0560_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0560_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0560_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0560_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public BigDecimal getR0560_nat_amt() {
		return r0560_nat_amt;
	}




	public void setR0560_nat_amt(BigDecimal r0560_nat_amt) {
		this.r0560_nat_amt = r0560_nat_amt;
	}




	public BigDecimal getR0560_non_res_nat_amt() {
		return r0560_non_res_nat_amt;
	}




	public void setR0560_non_res_nat_amt(BigDecimal r0560_non_res_nat_amt) {
		this.r0560_non_res_nat_amt = r0560_non_res_nat_amt;
	}




	public BigDecimal getR0560_over_3_years_nat_amt() {
		return r0560_over_3_years_nat_amt;
	}




	public void setR0560_over_3_years_nat_amt(BigDecimal r0560_over_3_years_nat_amt) {
		this.r0560_over_3_years_nat_amt = r0560_over_3_years_nat_amt;
	}




	public BigDecimal getR0560_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0560_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0560_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0560_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0560_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0560_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0560_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0560_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0560_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0560_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0560_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0560_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0560_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0560_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0560_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0560_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0560_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0560_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0560_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0560_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0560_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0560_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0560_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0560_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0560_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0560_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0560_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0560_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0560_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0560_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0560_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0560_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0560_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0560_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0560_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0560_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0560_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0560_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0560_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0560_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0560_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0560_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0560_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0560_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0560_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0560_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0560_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0560_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0560_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0560_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0560_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0560_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0560_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0560_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0560_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0560_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0560_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0560_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0560_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0560_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0560_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0560_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0560_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0560_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0560_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0560_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0560_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0560_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0560_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0560_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0560_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0560_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public String getR0560_product() {
		return r0560_product;
	}




	public void setR0560_product(String r0560_product) {
		this.r0560_product = r0560_product;
	}




	public BigDecimal getR0560_pro_bought_net_gain_loss() {
		return r0560_pro_bought_net_gain_loss;
	}




	public void setR0560_pro_bought_net_gain_loss(BigDecimal r0560_pro_bought_net_gain_loss) {
		this.r0560_pro_bought_net_gain_loss = r0560_pro_bought_net_gain_loss;
	}




	public BigDecimal getR0560_pro_sold_net_gain_loss() {
		return r0560_pro_sold_net_gain_loss;
	}




	public void setR0560_pro_sold_net_gain_loss(BigDecimal r0560_pro_sold_net_gain_loss) {
		this.r0560_pro_sold_net_gain_loss = r0560_pro_sold_net_gain_loss;
	}




	public BigDecimal getR0560_res_1_to_3_years_mkt_val() {
		return r0560_res_1_to_3_years_mkt_val;
	}




	public void setR0560_res_1_to_3_years_mkt_val(BigDecimal r0560_res_1_to_3_years_mkt_val) {
		this.r0560_res_1_to_3_years_mkt_val = r0560_res_1_to_3_years_mkt_val;
	}




	public BigDecimal getR0560_res_lessthan_1_year_mkt_val() {
		return r0560_res_lessthan_1_year_mkt_val;
	}




	public void setR0560_res_lessthan_1_year_mkt_val(BigDecimal r0560_res_lessthan_1_year_mkt_val) {
		this.r0560_res_lessthan_1_year_mkt_val = r0560_res_lessthan_1_year_mkt_val;
	}




	public BigDecimal getR0560_res_morethan_3_years_mkt_val() {
		return r0560_res_morethan_3_years_mkt_val;
	}




	public void setR0560_res_morethan_3_years_mkt_val(BigDecimal r0560_res_morethan_3_years_mkt_val) {
		this.r0560_res_morethan_3_years_mkt_val = r0560_res_morethan_3_years_mkt_val;
	}




	public BigDecimal getR0560_res_nat_amt() {
		return r0560_res_nat_amt;
	}




	public void setR0560_res_nat_amt(BigDecimal r0560_res_nat_amt) {
		this.r0560_res_nat_amt = r0560_res_nat_amt;
	}




	public BigDecimal getR0560_sold_hedg_net_delta_pos() {
		return r0560_sold_hedg_net_delta_pos;
	}




	public void setR0560_sold_hedg_net_delta_pos(BigDecimal r0560_sold_hedg_net_delta_pos) {
		this.r0560_sold_hedg_net_delta_pos = r0560_sold_hedg_net_delta_pos;
	}




	public BigDecimal getR0560_sold_trad_net_delta_pos() {
		return r0560_sold_trad_net_delta_pos;
	}




	public void setR0560_sold_trad_net_delta_pos(BigDecimal r0560_sold_trad_net_delta_pos) {
		this.r0560_sold_trad_net_delta_pos = r0560_sold_trad_net_delta_pos;
	}




	public BigDecimal getR0560_trad_nat_amt() {
		return r0560_trad_nat_amt;
	}




	public void setR0560_trad_nat_amt(BigDecimal r0560_trad_nat_amt) {
		this.r0560_trad_nat_amt = r0560_trad_nat_amt;
	}




	public BigDecimal getR0560_within_1_year_nat_amt() {
		return r0560_within_1_year_nat_amt;
	}




	public void setR0560_within_1_year_nat_amt(BigDecimal r0560_within_1_year_nat_amt) {
		this.r0560_within_1_year_nat_amt = r0560_within_1_year_nat_amt;
	}




	public String getR0570_product() {
		return r0570_product;
	}




	public void setR0570_product(String r0570_product) {
		this.r0570_product = r0570_product;
	}




	public BigDecimal getR0580_1_to_3_years_nat_amt() {
		return r0580_1_to_3_years_nat_amt;
	}




	public void setR0580_1_to_3_years_nat_amt(BigDecimal r0580_1_to_3_years_nat_amt) {
		this.r0580_1_to_3_years_nat_amt = r0580_1_to_3_years_nat_amt;
	}




	public BigDecimal getR0580_bought_hedg_net_delta_pos() {
		return r0580_bought_hedg_net_delta_pos;
	}




	public void setR0580_bought_hedg_net_delta_pos(BigDecimal r0580_bought_hedg_net_delta_pos) {
		this.r0580_bought_hedg_net_delta_pos = r0580_bought_hedg_net_delta_pos;
	}




	public BigDecimal getR0580_bought_trad_net_delta_pos() {
		return r0580_bought_trad_net_delta_pos;
	}




	public void setR0580_bought_trad_net_delta_pos(BigDecimal r0580_bought_trad_net_delta_pos) {
		this.r0580_bought_trad_net_delta_pos = r0580_bought_trad_net_delta_pos;
	}




	public BigDecimal getR0580_gross_mkt_val() {
		return r0580_gross_mkt_val;
	}




	public void setR0580_gross_mkt_val(BigDecimal r0580_gross_mkt_val) {
		this.r0580_gross_mkt_val = r0580_gross_mkt_val;
	}




	public BigDecimal getR0580_hedg_nat_amt() {
		return r0580_hedg_nat_amt;
	}




	public void setR0580_hedg_nat_amt(BigDecimal r0580_hedg_nat_amt) {
		this.r0580_hedg_nat_amt = r0580_hedg_nat_amt;
	}




	public BigDecimal getR0580_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0580_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0580_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0580_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0580_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0580_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0580_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0580_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0580_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0580_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0580_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0580_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0580_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0580_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0580_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0580_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0580_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0580_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0580_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0580_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0580_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0580_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0580_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0580_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0580_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0580_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0580_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0580_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0580_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0580_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0580_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0580_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0580_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0580_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0580_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0580_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0580_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0580_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0580_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0580_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0580_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0580_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0580_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0580_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0580_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0580_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0580_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0580_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0580_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0580_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0580_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0580_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0580_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0580_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0580_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0580_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0580_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0580_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0580_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0580_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0580_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0580_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0580_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0580_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0580_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0580_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0580_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0580_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0580_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0580_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0580_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0580_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public BigDecimal getR0580_nat_amt() {
		return r0580_nat_amt;
	}




	public void setR0580_nat_amt(BigDecimal r0580_nat_amt) {
		this.r0580_nat_amt = r0580_nat_amt;
	}




	public BigDecimal getR0580_non_res_nat_amt() {
		return r0580_non_res_nat_amt;
	}




	public void setR0580_non_res_nat_amt(BigDecimal r0580_non_res_nat_amt) {
		this.r0580_non_res_nat_amt = r0580_non_res_nat_amt;
	}




	public BigDecimal getR0580_over_3_years_nat_amt() {
		return r0580_over_3_years_nat_amt;
	}




	public void setR0580_over_3_years_nat_amt(BigDecimal r0580_over_3_years_nat_amt) {
		this.r0580_over_3_years_nat_amt = r0580_over_3_years_nat_amt;
	}




	public BigDecimal getR0580_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0580_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0580_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0580_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0580_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0580_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0580_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0580_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0580_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0580_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0580_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0580_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0580_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0580_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0580_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0580_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0580_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0580_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0580_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0580_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0580_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0580_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0580_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0580_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0580_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0580_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0580_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0580_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0580_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0580_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0580_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0580_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0580_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0580_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0580_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0580_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0580_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0580_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0580_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0580_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0580_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0580_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0580_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0580_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0580_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0580_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0580_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0580_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0580_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0580_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0580_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0580_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0580_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0580_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0580_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0580_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0580_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0580_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0580_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0580_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0580_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0580_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0580_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0580_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0580_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0580_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0580_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0580_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0580_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0580_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0580_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0580_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public String getR0580_product() {
		return r0580_product;
	}




	public void setR0580_product(String r0580_product) {
		this.r0580_product = r0580_product;
	}




	public BigDecimal getR0580_pro_bought_net_gain_loss() {
		return r0580_pro_bought_net_gain_loss;
	}




	public void setR0580_pro_bought_net_gain_loss(BigDecimal r0580_pro_bought_net_gain_loss) {
		this.r0580_pro_bought_net_gain_loss = r0580_pro_bought_net_gain_loss;
	}




	public BigDecimal getR0580_pro_sold_net_gain_loss() {
		return r0580_pro_sold_net_gain_loss;
	}




	public void setR0580_pro_sold_net_gain_loss(BigDecimal r0580_pro_sold_net_gain_loss) {
		this.r0580_pro_sold_net_gain_loss = r0580_pro_sold_net_gain_loss;
	}




	public BigDecimal getR0580_res_1_to_3_years_mkt_val() {
		return r0580_res_1_to_3_years_mkt_val;
	}




	public void setR0580_res_1_to_3_years_mkt_val(BigDecimal r0580_res_1_to_3_years_mkt_val) {
		this.r0580_res_1_to_3_years_mkt_val = r0580_res_1_to_3_years_mkt_val;
	}




	public BigDecimal getR0580_res_lessthan_1_year_mkt_val() {
		return r0580_res_lessthan_1_year_mkt_val;
	}




	public void setR0580_res_lessthan_1_year_mkt_val(BigDecimal r0580_res_lessthan_1_year_mkt_val) {
		this.r0580_res_lessthan_1_year_mkt_val = r0580_res_lessthan_1_year_mkt_val;
	}




	public BigDecimal getR0580_res_morethan_3_years_mkt_val() {
		return r0580_res_morethan_3_years_mkt_val;
	}




	public void setR0580_res_morethan_3_years_mkt_val(BigDecimal r0580_res_morethan_3_years_mkt_val) {
		this.r0580_res_morethan_3_years_mkt_val = r0580_res_morethan_3_years_mkt_val;
	}




	public BigDecimal getR0580_res_nat_amt() {
		return r0580_res_nat_amt;
	}




	public void setR0580_res_nat_amt(BigDecimal r0580_res_nat_amt) {
		this.r0580_res_nat_amt = r0580_res_nat_amt;
	}




	public BigDecimal getR0580_sold_hedg_net_delta_pos() {
		return r0580_sold_hedg_net_delta_pos;
	}




	public void setR0580_sold_hedg_net_delta_pos(BigDecimal r0580_sold_hedg_net_delta_pos) {
		this.r0580_sold_hedg_net_delta_pos = r0580_sold_hedg_net_delta_pos;
	}




	public BigDecimal getR0580_sold_trad_net_delta_pos() {
		return r0580_sold_trad_net_delta_pos;
	}




	public void setR0580_sold_trad_net_delta_pos(BigDecimal r0580_sold_trad_net_delta_pos) {
		this.r0580_sold_trad_net_delta_pos = r0580_sold_trad_net_delta_pos;
	}




	public BigDecimal getR0580_trad_nat_amt() {
		return r0580_trad_nat_amt;
	}




	public void setR0580_trad_nat_amt(BigDecimal r0580_trad_nat_amt) {
		this.r0580_trad_nat_amt = r0580_trad_nat_amt;
	}




	public BigDecimal getR0580_within_1_year_nat_amt() {
		return r0580_within_1_year_nat_amt;
	}




	public void setR0580_within_1_year_nat_amt(BigDecimal r0580_within_1_year_nat_amt) {
		this.r0580_within_1_year_nat_amt = r0580_within_1_year_nat_amt;
	}




	public String getR0590_product() {
		return r0590_product;
	}




	public void setR0590_product(String r0590_product) {
		this.r0590_product = r0590_product;
	}




	public BigDecimal getR0600_1_to_3_years_nat_amt() {
		return r0600_1_to_3_years_nat_amt;
	}




	public void setR0600_1_to_3_years_nat_amt(BigDecimal r0600_1_to_3_years_nat_amt) {
		this.r0600_1_to_3_years_nat_amt = r0600_1_to_3_years_nat_amt;
	}




	public BigDecimal getR0600_bought_hedg_net_delta_pos() {
		return r0600_bought_hedg_net_delta_pos;
	}




	public void setR0600_bought_hedg_net_delta_pos(BigDecimal r0600_bought_hedg_net_delta_pos) {
		this.r0600_bought_hedg_net_delta_pos = r0600_bought_hedg_net_delta_pos;
	}




	public BigDecimal getR0600_bought_trad_net_delta_pos() {
		return r0600_bought_trad_net_delta_pos;
	}




	public void setR0600_bought_trad_net_delta_pos(BigDecimal r0600_bought_trad_net_delta_pos) {
		this.r0600_bought_trad_net_delta_pos = r0600_bought_trad_net_delta_pos;
	}




	public BigDecimal getR0600_gross_mkt_val() {
		return r0600_gross_mkt_val;
	}




	public void setR0600_gross_mkt_val(BigDecimal r0600_gross_mkt_val) {
		this.r0600_gross_mkt_val = r0600_gross_mkt_val;
	}




	public BigDecimal getR0600_hedg_nat_amt() {
		return r0600_hedg_nat_amt;
	}




	public void setR0600_hedg_nat_amt(BigDecimal r0600_hedg_nat_amt) {
		this.r0600_hedg_nat_amt = r0600_hedg_nat_amt;
	}




	public BigDecimal getR0600_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0600_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0600_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0600_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0600_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0600_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0600_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0600_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0600_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0600_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0600_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0600_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0600_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0600_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0600_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0600_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0600_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0600_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0600_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0600_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0600_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0600_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0600_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0600_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0600_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0600_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0600_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0600_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0600_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0600_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0600_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0600_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0600_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0600_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0600_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0600_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0600_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0600_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0600_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0600_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0600_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0600_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0600_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0600_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0600_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0600_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0600_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0600_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0600_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0600_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0600_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0600_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0600_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0600_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0600_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0600_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0600_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0600_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0600_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0600_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0600_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0600_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0600_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0600_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0600_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0600_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0600_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0600_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0600_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0600_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0600_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0600_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public BigDecimal getR0600_nat_amt() {
		return r0600_nat_amt;
	}




	public void setR0600_nat_amt(BigDecimal r0600_nat_amt) {
		this.r0600_nat_amt = r0600_nat_amt;
	}




	public BigDecimal getR0600_non_res_nat_amt() {
		return r0600_non_res_nat_amt;
	}




	public void setR0600_non_res_nat_amt(BigDecimal r0600_non_res_nat_amt) {
		this.r0600_non_res_nat_amt = r0600_non_res_nat_amt;
	}




	public BigDecimal getR0600_over_3_years_nat_amt() {
		return r0600_over_3_years_nat_amt;
	}




	public void setR0600_over_3_years_nat_amt(BigDecimal r0600_over_3_years_nat_amt) {
		this.r0600_over_3_years_nat_amt = r0600_over_3_years_nat_amt;
	}




	public BigDecimal getR0600_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0600_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0600_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0600_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0600_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0600_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0600_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0600_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0600_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0600_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0600_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0600_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0600_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0600_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0600_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0600_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0600_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0600_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0600_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0600_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0600_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0600_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0600_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0600_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0600_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0600_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0600_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0600_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0600_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0600_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0600_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0600_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0600_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0600_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0600_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0600_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0600_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0600_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0600_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0600_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0600_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0600_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0600_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0600_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0600_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0600_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0600_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0600_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0600_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0600_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0600_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0600_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0600_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0600_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0600_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0600_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0600_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0600_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0600_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0600_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0600_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0600_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0600_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0600_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0600_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0600_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0600_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0600_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0600_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0600_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0600_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0600_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public String getR0600_product() {
		return r0600_product;
	}




	public void setR0600_product(String r0600_product) {
		this.r0600_product = r0600_product;
	}




	public BigDecimal getR0600_pro_bought_net_gain_loss() {
		return r0600_pro_bought_net_gain_loss;
	}




	public void setR0600_pro_bought_net_gain_loss(BigDecimal r0600_pro_bought_net_gain_loss) {
		this.r0600_pro_bought_net_gain_loss = r0600_pro_bought_net_gain_loss;
	}




	public BigDecimal getR0600_pro_sold_net_gain_loss() {
		return r0600_pro_sold_net_gain_loss;
	}




	public void setR0600_pro_sold_net_gain_loss(BigDecimal r0600_pro_sold_net_gain_loss) {
		this.r0600_pro_sold_net_gain_loss = r0600_pro_sold_net_gain_loss;
	}




	public BigDecimal getR0600_res_1_to_3_years_mkt_val() {
		return r0600_res_1_to_3_years_mkt_val;
	}




	public void setR0600_res_1_to_3_years_mkt_val(BigDecimal r0600_res_1_to_3_years_mkt_val) {
		this.r0600_res_1_to_3_years_mkt_val = r0600_res_1_to_3_years_mkt_val;
	}




	public BigDecimal getR0600_res_lessthan_1_year_mkt_val() {
		return r0600_res_lessthan_1_year_mkt_val;
	}




	public void setR0600_res_lessthan_1_year_mkt_val(BigDecimal r0600_res_lessthan_1_year_mkt_val) {
		this.r0600_res_lessthan_1_year_mkt_val = r0600_res_lessthan_1_year_mkt_val;
	}




	public BigDecimal getR0600_res_morethan_3_years_mkt_val() {
		return r0600_res_morethan_3_years_mkt_val;
	}




	public void setR0600_res_morethan_3_years_mkt_val(BigDecimal r0600_res_morethan_3_years_mkt_val) {
		this.r0600_res_morethan_3_years_mkt_val = r0600_res_morethan_3_years_mkt_val;
	}




	public BigDecimal getR0600_res_nat_amt() {
		return r0600_res_nat_amt;
	}




	public void setR0600_res_nat_amt(BigDecimal r0600_res_nat_amt) {
		this.r0600_res_nat_amt = r0600_res_nat_amt;
	}




	public BigDecimal getR0600_sold_hedg_net_delta_pos() {
		return r0600_sold_hedg_net_delta_pos;
	}




	public void setR0600_sold_hedg_net_delta_pos(BigDecimal r0600_sold_hedg_net_delta_pos) {
		this.r0600_sold_hedg_net_delta_pos = r0600_sold_hedg_net_delta_pos;
	}




	public BigDecimal getR0600_sold_trad_net_delta_pos() {
		return r0600_sold_trad_net_delta_pos;
	}




	public void setR0600_sold_trad_net_delta_pos(BigDecimal r0600_sold_trad_net_delta_pos) {
		this.r0600_sold_trad_net_delta_pos = r0600_sold_trad_net_delta_pos;
	}




	public BigDecimal getR0600_trad_nat_amt() {
		return r0600_trad_nat_amt;
	}




	public void setR0600_trad_nat_amt(BigDecimal r0600_trad_nat_amt) {
		this.r0600_trad_nat_amt = r0600_trad_nat_amt;
	}




	public BigDecimal getR0600_within_1_year_nat_amt() {
		return r0600_within_1_year_nat_amt;
	}




	public void setR0600_within_1_year_nat_amt(BigDecimal r0600_within_1_year_nat_amt) {
		this.r0600_within_1_year_nat_amt = r0600_within_1_year_nat_amt;
	}




	public BigDecimal getR0610_1_to_3_years_nat_amt() {
		return r0610_1_to_3_years_nat_amt;
	}




	public void setR0610_1_to_3_years_nat_amt(BigDecimal r0610_1_to_3_years_nat_amt) {
		this.r0610_1_to_3_years_nat_amt = r0610_1_to_3_years_nat_amt;
	}




	public BigDecimal getR0610_bought_hedg_net_delta_pos() {
		return r0610_bought_hedg_net_delta_pos;
	}




	public void setR0610_bought_hedg_net_delta_pos(BigDecimal r0610_bought_hedg_net_delta_pos) {
		this.r0610_bought_hedg_net_delta_pos = r0610_bought_hedg_net_delta_pos;
	}




	public BigDecimal getR0610_bought_trad_net_delta_pos() {
		return r0610_bought_trad_net_delta_pos;
	}




	public void setR0610_bought_trad_net_delta_pos(BigDecimal r0610_bought_trad_net_delta_pos) {
		this.r0610_bought_trad_net_delta_pos = r0610_bought_trad_net_delta_pos;
	}




	public BigDecimal getR0610_gross_mkt_val() {
		return r0610_gross_mkt_val;
	}




	public void setR0610_gross_mkt_val(BigDecimal r0610_gross_mkt_val) {
		this.r0610_gross_mkt_val = r0610_gross_mkt_val;
	}




	public BigDecimal getR0610_hedg_nat_amt() {
		return r0610_hedg_nat_amt;
	}




	public void setR0610_hedg_nat_amt(BigDecimal r0610_hedg_nat_amt) {
		this.r0610_hedg_nat_amt = r0610_hedg_nat_amt;
	}




	public BigDecimal getR0610_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0610_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0610_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0610_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0610_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0610_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0610_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0610_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0610_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0610_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0610_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0610_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0610_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0610_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0610_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0610_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0610_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0610_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0610_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0610_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0610_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0610_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0610_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0610_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0610_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0610_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0610_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0610_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0610_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0610_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0610_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0610_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0610_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0610_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0610_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0610_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0610_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0610_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0610_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0610_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0610_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0610_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0610_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0610_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0610_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0610_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0610_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0610_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0610_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0610_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0610_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0610_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0610_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0610_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0610_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0610_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0610_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0610_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0610_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0610_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0610_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0610_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0610_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0610_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0610_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0610_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0610_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0610_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0610_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0610_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0610_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0610_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public BigDecimal getR0610_nat_amt() {
		return r0610_nat_amt;
	}




	public void setR0610_nat_amt(BigDecimal r0610_nat_amt) {
		this.r0610_nat_amt = r0610_nat_amt;
	}




	public BigDecimal getR0610_non_res_nat_amt() {
		return r0610_non_res_nat_amt;
	}




	public void setR0610_non_res_nat_amt(BigDecimal r0610_non_res_nat_amt) {
		this.r0610_non_res_nat_amt = r0610_non_res_nat_amt;
	}




	public BigDecimal getR0610_over_3_years_nat_amt() {
		return r0610_over_3_years_nat_amt;
	}




	public void setR0610_over_3_years_nat_amt(BigDecimal r0610_over_3_years_nat_amt) {
		this.r0610_over_3_years_nat_amt = r0610_over_3_years_nat_amt;
	}




	public BigDecimal getR0610_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0610_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0610_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0610_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0610_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0610_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0610_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0610_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0610_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0610_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0610_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0610_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0610_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0610_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0610_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0610_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0610_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0610_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0610_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0610_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0610_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0610_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0610_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0610_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0610_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0610_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0610_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0610_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0610_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0610_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0610_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0610_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0610_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0610_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0610_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0610_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0610_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0610_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0610_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0610_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0610_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0610_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0610_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0610_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0610_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0610_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0610_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0610_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0610_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0610_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0610_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0610_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0610_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0610_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0610_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0610_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0610_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0610_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0610_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0610_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0610_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0610_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0610_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0610_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0610_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0610_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0610_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0610_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0610_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0610_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0610_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0610_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public String getR0610_product() {
		return r0610_product;
	}




	public void setR0610_product(String r0610_product) {
		this.r0610_product = r0610_product;
	}




	public BigDecimal getR0610_pro_bought_net_gain_loss() {
		return r0610_pro_bought_net_gain_loss;
	}




	public void setR0610_pro_bought_net_gain_loss(BigDecimal r0610_pro_bought_net_gain_loss) {
		this.r0610_pro_bought_net_gain_loss = r0610_pro_bought_net_gain_loss;
	}




	public BigDecimal getR0610_pro_sold_net_gain_loss() {
		return r0610_pro_sold_net_gain_loss;
	}




	public void setR0610_pro_sold_net_gain_loss(BigDecimal r0610_pro_sold_net_gain_loss) {
		this.r0610_pro_sold_net_gain_loss = r0610_pro_sold_net_gain_loss;
	}




	public BigDecimal getR0610_res_1_to_3_years_mkt_val() {
		return r0610_res_1_to_3_years_mkt_val;
	}




	public void setR0610_res_1_to_3_years_mkt_val(BigDecimal r0610_res_1_to_3_years_mkt_val) {
		this.r0610_res_1_to_3_years_mkt_val = r0610_res_1_to_3_years_mkt_val;
	}




	public BigDecimal getR0610_res_lessthan_1_year_mkt_val() {
		return r0610_res_lessthan_1_year_mkt_val;
	}




	public void setR0610_res_lessthan_1_year_mkt_val(BigDecimal r0610_res_lessthan_1_year_mkt_val) {
		this.r0610_res_lessthan_1_year_mkt_val = r0610_res_lessthan_1_year_mkt_val;
	}




	public BigDecimal getR0610_res_morethan_3_years_mkt_val() {
		return r0610_res_morethan_3_years_mkt_val;
	}




	public void setR0610_res_morethan_3_years_mkt_val(BigDecimal r0610_res_morethan_3_years_mkt_val) {
		this.r0610_res_morethan_3_years_mkt_val = r0610_res_morethan_3_years_mkt_val;
	}




	public BigDecimal getR0610_res_nat_amt() {
		return r0610_res_nat_amt;
	}




	public void setR0610_res_nat_amt(BigDecimal r0610_res_nat_amt) {
		this.r0610_res_nat_amt = r0610_res_nat_amt;
	}




	public BigDecimal getR0610_sold_hedg_net_delta_pos() {
		return r0610_sold_hedg_net_delta_pos;
	}




	public void setR0610_sold_hedg_net_delta_pos(BigDecimal r0610_sold_hedg_net_delta_pos) {
		this.r0610_sold_hedg_net_delta_pos = r0610_sold_hedg_net_delta_pos;
	}




	public BigDecimal getR0610_sold_trad_net_delta_pos() {
		return r0610_sold_trad_net_delta_pos;
	}




	public void setR0610_sold_trad_net_delta_pos(BigDecimal r0610_sold_trad_net_delta_pos) {
		this.r0610_sold_trad_net_delta_pos = r0610_sold_trad_net_delta_pos;
	}




	public BigDecimal getR0610_trad_nat_amt() {
		return r0610_trad_nat_amt;
	}




	public void setR0610_trad_nat_amt(BigDecimal r0610_trad_nat_amt) {
		this.r0610_trad_nat_amt = r0610_trad_nat_amt;
	}




	public BigDecimal getR0610_within_1_year_nat_amt() {
		return r0610_within_1_year_nat_amt;
	}




	public void setR0610_within_1_year_nat_amt(BigDecimal r0610_within_1_year_nat_amt) {
		this.r0610_within_1_year_nat_amt = r0610_within_1_year_nat_amt;
	}




	public BigDecimal getR0620_1_to_3_years_nat_amt() {
		return r0620_1_to_3_years_nat_amt;
	}




	public void setR0620_1_to_3_years_nat_amt(BigDecimal r0620_1_to_3_years_nat_amt) {
		this.r0620_1_to_3_years_nat_amt = r0620_1_to_3_years_nat_amt;
	}




	public BigDecimal getR0620_bought_hedg_net_delta_pos() {
		return r0620_bought_hedg_net_delta_pos;
	}




	public void setR0620_bought_hedg_net_delta_pos(BigDecimal r0620_bought_hedg_net_delta_pos) {
		this.r0620_bought_hedg_net_delta_pos = r0620_bought_hedg_net_delta_pos;
	}




	public BigDecimal getR0620_bought_trad_net_delta_pos() {
		return r0620_bought_trad_net_delta_pos;
	}




	public void setR0620_bought_trad_net_delta_pos(BigDecimal r0620_bought_trad_net_delta_pos) {
		this.r0620_bought_trad_net_delta_pos = r0620_bought_trad_net_delta_pos;
	}




	public BigDecimal getR0620_gross_mkt_val() {
		return r0620_gross_mkt_val;
	}




	public void setR0620_gross_mkt_val(BigDecimal r0620_gross_mkt_val) {
		this.r0620_gross_mkt_val = r0620_gross_mkt_val;
	}




	public BigDecimal getR0620_hedg_nat_amt() {
		return r0620_hedg_nat_amt;
	}




	public void setR0620_hedg_nat_amt(BigDecimal r0620_hedg_nat_amt) {
		this.r0620_hedg_nat_amt = r0620_hedg_nat_amt;
	}




	public BigDecimal getR0620_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0620_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0620_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0620_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0620_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0620_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0620_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0620_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0620_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0620_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0620_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0620_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0620_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0620_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0620_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0620_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0620_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0620_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0620_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0620_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0620_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0620_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0620_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0620_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0620_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0620_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0620_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0620_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0620_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0620_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0620_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0620_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0620_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0620_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0620_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0620_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0620_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0620_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0620_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0620_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0620_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0620_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0620_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0620_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0620_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0620_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0620_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0620_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0620_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0620_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0620_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0620_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0620_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0620_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0620_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0620_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0620_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0620_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0620_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0620_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0620_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0620_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0620_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0620_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0620_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0620_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0620_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0620_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0620_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0620_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0620_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0620_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public BigDecimal getR0620_nat_amt() {
		return r0620_nat_amt;
	}




	public void setR0620_nat_amt(BigDecimal r0620_nat_amt) {
		this.r0620_nat_amt = r0620_nat_amt;
	}




	public BigDecimal getR0620_non_res_nat_amt() {
		return r0620_non_res_nat_amt;
	}




	public void setR0620_non_res_nat_amt(BigDecimal r0620_non_res_nat_amt) {
		this.r0620_non_res_nat_amt = r0620_non_res_nat_amt;
	}




	public BigDecimal getR0620_over_3_years_nat_amt() {
		return r0620_over_3_years_nat_amt;
	}




	public void setR0620_over_3_years_nat_amt(BigDecimal r0620_over_3_years_nat_amt) {
		this.r0620_over_3_years_nat_amt = r0620_over_3_years_nat_amt;
	}




	public BigDecimal getR0620_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0620_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0620_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0620_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0620_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0620_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0620_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0620_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0620_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0620_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0620_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0620_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0620_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0620_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0620_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0620_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0620_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0620_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0620_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0620_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0620_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0620_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0620_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0620_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0620_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0620_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0620_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0620_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0620_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0620_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0620_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0620_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0620_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0620_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0620_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0620_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0620_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0620_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0620_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0620_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0620_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0620_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0620_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0620_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0620_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0620_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0620_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0620_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0620_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0620_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0620_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0620_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0620_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0620_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0620_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0620_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0620_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0620_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0620_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0620_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0620_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0620_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0620_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0620_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0620_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0620_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0620_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0620_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0620_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0620_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0620_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0620_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public String getR0620_product() {
		return r0620_product;
	}




	public void setR0620_product(String r0620_product) {
		this.r0620_product = r0620_product;
	}




	public BigDecimal getR0620_pro_bought_net_gain_loss() {
		return r0620_pro_bought_net_gain_loss;
	}




	public void setR0620_pro_bought_net_gain_loss(BigDecimal r0620_pro_bought_net_gain_loss) {
		this.r0620_pro_bought_net_gain_loss = r0620_pro_bought_net_gain_loss;
	}




	public BigDecimal getR0620_pro_sold_net_gain_loss() {
		return r0620_pro_sold_net_gain_loss;
	}




	public void setR0620_pro_sold_net_gain_loss(BigDecimal r0620_pro_sold_net_gain_loss) {
		this.r0620_pro_sold_net_gain_loss = r0620_pro_sold_net_gain_loss;
	}




	public BigDecimal getR0620_res_1_to_3_years_mkt_val() {
		return r0620_res_1_to_3_years_mkt_val;
	}




	public void setR0620_res_1_to_3_years_mkt_val(BigDecimal r0620_res_1_to_3_years_mkt_val) {
		this.r0620_res_1_to_3_years_mkt_val = r0620_res_1_to_3_years_mkt_val;
	}




	public BigDecimal getR0620_res_lessthan_1_year_mkt_val() {
		return r0620_res_lessthan_1_year_mkt_val;
	}




	public void setR0620_res_lessthan_1_year_mkt_val(BigDecimal r0620_res_lessthan_1_year_mkt_val) {
		this.r0620_res_lessthan_1_year_mkt_val = r0620_res_lessthan_1_year_mkt_val;
	}




	public BigDecimal getR0620_res_morethan_3_years_mkt_val() {
		return r0620_res_morethan_3_years_mkt_val;
	}




	public void setR0620_res_morethan_3_years_mkt_val(BigDecimal r0620_res_morethan_3_years_mkt_val) {
		this.r0620_res_morethan_3_years_mkt_val = r0620_res_morethan_3_years_mkt_val;
	}




	public BigDecimal getR0620_res_nat_amt() {
		return r0620_res_nat_amt;
	}




	public void setR0620_res_nat_amt(BigDecimal r0620_res_nat_amt) {
		this.r0620_res_nat_amt = r0620_res_nat_amt;
	}




	public BigDecimal getR0620_sold_hedg_net_delta_pos() {
		return r0620_sold_hedg_net_delta_pos;
	}




	public void setR0620_sold_hedg_net_delta_pos(BigDecimal r0620_sold_hedg_net_delta_pos) {
		this.r0620_sold_hedg_net_delta_pos = r0620_sold_hedg_net_delta_pos;
	}




	public BigDecimal getR0620_sold_trad_net_delta_pos() {
		return r0620_sold_trad_net_delta_pos;
	}




	public void setR0620_sold_trad_net_delta_pos(BigDecimal r0620_sold_trad_net_delta_pos) {
		this.r0620_sold_trad_net_delta_pos = r0620_sold_trad_net_delta_pos;
	}




	public BigDecimal getR0620_trad_nat_amt() {
		return r0620_trad_nat_amt;
	}




	public void setR0620_trad_nat_amt(BigDecimal r0620_trad_nat_amt) {
		this.r0620_trad_nat_amt = r0620_trad_nat_amt;
	}




	public BigDecimal getR0620_within_1_year_nat_amt() {
		return r0620_within_1_year_nat_amt;
	}




	public void setR0620_within_1_year_nat_amt(BigDecimal r0620_within_1_year_nat_amt) {
		this.r0620_within_1_year_nat_amt = r0620_within_1_year_nat_amt;
	}




	public BigDecimal getR0630_1_to_3_years_nat_amt() {
		return r0630_1_to_3_years_nat_amt;
	}




	public void setR0630_1_to_3_years_nat_amt(BigDecimal r0630_1_to_3_years_nat_amt) {
		this.r0630_1_to_3_years_nat_amt = r0630_1_to_3_years_nat_amt;
	}




	public BigDecimal getR0630_bought_hedg_net_delta_pos() {
		return r0630_bought_hedg_net_delta_pos;
	}




	public void setR0630_bought_hedg_net_delta_pos(BigDecimal r0630_bought_hedg_net_delta_pos) {
		this.r0630_bought_hedg_net_delta_pos = r0630_bought_hedg_net_delta_pos;
	}




	public BigDecimal getR0630_bought_trad_net_delta_pos() {
		return r0630_bought_trad_net_delta_pos;
	}




	public void setR0630_bought_trad_net_delta_pos(BigDecimal r0630_bought_trad_net_delta_pos) {
		this.r0630_bought_trad_net_delta_pos = r0630_bought_trad_net_delta_pos;
	}




	public BigDecimal getR0630_gross_mkt_val() {
		return r0630_gross_mkt_val;
	}




	public void setR0630_gross_mkt_val(BigDecimal r0630_gross_mkt_val) {
		this.r0630_gross_mkt_val = r0630_gross_mkt_val;
	}




	public BigDecimal getR0630_hedg_nat_amt() {
		return r0630_hedg_nat_amt;
	}




	public void setR0630_hedg_nat_amt(BigDecimal r0630_hedg_nat_amt) {
		this.r0630_hedg_nat_amt = r0630_hedg_nat_amt;
	}




	public BigDecimal getR0630_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0630_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0630_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0630_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0630_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0630_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0630_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0630_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0630_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0630_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0630_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0630_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0630_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0630_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0630_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0630_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0630_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0630_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0630_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0630_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0630_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0630_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0630_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0630_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0630_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0630_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0630_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0630_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0630_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0630_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0630_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0630_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0630_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0630_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0630_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0630_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0630_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0630_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0630_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0630_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0630_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0630_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0630_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0630_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0630_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0630_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0630_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0630_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0630_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0630_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0630_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0630_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0630_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0630_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0630_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0630_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0630_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0630_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0630_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0630_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0630_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0630_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0630_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0630_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0630_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0630_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0630_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0630_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0630_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0630_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0630_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0630_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public BigDecimal getR0630_nat_amt() {
		return r0630_nat_amt;
	}




	public void setR0630_nat_amt(BigDecimal r0630_nat_amt) {
		this.r0630_nat_amt = r0630_nat_amt;
	}




	public BigDecimal getR0630_non_res_nat_amt() {
		return r0630_non_res_nat_amt;
	}




	public void setR0630_non_res_nat_amt(BigDecimal r0630_non_res_nat_amt) {
		this.r0630_non_res_nat_amt = r0630_non_res_nat_amt;
	}




	public BigDecimal getR0630_over_3_years_nat_amt() {
		return r0630_over_3_years_nat_amt;
	}




	public void setR0630_over_3_years_nat_amt(BigDecimal r0630_over_3_years_nat_amt) {
		this.r0630_over_3_years_nat_amt = r0630_over_3_years_nat_amt;
	}




	public BigDecimal getR0630_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0630_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0630_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0630_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0630_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0630_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0630_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0630_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0630_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0630_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0630_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0630_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0630_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0630_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0630_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0630_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0630_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0630_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0630_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0630_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0630_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0630_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0630_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0630_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0630_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0630_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0630_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0630_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0630_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0630_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0630_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0630_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0630_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0630_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0630_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0630_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0630_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0630_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0630_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0630_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0630_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0630_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0630_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0630_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0630_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0630_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0630_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0630_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0630_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0630_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0630_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0630_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0630_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0630_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0630_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0630_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0630_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0630_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0630_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0630_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0630_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0630_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0630_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0630_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0630_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0630_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0630_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0630_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0630_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0630_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0630_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0630_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public String getR0630_product() {
		return r0630_product;
	}




	public void setR0630_product(String r0630_product) {
		this.r0630_product = r0630_product;
	}




	public BigDecimal getR0630_pro_bought_net_gain_loss() {
		return r0630_pro_bought_net_gain_loss;
	}




	public void setR0630_pro_bought_net_gain_loss(BigDecimal r0630_pro_bought_net_gain_loss) {
		this.r0630_pro_bought_net_gain_loss = r0630_pro_bought_net_gain_loss;
	}




	public BigDecimal getR0630_pro_sold_net_gain_loss() {
		return r0630_pro_sold_net_gain_loss;
	}




	public void setR0630_pro_sold_net_gain_loss(BigDecimal r0630_pro_sold_net_gain_loss) {
		this.r0630_pro_sold_net_gain_loss = r0630_pro_sold_net_gain_loss;
	}




	public BigDecimal getR0630_res_1_to_3_years_mkt_val() {
		return r0630_res_1_to_3_years_mkt_val;
	}




	public void setR0630_res_1_to_3_years_mkt_val(BigDecimal r0630_res_1_to_3_years_mkt_val) {
		this.r0630_res_1_to_3_years_mkt_val = r0630_res_1_to_3_years_mkt_val;
	}




	public BigDecimal getR0630_res_lessthan_1_year_mkt_val() {
		return r0630_res_lessthan_1_year_mkt_val;
	}




	public void setR0630_res_lessthan_1_year_mkt_val(BigDecimal r0630_res_lessthan_1_year_mkt_val) {
		this.r0630_res_lessthan_1_year_mkt_val = r0630_res_lessthan_1_year_mkt_val;
	}




	public BigDecimal getR0630_res_morethan_3_years_mkt_val() {
		return r0630_res_morethan_3_years_mkt_val;
	}




	public void setR0630_res_morethan_3_years_mkt_val(BigDecimal r0630_res_morethan_3_years_mkt_val) {
		this.r0630_res_morethan_3_years_mkt_val = r0630_res_morethan_3_years_mkt_val;
	}




	public BigDecimal getR0630_res_nat_amt() {
		return r0630_res_nat_amt;
	}




	public void setR0630_res_nat_amt(BigDecimal r0630_res_nat_amt) {
		this.r0630_res_nat_amt = r0630_res_nat_amt;
	}




	public BigDecimal getR0630_sold_hedg_net_delta_pos() {
		return r0630_sold_hedg_net_delta_pos;
	}




	public void setR0630_sold_hedg_net_delta_pos(BigDecimal r0630_sold_hedg_net_delta_pos) {
		this.r0630_sold_hedg_net_delta_pos = r0630_sold_hedg_net_delta_pos;
	}




	public BigDecimal getR0630_sold_trad_net_delta_pos() {
		return r0630_sold_trad_net_delta_pos;
	}




	public void setR0630_sold_trad_net_delta_pos(BigDecimal r0630_sold_trad_net_delta_pos) {
		this.r0630_sold_trad_net_delta_pos = r0630_sold_trad_net_delta_pos;
	}




	public BigDecimal getR0630_trad_nat_amt() {
		return r0630_trad_nat_amt;
	}




	public void setR0630_trad_nat_amt(BigDecimal r0630_trad_nat_amt) {
		this.r0630_trad_nat_amt = r0630_trad_nat_amt;
	}




	public BigDecimal getR0630_within_1_year_nat_amt() {
		return r0630_within_1_year_nat_amt;
	}




	public void setR0630_within_1_year_nat_amt(BigDecimal r0630_within_1_year_nat_amt) {
		this.r0630_within_1_year_nat_amt = r0630_within_1_year_nat_amt;
	}




	public BigDecimal getR0640_1_to_3_years_nat_amt() {
		return r0640_1_to_3_years_nat_amt;
	}




	public void setR0640_1_to_3_years_nat_amt(BigDecimal r0640_1_to_3_years_nat_amt) {
		this.r0640_1_to_3_years_nat_amt = r0640_1_to_3_years_nat_amt;
	}




	public BigDecimal getR0640_bought_hedg_net_delta_pos() {
		return r0640_bought_hedg_net_delta_pos;
	}




	public void setR0640_bought_hedg_net_delta_pos(BigDecimal r0640_bought_hedg_net_delta_pos) {
		this.r0640_bought_hedg_net_delta_pos = r0640_bought_hedg_net_delta_pos;
	}




	public BigDecimal getR0640_bought_trad_net_delta_pos() {
		return r0640_bought_trad_net_delta_pos;
	}




	public void setR0640_bought_trad_net_delta_pos(BigDecimal r0640_bought_trad_net_delta_pos) {
		this.r0640_bought_trad_net_delta_pos = r0640_bought_trad_net_delta_pos;
	}




	public BigDecimal getR0640_gross_mkt_val() {
		return r0640_gross_mkt_val;
	}




	public void setR0640_gross_mkt_val(BigDecimal r0640_gross_mkt_val) {
		this.r0640_gross_mkt_val = r0640_gross_mkt_val;
	}




	public BigDecimal getR0640_hedg_nat_amt() {
		return r0640_hedg_nat_amt;
	}




	public void setR0640_hedg_nat_amt(BigDecimal r0640_hedg_nat_amt) {
		this.r0640_hedg_nat_amt = r0640_hedg_nat_amt;
	}




	public BigDecimal getR0640_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0640_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0640_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0640_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0640_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0640_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0640_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0640_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0640_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0640_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0640_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0640_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0640_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0640_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0640_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0640_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0640_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0640_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0640_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0640_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0640_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0640_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0640_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0640_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0640_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0640_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0640_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0640_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0640_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0640_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0640_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0640_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0640_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0640_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0640_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0640_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0640_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0640_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0640_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0640_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0640_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0640_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0640_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0640_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0640_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0640_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0640_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0640_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0640_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0640_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0640_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0640_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0640_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0640_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0640_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0640_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0640_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0640_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0640_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0640_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0640_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0640_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0640_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0640_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0640_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0640_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0640_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0640_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0640_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0640_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0640_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0640_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public BigDecimal getR0640_nat_amt() {
		return r0640_nat_amt;
	}




	public void setR0640_nat_amt(BigDecimal r0640_nat_amt) {
		this.r0640_nat_amt = r0640_nat_amt;
	}




	public BigDecimal getR0640_non_res_nat_amt() {
		return r0640_non_res_nat_amt;
	}




	public void setR0640_non_res_nat_amt(BigDecimal r0640_non_res_nat_amt) {
		this.r0640_non_res_nat_amt = r0640_non_res_nat_amt;
	}




	public BigDecimal getR0640_over_3_years_nat_amt() {
		return r0640_over_3_years_nat_amt;
	}




	public void setR0640_over_3_years_nat_amt(BigDecimal r0640_over_3_years_nat_amt) {
		this.r0640_over_3_years_nat_amt = r0640_over_3_years_nat_amt;
	}




	public BigDecimal getR0640_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0640_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0640_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0640_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0640_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0640_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0640_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0640_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0640_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0640_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0640_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0640_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0640_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0640_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0640_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0640_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0640_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0640_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0640_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0640_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0640_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0640_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0640_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0640_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0640_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0640_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0640_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0640_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0640_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0640_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0640_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0640_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0640_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0640_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0640_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0640_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0640_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0640_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0640_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0640_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0640_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0640_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0640_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0640_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0640_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0640_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0640_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0640_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0640_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0640_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0640_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0640_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0640_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0640_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0640_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0640_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0640_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0640_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0640_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0640_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0640_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0640_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0640_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0640_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0640_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0640_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0640_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0640_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0640_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0640_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0640_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0640_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public String getR0640_product() {
		return r0640_product;
	}




	public void setR0640_product(String r0640_product) {
		this.r0640_product = r0640_product;
	}




	public BigDecimal getR0640_pro_bought_net_gain_loss() {
		return r0640_pro_bought_net_gain_loss;
	}




	public void setR0640_pro_bought_net_gain_loss(BigDecimal r0640_pro_bought_net_gain_loss) {
		this.r0640_pro_bought_net_gain_loss = r0640_pro_bought_net_gain_loss;
	}




	public BigDecimal getR0640_pro_sold_net_gain_loss() {
		return r0640_pro_sold_net_gain_loss;
	}




	public void setR0640_pro_sold_net_gain_loss(BigDecimal r0640_pro_sold_net_gain_loss) {
		this.r0640_pro_sold_net_gain_loss = r0640_pro_sold_net_gain_loss;
	}




	public BigDecimal getR0640_res_1_to_3_years_mkt_val() {
		return r0640_res_1_to_3_years_mkt_val;
	}




	public void setR0640_res_1_to_3_years_mkt_val(BigDecimal r0640_res_1_to_3_years_mkt_val) {
		this.r0640_res_1_to_3_years_mkt_val = r0640_res_1_to_3_years_mkt_val;
	}




	public BigDecimal getR0640_res_lessthan_1_year_mkt_val() {
		return r0640_res_lessthan_1_year_mkt_val;
	}




	public void setR0640_res_lessthan_1_year_mkt_val(BigDecimal r0640_res_lessthan_1_year_mkt_val) {
		this.r0640_res_lessthan_1_year_mkt_val = r0640_res_lessthan_1_year_mkt_val;
	}




	public BigDecimal getR0640_res_morethan_3_years_mkt_val() {
		return r0640_res_morethan_3_years_mkt_val;
	}




	public void setR0640_res_morethan_3_years_mkt_val(BigDecimal r0640_res_morethan_3_years_mkt_val) {
		this.r0640_res_morethan_3_years_mkt_val = r0640_res_morethan_3_years_mkt_val;
	}




	public BigDecimal getR0640_res_nat_amt() {
		return r0640_res_nat_amt;
	}




	public void setR0640_res_nat_amt(BigDecimal r0640_res_nat_amt) {
		this.r0640_res_nat_amt = r0640_res_nat_amt;
	}




	public BigDecimal getR0640_sold_hedg_net_delta_pos() {
		return r0640_sold_hedg_net_delta_pos;
	}




	public void setR0640_sold_hedg_net_delta_pos(BigDecimal r0640_sold_hedg_net_delta_pos) {
		this.r0640_sold_hedg_net_delta_pos = r0640_sold_hedg_net_delta_pos;
	}




	public BigDecimal getR0640_sold_trad_net_delta_pos() {
		return r0640_sold_trad_net_delta_pos;
	}




	public void setR0640_sold_trad_net_delta_pos(BigDecimal r0640_sold_trad_net_delta_pos) {
		this.r0640_sold_trad_net_delta_pos = r0640_sold_trad_net_delta_pos;
	}




	public BigDecimal getR0640_trad_nat_amt() {
		return r0640_trad_nat_amt;
	}




	public void setR0640_trad_nat_amt(BigDecimal r0640_trad_nat_amt) {
		this.r0640_trad_nat_amt = r0640_trad_nat_amt;
	}




	public BigDecimal getR0640_within_1_year_nat_amt() {
		return r0640_within_1_year_nat_amt;
	}




	public void setR0640_within_1_year_nat_amt(BigDecimal r0640_within_1_year_nat_amt) {
		this.r0640_within_1_year_nat_amt = r0640_within_1_year_nat_amt;
	}




	public BigDecimal getR0650_1_to_3_years_nat_amt() {
		return r0650_1_to_3_years_nat_amt;
	}




	public void setR0650_1_to_3_years_nat_amt(BigDecimal r0650_1_to_3_years_nat_amt) {
		this.r0650_1_to_3_years_nat_amt = r0650_1_to_3_years_nat_amt;
	}




	public BigDecimal getR0650_bought_hedg_net_delta_pos() {
		return r0650_bought_hedg_net_delta_pos;
	}




	public void setR0650_bought_hedg_net_delta_pos(BigDecimal r0650_bought_hedg_net_delta_pos) {
		this.r0650_bought_hedg_net_delta_pos = r0650_bought_hedg_net_delta_pos;
	}




	public BigDecimal getR0650_bought_trad_net_delta_pos() {
		return r0650_bought_trad_net_delta_pos;
	}




	public void setR0650_bought_trad_net_delta_pos(BigDecimal r0650_bought_trad_net_delta_pos) {
		this.r0650_bought_trad_net_delta_pos = r0650_bought_trad_net_delta_pos;
	}




	public BigDecimal getR0650_gross_mkt_val() {
		return r0650_gross_mkt_val;
	}




	public void setR0650_gross_mkt_val(BigDecimal r0650_gross_mkt_val) {
		this.r0650_gross_mkt_val = r0650_gross_mkt_val;
	}




	public BigDecimal getR0650_hedg_nat_amt() {
		return r0650_hedg_nat_amt;
	}




	public void setR0650_hedg_nat_amt(BigDecimal r0650_hedg_nat_amt) {
		this.r0650_hedg_nat_amt = r0650_hedg_nat_amt;
	}




	public BigDecimal getR0650_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0650_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0650_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0650_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0650_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0650_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0650_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0650_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0650_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0650_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0650_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0650_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0650_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0650_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0650_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0650_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0650_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0650_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0650_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0650_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0650_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0650_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0650_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0650_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0650_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0650_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0650_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0650_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0650_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0650_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0650_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0650_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0650_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0650_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0650_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0650_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0650_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0650_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0650_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0650_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0650_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0650_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0650_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0650_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0650_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0650_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0650_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0650_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0650_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0650_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0650_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0650_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0650_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0650_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0650_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0650_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0650_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0650_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0650_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0650_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0650_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0650_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0650_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0650_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0650_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0650_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0650_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0650_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0650_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0650_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0650_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0650_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public BigDecimal getR0650_nat_amt() {
		return r0650_nat_amt;
	}




	public void setR0650_nat_amt(BigDecimal r0650_nat_amt) {
		this.r0650_nat_amt = r0650_nat_amt;
	}




	public BigDecimal getR0650_non_res_nat_amt() {
		return r0650_non_res_nat_amt;
	}




	public void setR0650_non_res_nat_amt(BigDecimal r0650_non_res_nat_amt) {
		this.r0650_non_res_nat_amt = r0650_non_res_nat_amt;
	}




	public BigDecimal getR0650_over_3_years_nat_amt() {
		return r0650_over_3_years_nat_amt;
	}




	public void setR0650_over_3_years_nat_amt(BigDecimal r0650_over_3_years_nat_amt) {
		this.r0650_over_3_years_nat_amt = r0650_over_3_years_nat_amt;
	}




	public BigDecimal getR0650_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0650_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0650_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0650_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0650_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0650_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0650_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0650_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0650_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0650_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0650_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0650_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0650_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0650_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0650_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0650_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0650_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0650_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0650_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0650_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0650_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0650_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0650_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0650_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0650_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0650_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0650_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0650_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0650_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0650_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0650_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0650_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0650_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0650_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0650_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0650_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0650_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0650_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0650_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0650_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0650_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0650_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0650_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0650_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0650_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0650_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0650_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0650_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0650_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0650_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0650_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0650_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0650_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0650_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0650_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0650_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0650_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0650_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0650_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0650_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0650_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0650_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0650_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0650_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0650_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0650_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0650_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0650_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0650_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0650_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0650_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0650_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public String getR0650_product() {
		return r0650_product;
	}




	public void setR0650_product(String r0650_product) {
		this.r0650_product = r0650_product;
	}




	public BigDecimal getR0650_pro_bought_net_gain_loss() {
		return r0650_pro_bought_net_gain_loss;
	}




	public void setR0650_pro_bought_net_gain_loss(BigDecimal r0650_pro_bought_net_gain_loss) {
		this.r0650_pro_bought_net_gain_loss = r0650_pro_bought_net_gain_loss;
	}




	public BigDecimal getR0650_pro_sold_net_gain_loss() {
		return r0650_pro_sold_net_gain_loss;
	}




	public void setR0650_pro_sold_net_gain_loss(BigDecimal r0650_pro_sold_net_gain_loss) {
		this.r0650_pro_sold_net_gain_loss = r0650_pro_sold_net_gain_loss;
	}




	public BigDecimal getR0650_res_1_to_3_years_mkt_val() {
		return r0650_res_1_to_3_years_mkt_val;
	}




	public void setR0650_res_1_to_3_years_mkt_val(BigDecimal r0650_res_1_to_3_years_mkt_val) {
		this.r0650_res_1_to_3_years_mkt_val = r0650_res_1_to_3_years_mkt_val;
	}




	public BigDecimal getR0650_res_lessthan_1_year_mkt_val() {
		return r0650_res_lessthan_1_year_mkt_val;
	}




	public void setR0650_res_lessthan_1_year_mkt_val(BigDecimal r0650_res_lessthan_1_year_mkt_val) {
		this.r0650_res_lessthan_1_year_mkt_val = r0650_res_lessthan_1_year_mkt_val;
	}




	public BigDecimal getR0650_res_morethan_3_years_mkt_val() {
		return r0650_res_morethan_3_years_mkt_val;
	}




	public void setR0650_res_morethan_3_years_mkt_val(BigDecimal r0650_res_morethan_3_years_mkt_val) {
		this.r0650_res_morethan_3_years_mkt_val = r0650_res_morethan_3_years_mkt_val;
	}




	public BigDecimal getR0650_res_nat_amt() {
		return r0650_res_nat_amt;
	}




	public void setR0650_res_nat_amt(BigDecimal r0650_res_nat_amt) {
		this.r0650_res_nat_amt = r0650_res_nat_amt;
	}




	public BigDecimal getR0650_sold_hedg_net_delta_pos() {
		return r0650_sold_hedg_net_delta_pos;
	}




	public void setR0650_sold_hedg_net_delta_pos(BigDecimal r0650_sold_hedg_net_delta_pos) {
		this.r0650_sold_hedg_net_delta_pos = r0650_sold_hedg_net_delta_pos;
	}




	public BigDecimal getR0650_sold_trad_net_delta_pos() {
		return r0650_sold_trad_net_delta_pos;
	}




	public void setR0650_sold_trad_net_delta_pos(BigDecimal r0650_sold_trad_net_delta_pos) {
		this.r0650_sold_trad_net_delta_pos = r0650_sold_trad_net_delta_pos;
	}




	public BigDecimal getR0650_trad_nat_amt() {
		return r0650_trad_nat_amt;
	}




	public void setR0650_trad_nat_amt(BigDecimal r0650_trad_nat_amt) {
		this.r0650_trad_nat_amt = r0650_trad_nat_amt;
	}




	public BigDecimal getR0650_within_1_year_nat_amt() {
		return r0650_within_1_year_nat_amt;
	}




	public void setR0650_within_1_year_nat_amt(BigDecimal r0650_within_1_year_nat_amt) {
		this.r0650_within_1_year_nat_amt = r0650_within_1_year_nat_amt;
	}




	public BigDecimal getR0660_1_to_3_years_nat_amt() {
		return r0660_1_to_3_years_nat_amt;
	}




	public void setR0660_1_to_3_years_nat_amt(BigDecimal r0660_1_to_3_years_nat_amt) {
		this.r0660_1_to_3_years_nat_amt = r0660_1_to_3_years_nat_amt;
	}




	public BigDecimal getR0660_bought_hedg_net_delta_pos() {
		return r0660_bought_hedg_net_delta_pos;
	}




	public void setR0660_bought_hedg_net_delta_pos(BigDecimal r0660_bought_hedg_net_delta_pos) {
		this.r0660_bought_hedg_net_delta_pos = r0660_bought_hedg_net_delta_pos;
	}




	public BigDecimal getR0660_bought_trad_net_delta_pos() {
		return r0660_bought_trad_net_delta_pos;
	}




	public void setR0660_bought_trad_net_delta_pos(BigDecimal r0660_bought_trad_net_delta_pos) {
		this.r0660_bought_trad_net_delta_pos = r0660_bought_trad_net_delta_pos;
	}




	public BigDecimal getR0660_gross_mkt_val() {
		return r0660_gross_mkt_val;
	}




	public void setR0660_gross_mkt_val(BigDecimal r0660_gross_mkt_val) {
		this.r0660_gross_mkt_val = r0660_gross_mkt_val;
	}




	public BigDecimal getR0660_hedg_nat_amt() {
		return r0660_hedg_nat_amt;
	}




	public void setR0660_hedg_nat_amt(BigDecimal r0660_hedg_nat_amt) {
		this.r0660_hedg_nat_amt = r0660_hedg_nat_amt;
	}




	public BigDecimal getR0660_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0660_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0660_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0660_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0660_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0660_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0660_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0660_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0660_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0660_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0660_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0660_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0660_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0660_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0660_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0660_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0660_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0660_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0660_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0660_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0660_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0660_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0660_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0660_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0660_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0660_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0660_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0660_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0660_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0660_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0660_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0660_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0660_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0660_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0660_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0660_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0660_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0660_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0660_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0660_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0660_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0660_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0660_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0660_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0660_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0660_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0660_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0660_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0660_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0660_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0660_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0660_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0660_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0660_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0660_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0660_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0660_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0660_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0660_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0660_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0660_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0660_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0660_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0660_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0660_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0660_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0660_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0660_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0660_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0660_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0660_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0660_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public BigDecimal getR0660_nat_amt() {
		return r0660_nat_amt;
	}




	public void setR0660_nat_amt(BigDecimal r0660_nat_amt) {
		this.r0660_nat_amt = r0660_nat_amt;
	}




	public BigDecimal getR0660_non_res_nat_amt() {
		return r0660_non_res_nat_amt;
	}




	public void setR0660_non_res_nat_amt(BigDecimal r0660_non_res_nat_amt) {
		this.r0660_non_res_nat_amt = r0660_non_res_nat_amt;
	}




	public BigDecimal getR0660_over_3_years_nat_amt() {
		return r0660_over_3_years_nat_amt;
	}




	public void setR0660_over_3_years_nat_amt(BigDecimal r0660_over_3_years_nat_amt) {
		this.r0660_over_3_years_nat_amt = r0660_over_3_years_nat_amt;
	}




	public BigDecimal getR0660_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0660_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0660_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0660_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0660_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0660_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0660_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0660_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0660_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0660_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0660_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0660_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0660_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0660_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0660_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0660_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0660_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0660_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0660_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0660_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0660_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0660_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0660_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0660_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0660_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0660_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0660_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0660_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0660_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0660_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0660_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0660_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0660_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0660_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0660_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0660_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0660_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0660_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0660_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0660_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0660_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0660_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0660_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0660_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0660_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0660_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0660_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0660_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0660_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0660_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0660_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0660_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0660_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0660_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0660_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0660_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0660_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0660_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0660_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0660_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0660_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0660_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0660_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0660_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0660_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0660_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0660_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0660_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0660_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0660_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0660_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0660_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public String getR0660_product() {
		return r0660_product;
	}




	public void setR0660_product(String r0660_product) {
		this.r0660_product = r0660_product;
	}




	public BigDecimal getR0660_pro_bought_net_gain_loss() {
		return r0660_pro_bought_net_gain_loss;
	}




	public void setR0660_pro_bought_net_gain_loss(BigDecimal r0660_pro_bought_net_gain_loss) {
		this.r0660_pro_bought_net_gain_loss = r0660_pro_bought_net_gain_loss;
	}




	public BigDecimal getR0660_pro_sold_net_gain_loss() {
		return r0660_pro_sold_net_gain_loss;
	}




	public void setR0660_pro_sold_net_gain_loss(BigDecimal r0660_pro_sold_net_gain_loss) {
		this.r0660_pro_sold_net_gain_loss = r0660_pro_sold_net_gain_loss;
	}




	public BigDecimal getR0660_res_1_to_3_years_mkt_val() {
		return r0660_res_1_to_3_years_mkt_val;
	}




	public void setR0660_res_1_to_3_years_mkt_val(BigDecimal r0660_res_1_to_3_years_mkt_val) {
		this.r0660_res_1_to_3_years_mkt_val = r0660_res_1_to_3_years_mkt_val;
	}




	public BigDecimal getR0660_res_lessthan_1_year_mkt_val() {
		return r0660_res_lessthan_1_year_mkt_val;
	}




	public void setR0660_res_lessthan_1_year_mkt_val(BigDecimal r0660_res_lessthan_1_year_mkt_val) {
		this.r0660_res_lessthan_1_year_mkt_val = r0660_res_lessthan_1_year_mkt_val;
	}




	public BigDecimal getR0660_res_morethan_3_years_mkt_val() {
		return r0660_res_morethan_3_years_mkt_val;
	}




	public void setR0660_res_morethan_3_years_mkt_val(BigDecimal r0660_res_morethan_3_years_mkt_val) {
		this.r0660_res_morethan_3_years_mkt_val = r0660_res_morethan_3_years_mkt_val;
	}




	public BigDecimal getR0660_res_nat_amt() {
		return r0660_res_nat_amt;
	}




	public void setR0660_res_nat_amt(BigDecimal r0660_res_nat_amt) {
		this.r0660_res_nat_amt = r0660_res_nat_amt;
	}




	public BigDecimal getR0660_sold_hedg_net_delta_pos() {
		return r0660_sold_hedg_net_delta_pos;
	}




	public void setR0660_sold_hedg_net_delta_pos(BigDecimal r0660_sold_hedg_net_delta_pos) {
		this.r0660_sold_hedg_net_delta_pos = r0660_sold_hedg_net_delta_pos;
	}




	public BigDecimal getR0660_sold_trad_net_delta_pos() {
		return r0660_sold_trad_net_delta_pos;
	}




	public void setR0660_sold_trad_net_delta_pos(BigDecimal r0660_sold_trad_net_delta_pos) {
		this.r0660_sold_trad_net_delta_pos = r0660_sold_trad_net_delta_pos;
	}




	public BigDecimal getR0660_trad_nat_amt() {
		return r0660_trad_nat_amt;
	}




	public void setR0660_trad_nat_amt(BigDecimal r0660_trad_nat_amt) {
		this.r0660_trad_nat_amt = r0660_trad_nat_amt;
	}




	public BigDecimal getR0660_within_1_year_nat_amt() {
		return r0660_within_1_year_nat_amt;
	}




	public void setR0660_within_1_year_nat_amt(BigDecimal r0660_within_1_year_nat_amt) {
		this.r0660_within_1_year_nat_amt = r0660_within_1_year_nat_amt;
	}




	public BigDecimal getR0670_1_to_3_years_nat_amt() {
		return r0670_1_to_3_years_nat_amt;
	}




	public void setR0670_1_to_3_years_nat_amt(BigDecimal r0670_1_to_3_years_nat_amt) {
		this.r0670_1_to_3_years_nat_amt = r0670_1_to_3_years_nat_amt;
	}




	public BigDecimal getR0670_bought_hedg_net_delta_pos() {
		return r0670_bought_hedg_net_delta_pos;
	}




	public void setR0670_bought_hedg_net_delta_pos(BigDecimal r0670_bought_hedg_net_delta_pos) {
		this.r0670_bought_hedg_net_delta_pos = r0670_bought_hedg_net_delta_pos;
	}




	public BigDecimal getR0670_bought_trad_net_delta_pos() {
		return r0670_bought_trad_net_delta_pos;
	}




	public void setR0670_bought_trad_net_delta_pos(BigDecimal r0670_bought_trad_net_delta_pos) {
		this.r0670_bought_trad_net_delta_pos = r0670_bought_trad_net_delta_pos;
	}




	public BigDecimal getR0670_gross_mkt_val() {
		return r0670_gross_mkt_val;
	}




	public void setR0670_gross_mkt_val(BigDecimal r0670_gross_mkt_val) {
		this.r0670_gross_mkt_val = r0670_gross_mkt_val;
	}




	public BigDecimal getR0670_hedg_nat_amt() {
		return r0670_hedg_nat_amt;
	}




	public void setR0670_hedg_nat_amt(BigDecimal r0670_hedg_nat_amt) {
		this.r0670_hedg_nat_amt = r0670_hedg_nat_amt;
	}




	public BigDecimal getR0670_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0670_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0670_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0670_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0670_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0670_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0670_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0670_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0670_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0670_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0670_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0670_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0670_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0670_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0670_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0670_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0670_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0670_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0670_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0670_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0670_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0670_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0670_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0670_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0670_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0670_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0670_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0670_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0670_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0670_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0670_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0670_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0670_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0670_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0670_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0670_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0670_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0670_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0670_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0670_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0670_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0670_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0670_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0670_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0670_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0670_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0670_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0670_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0670_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0670_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0670_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0670_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0670_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0670_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0670_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0670_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0670_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0670_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0670_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0670_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0670_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0670_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0670_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0670_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0670_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0670_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0670_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0670_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0670_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0670_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0670_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0670_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public BigDecimal getR0670_nat_amt() {
		return r0670_nat_amt;
	}




	public void setR0670_nat_amt(BigDecimal r0670_nat_amt) {
		this.r0670_nat_amt = r0670_nat_amt;
	}




	public BigDecimal getR0670_non_res_nat_amt() {
		return r0670_non_res_nat_amt;
	}




	public void setR0670_non_res_nat_amt(BigDecimal r0670_non_res_nat_amt) {
		this.r0670_non_res_nat_amt = r0670_non_res_nat_amt;
	}




	public BigDecimal getR0670_over_3_years_nat_amt() {
		return r0670_over_3_years_nat_amt;
	}




	public void setR0670_over_3_years_nat_amt(BigDecimal r0670_over_3_years_nat_amt) {
		this.r0670_over_3_years_nat_amt = r0670_over_3_years_nat_amt;
	}




	public BigDecimal getR0670_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0670_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0670_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0670_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0670_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0670_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0670_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0670_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0670_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0670_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0670_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0670_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0670_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0670_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0670_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0670_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0670_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0670_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0670_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0670_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0670_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0670_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0670_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0670_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0670_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0670_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0670_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0670_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0670_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0670_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0670_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0670_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0670_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0670_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0670_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0670_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0670_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0670_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0670_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0670_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0670_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0670_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0670_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0670_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0670_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0670_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0670_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0670_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0670_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0670_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0670_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0670_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0670_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0670_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0670_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0670_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0670_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0670_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0670_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0670_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0670_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0670_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0670_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0670_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0670_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0670_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0670_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0670_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0670_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0670_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0670_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0670_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public String getR0670_product() {
		return r0670_product;
	}




	public void setR0670_product(String r0670_product) {
		this.r0670_product = r0670_product;
	}




	public BigDecimal getR0670_pro_bought_net_gain_loss() {
		return r0670_pro_bought_net_gain_loss;
	}




	public void setR0670_pro_bought_net_gain_loss(BigDecimal r0670_pro_bought_net_gain_loss) {
		this.r0670_pro_bought_net_gain_loss = r0670_pro_bought_net_gain_loss;
	}




	public BigDecimal getR0670_pro_sold_net_gain_loss() {
		return r0670_pro_sold_net_gain_loss;
	}




	public void setR0670_pro_sold_net_gain_loss(BigDecimal r0670_pro_sold_net_gain_loss) {
		this.r0670_pro_sold_net_gain_loss = r0670_pro_sold_net_gain_loss;
	}




	public BigDecimal getR0670_res_1_to_3_years_mkt_val() {
		return r0670_res_1_to_3_years_mkt_val;
	}




	public void setR0670_res_1_to_3_years_mkt_val(BigDecimal r0670_res_1_to_3_years_mkt_val) {
		this.r0670_res_1_to_3_years_mkt_val = r0670_res_1_to_3_years_mkt_val;
	}




	public BigDecimal getR0670_res_lessthan_1_year_mkt_val() {
		return r0670_res_lessthan_1_year_mkt_val;
	}




	public void setR0670_res_lessthan_1_year_mkt_val(BigDecimal r0670_res_lessthan_1_year_mkt_val) {
		this.r0670_res_lessthan_1_year_mkt_val = r0670_res_lessthan_1_year_mkt_val;
	}




	public BigDecimal getR0670_res_morethan_3_years_mkt_val() {
		return r0670_res_morethan_3_years_mkt_val;
	}




	public void setR0670_res_morethan_3_years_mkt_val(BigDecimal r0670_res_morethan_3_years_mkt_val) {
		this.r0670_res_morethan_3_years_mkt_val = r0670_res_morethan_3_years_mkt_val;
	}




	public BigDecimal getR0670_res_nat_amt() {
		return r0670_res_nat_amt;
	}




	public void setR0670_res_nat_amt(BigDecimal r0670_res_nat_amt) {
		this.r0670_res_nat_amt = r0670_res_nat_amt;
	}




	public BigDecimal getR0670_sold_hedg_net_delta_pos() {
		return r0670_sold_hedg_net_delta_pos;
	}




	public void setR0670_sold_hedg_net_delta_pos(BigDecimal r0670_sold_hedg_net_delta_pos) {
		this.r0670_sold_hedg_net_delta_pos = r0670_sold_hedg_net_delta_pos;
	}




	public BigDecimal getR0670_sold_trad_net_delta_pos() {
		return r0670_sold_trad_net_delta_pos;
	}




	public void setR0670_sold_trad_net_delta_pos(BigDecimal r0670_sold_trad_net_delta_pos) {
		this.r0670_sold_trad_net_delta_pos = r0670_sold_trad_net_delta_pos;
	}




	public BigDecimal getR0670_trad_nat_amt() {
		return r0670_trad_nat_amt;
	}




	public void setR0670_trad_nat_amt(BigDecimal r0670_trad_nat_amt) {
		this.r0670_trad_nat_amt = r0670_trad_nat_amt;
	}




	public BigDecimal getR0670_within_1_year_nat_amt() {
		return r0670_within_1_year_nat_amt;
	}




	public void setR0670_within_1_year_nat_amt(BigDecimal r0670_within_1_year_nat_amt) {
		this.r0670_within_1_year_nat_amt = r0670_within_1_year_nat_amt;
	}




	public String getR0680_product() {
		return r0680_product;
	}




	public void setR0680_product(String r0680_product) {
		this.r0680_product = r0680_product;
	}




	public BigDecimal getR0690_1_to_3_years_nat_amt() {
		return r0690_1_to_3_years_nat_amt;
	}




	public void setR0690_1_to_3_years_nat_amt(BigDecimal r0690_1_to_3_years_nat_amt) {
		this.r0690_1_to_3_years_nat_amt = r0690_1_to_3_years_nat_amt;
	}




	public BigDecimal getR0690_bought_hedg_net_delta_pos() {
		return r0690_bought_hedg_net_delta_pos;
	}




	public void setR0690_bought_hedg_net_delta_pos(BigDecimal r0690_bought_hedg_net_delta_pos) {
		this.r0690_bought_hedg_net_delta_pos = r0690_bought_hedg_net_delta_pos;
	}




	public BigDecimal getR0690_bought_trad_net_delta_pos() {
		return r0690_bought_trad_net_delta_pos;
	}




	public void setR0690_bought_trad_net_delta_pos(BigDecimal r0690_bought_trad_net_delta_pos) {
		this.r0690_bought_trad_net_delta_pos = r0690_bought_trad_net_delta_pos;
	}




	public BigDecimal getR0690_gross_mkt_val() {
		return r0690_gross_mkt_val;
	}




	public void setR0690_gross_mkt_val(BigDecimal r0690_gross_mkt_val) {
		this.r0690_gross_mkt_val = r0690_gross_mkt_val;
	}




	public BigDecimal getR0690_hedg_nat_amt() {
		return r0690_hedg_nat_amt;
	}




	public void setR0690_hedg_nat_amt(BigDecimal r0690_hedg_nat_amt) {
		this.r0690_hedg_nat_amt = r0690_hedg_nat_amt;
	}




	public BigDecimal getR0690_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0690_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0690_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0690_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0690_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0690_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0690_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0690_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0690_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0690_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0690_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0690_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0690_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0690_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0690_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0690_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0690_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0690_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0690_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0690_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0690_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0690_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0690_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0690_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0690_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0690_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0690_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0690_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0690_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0690_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0690_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0690_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0690_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0690_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0690_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0690_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0690_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0690_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0690_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0690_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0690_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0690_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0690_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0690_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0690_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0690_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0690_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0690_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0690_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0690_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0690_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0690_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0690_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0690_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0690_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0690_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0690_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0690_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0690_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0690_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0690_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0690_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0690_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0690_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0690_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0690_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0690_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0690_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0690_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0690_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0690_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0690_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public BigDecimal getR0690_nat_amt() {
		return r0690_nat_amt;
	}




	public void setR0690_nat_amt(BigDecimal r0690_nat_amt) {
		this.r0690_nat_amt = r0690_nat_amt;
	}




	public BigDecimal getR0690_non_res_nat_amt() {
		return r0690_non_res_nat_amt;
	}




	public void setR0690_non_res_nat_amt(BigDecimal r0690_non_res_nat_amt) {
		this.r0690_non_res_nat_amt = r0690_non_res_nat_amt;
	}




	public BigDecimal getR0690_over_3_years_nat_amt() {
		return r0690_over_3_years_nat_amt;
	}




	public void setR0690_over_3_years_nat_amt(BigDecimal r0690_over_3_years_nat_amt) {
		this.r0690_over_3_years_nat_amt = r0690_over_3_years_nat_amt;
	}




	public BigDecimal getR0690_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0690_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0690_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0690_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0690_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0690_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0690_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0690_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0690_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0690_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0690_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0690_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0690_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0690_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0690_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0690_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0690_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0690_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0690_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0690_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0690_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0690_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0690_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0690_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0690_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0690_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0690_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0690_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0690_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0690_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0690_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0690_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0690_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0690_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0690_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0690_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0690_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0690_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0690_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0690_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0690_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0690_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0690_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0690_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0690_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0690_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0690_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0690_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0690_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0690_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0690_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0690_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0690_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0690_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0690_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0690_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0690_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0690_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0690_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0690_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0690_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0690_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0690_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0690_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0690_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0690_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0690_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0690_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0690_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0690_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0690_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0690_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public String getR0690_product() {
		return r0690_product;
	}




	public void setR0690_product(String r0690_product) {
		this.r0690_product = r0690_product;
	}




	public BigDecimal getR0690_pro_bought_net_gain_loss() {
		return r0690_pro_bought_net_gain_loss;
	}




	public void setR0690_pro_bought_net_gain_loss(BigDecimal r0690_pro_bought_net_gain_loss) {
		this.r0690_pro_bought_net_gain_loss = r0690_pro_bought_net_gain_loss;
	}




	public BigDecimal getR0690_pro_sold_net_gain_loss() {
		return r0690_pro_sold_net_gain_loss;
	}




	public void setR0690_pro_sold_net_gain_loss(BigDecimal r0690_pro_sold_net_gain_loss) {
		this.r0690_pro_sold_net_gain_loss = r0690_pro_sold_net_gain_loss;
	}




	public BigDecimal getR0690_res_1_to_3_years_mkt_val() {
		return r0690_res_1_to_3_years_mkt_val;
	}




	public void setR0690_res_1_to_3_years_mkt_val(BigDecimal r0690_res_1_to_3_years_mkt_val) {
		this.r0690_res_1_to_3_years_mkt_val = r0690_res_1_to_3_years_mkt_val;
	}




	public BigDecimal getR0690_res_lessthan_1_year_mkt_val() {
		return r0690_res_lessthan_1_year_mkt_val;
	}




	public void setR0690_res_lessthan_1_year_mkt_val(BigDecimal r0690_res_lessthan_1_year_mkt_val) {
		this.r0690_res_lessthan_1_year_mkt_val = r0690_res_lessthan_1_year_mkt_val;
	}




	public BigDecimal getR0690_res_morethan_3_years_mkt_val() {
		return r0690_res_morethan_3_years_mkt_val;
	}




	public void setR0690_res_morethan_3_years_mkt_val(BigDecimal r0690_res_morethan_3_years_mkt_val) {
		this.r0690_res_morethan_3_years_mkt_val = r0690_res_morethan_3_years_mkt_val;
	}




	public BigDecimal getR0690_res_nat_amt() {
		return r0690_res_nat_amt;
	}




	public void setR0690_res_nat_amt(BigDecimal r0690_res_nat_amt) {
		this.r0690_res_nat_amt = r0690_res_nat_amt;
	}




	public BigDecimal getR0690_sold_hedg_net_delta_pos() {
		return r0690_sold_hedg_net_delta_pos;
	}




	public void setR0690_sold_hedg_net_delta_pos(BigDecimal r0690_sold_hedg_net_delta_pos) {
		this.r0690_sold_hedg_net_delta_pos = r0690_sold_hedg_net_delta_pos;
	}




	public BigDecimal getR0690_sold_trad_net_delta_pos() {
		return r0690_sold_trad_net_delta_pos;
	}




	public void setR0690_sold_trad_net_delta_pos(BigDecimal r0690_sold_trad_net_delta_pos) {
		this.r0690_sold_trad_net_delta_pos = r0690_sold_trad_net_delta_pos;
	}




	public BigDecimal getR0690_trad_nat_amt() {
		return r0690_trad_nat_amt;
	}




	public void setR0690_trad_nat_amt(BigDecimal r0690_trad_nat_amt) {
		this.r0690_trad_nat_amt = r0690_trad_nat_amt;
	}




	public BigDecimal getR0690_within_1_year_nat_amt() {
		return r0690_within_1_year_nat_amt;
	}




	public void setR0690_within_1_year_nat_amt(BigDecimal r0690_within_1_year_nat_amt) {
		this.r0690_within_1_year_nat_amt = r0690_within_1_year_nat_amt;
	}




	public String getR0700_product() {
		return r0700_product;
	}




	public void setR0700_product(String r0700_product) {
		this.r0700_product = r0700_product;
	}




	public BigDecimal getR0710_1_to_3_years_nat_amt() {
		return r0710_1_to_3_years_nat_amt;
	}




	public void setR0710_1_to_3_years_nat_amt(BigDecimal r0710_1_to_3_years_nat_amt) {
		this.r0710_1_to_3_years_nat_amt = r0710_1_to_3_years_nat_amt;
	}




	public BigDecimal getR0710_bought_hedg_net_delta_pos() {
		return r0710_bought_hedg_net_delta_pos;
	}




	public void setR0710_bought_hedg_net_delta_pos(BigDecimal r0710_bought_hedg_net_delta_pos) {
		this.r0710_bought_hedg_net_delta_pos = r0710_bought_hedg_net_delta_pos;
	}




	public BigDecimal getR0710_bought_trad_net_delta_pos() {
		return r0710_bought_trad_net_delta_pos;
	}




	public void setR0710_bought_trad_net_delta_pos(BigDecimal r0710_bought_trad_net_delta_pos) {
		this.r0710_bought_trad_net_delta_pos = r0710_bought_trad_net_delta_pos;
	}




	public BigDecimal getR0710_gross_mkt_val() {
		return r0710_gross_mkt_val;
	}




	public void setR0710_gross_mkt_val(BigDecimal r0710_gross_mkt_val) {
		this.r0710_gross_mkt_val = r0710_gross_mkt_val;
	}




	public BigDecimal getR0710_hedg_nat_amt() {
		return r0710_hedg_nat_amt;
	}




	public void setR0710_hedg_nat_amt(BigDecimal r0710_hedg_nat_amt) {
		this.r0710_hedg_nat_amt = r0710_hedg_nat_amt;
	}




	public BigDecimal getR0710_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0710_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0710_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0710_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0710_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0710_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0710_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0710_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0710_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0710_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0710_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0710_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0710_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0710_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0710_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0710_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0710_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0710_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0710_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0710_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0710_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0710_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0710_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0710_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0710_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0710_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0710_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0710_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0710_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0710_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0710_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0710_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0710_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0710_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0710_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0710_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0710_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0710_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0710_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0710_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0710_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0710_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0710_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0710_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0710_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0710_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0710_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0710_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0710_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0710_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0710_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0710_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0710_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0710_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0710_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0710_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0710_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0710_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0710_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0710_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0710_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0710_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0710_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0710_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0710_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0710_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0710_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0710_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0710_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0710_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0710_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0710_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public BigDecimal getR0710_nat_amt() {
		return r0710_nat_amt;
	}




	public void setR0710_nat_amt(BigDecimal r0710_nat_amt) {
		this.r0710_nat_amt = r0710_nat_amt;
	}




	public BigDecimal getR0710_non_res_nat_amt() {
		return r0710_non_res_nat_amt;
	}




	public void setR0710_non_res_nat_amt(BigDecimal r0710_non_res_nat_amt) {
		this.r0710_non_res_nat_amt = r0710_non_res_nat_amt;
	}




	public BigDecimal getR0710_over_3_years_nat_amt() {
		return r0710_over_3_years_nat_amt;
	}




	public void setR0710_over_3_years_nat_amt(BigDecimal r0710_over_3_years_nat_amt) {
		this.r0710_over_3_years_nat_amt = r0710_over_3_years_nat_amt;
	}




	public BigDecimal getR0710_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0710_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0710_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0710_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0710_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0710_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0710_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0710_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0710_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0710_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0710_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0710_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0710_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0710_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0710_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0710_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0710_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0710_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0710_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0710_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0710_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0710_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0710_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0710_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0710_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0710_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0710_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0710_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0710_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0710_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0710_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0710_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0710_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0710_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0710_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0710_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0710_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0710_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0710_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0710_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0710_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0710_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0710_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0710_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0710_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0710_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0710_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0710_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0710_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0710_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0710_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0710_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0710_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0710_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0710_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0710_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0710_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0710_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0710_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0710_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0710_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0710_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0710_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0710_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0710_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0710_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0710_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0710_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0710_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0710_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0710_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0710_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public String getR0710_product() {
		return r0710_product;
	}




	public void setR0710_product(String r0710_product) {
		this.r0710_product = r0710_product;
	}




	public BigDecimal getR0710_pro_bought_net_gain_loss() {
		return r0710_pro_bought_net_gain_loss;
	}




	public void setR0710_pro_bought_net_gain_loss(BigDecimal r0710_pro_bought_net_gain_loss) {
		this.r0710_pro_bought_net_gain_loss = r0710_pro_bought_net_gain_loss;
	}




	public BigDecimal getR0710_pro_sold_net_gain_loss() {
		return r0710_pro_sold_net_gain_loss;
	}




	public void setR0710_pro_sold_net_gain_loss(BigDecimal r0710_pro_sold_net_gain_loss) {
		this.r0710_pro_sold_net_gain_loss = r0710_pro_sold_net_gain_loss;
	}




	public BigDecimal getR0710_res_1_to_3_years_mkt_val() {
		return r0710_res_1_to_3_years_mkt_val;
	}




	public void setR0710_res_1_to_3_years_mkt_val(BigDecimal r0710_res_1_to_3_years_mkt_val) {
		this.r0710_res_1_to_3_years_mkt_val = r0710_res_1_to_3_years_mkt_val;
	}




	public BigDecimal getR0710_res_lessthan_1_year_mkt_val() {
		return r0710_res_lessthan_1_year_mkt_val;
	}




	public void setR0710_res_lessthan_1_year_mkt_val(BigDecimal r0710_res_lessthan_1_year_mkt_val) {
		this.r0710_res_lessthan_1_year_mkt_val = r0710_res_lessthan_1_year_mkt_val;
	}




	public BigDecimal getR0710_res_morethan_3_years_mkt_val() {
		return r0710_res_morethan_3_years_mkt_val;
	}




	public void setR0710_res_morethan_3_years_mkt_val(BigDecimal r0710_res_morethan_3_years_mkt_val) {
		this.r0710_res_morethan_3_years_mkt_val = r0710_res_morethan_3_years_mkt_val;
	}




	public BigDecimal getR0710_res_nat_amt() {
		return r0710_res_nat_amt;
	}




	public void setR0710_res_nat_amt(BigDecimal r0710_res_nat_amt) {
		this.r0710_res_nat_amt = r0710_res_nat_amt;
	}




	public BigDecimal getR0710_sold_hedg_net_delta_pos() {
		return r0710_sold_hedg_net_delta_pos;
	}




	public void setR0710_sold_hedg_net_delta_pos(BigDecimal r0710_sold_hedg_net_delta_pos) {
		this.r0710_sold_hedg_net_delta_pos = r0710_sold_hedg_net_delta_pos;
	}




	public BigDecimal getR0710_sold_trad_net_delta_pos() {
		return r0710_sold_trad_net_delta_pos;
	}




	public void setR0710_sold_trad_net_delta_pos(BigDecimal r0710_sold_trad_net_delta_pos) {
		this.r0710_sold_trad_net_delta_pos = r0710_sold_trad_net_delta_pos;
	}




	public BigDecimal getR0710_trad_nat_amt() {
		return r0710_trad_nat_amt;
	}




	public void setR0710_trad_nat_amt(BigDecimal r0710_trad_nat_amt) {
		this.r0710_trad_nat_amt = r0710_trad_nat_amt;
	}




	public BigDecimal getR0710_within_1_year_nat_amt() {
		return r0710_within_1_year_nat_amt;
	}




	public void setR0710_within_1_year_nat_amt(BigDecimal r0710_within_1_year_nat_amt) {
		this.r0710_within_1_year_nat_amt = r0710_within_1_year_nat_amt;
	}




	public String getR0720_product() {
		return r0720_product;
	}




	public void setR0720_product(String r0720_product) {
		this.r0720_product = r0720_product;
	}




	public BigDecimal getR0730_1_to_3_years_nat_amt() {
		return r0730_1_to_3_years_nat_amt;
	}




	public void setR0730_1_to_3_years_nat_amt(BigDecimal r0730_1_to_3_years_nat_amt) {
		this.r0730_1_to_3_years_nat_amt = r0730_1_to_3_years_nat_amt;
	}




	public BigDecimal getR0730_bought_hedg_net_delta_pos() {
		return r0730_bought_hedg_net_delta_pos;
	}




	public void setR0730_bought_hedg_net_delta_pos(BigDecimal r0730_bought_hedg_net_delta_pos) {
		this.r0730_bought_hedg_net_delta_pos = r0730_bought_hedg_net_delta_pos;
	}




	public BigDecimal getR0730_bought_trad_net_delta_pos() {
		return r0730_bought_trad_net_delta_pos;
	}




	public void setR0730_bought_trad_net_delta_pos(BigDecimal r0730_bought_trad_net_delta_pos) {
		this.r0730_bought_trad_net_delta_pos = r0730_bought_trad_net_delta_pos;
	}




	public BigDecimal getR0730_gross_mkt_val() {
		return r0730_gross_mkt_val;
	}




	public void setR0730_gross_mkt_val(BigDecimal r0730_gross_mkt_val) {
		this.r0730_gross_mkt_val = r0730_gross_mkt_val;
	}




	public BigDecimal getR0730_hedg_nat_amt() {
		return r0730_hedg_nat_amt;
	}




	public void setR0730_hedg_nat_amt(BigDecimal r0730_hedg_nat_amt) {
		this.r0730_hedg_nat_amt = r0730_hedg_nat_amt;
	}




	public BigDecimal getR0730_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0730_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0730_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0730_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0730_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0730_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0730_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0730_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0730_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0730_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0730_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0730_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0730_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0730_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0730_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0730_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0730_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0730_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0730_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0730_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0730_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0730_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0730_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0730_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0730_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0730_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0730_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0730_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0730_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0730_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0730_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0730_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0730_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0730_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0730_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0730_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0730_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0730_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0730_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0730_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0730_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0730_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0730_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0730_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0730_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0730_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0730_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0730_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0730_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0730_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0730_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0730_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0730_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0730_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0730_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0730_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0730_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0730_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0730_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0730_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0730_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0730_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0730_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0730_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0730_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0730_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0730_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0730_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0730_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0730_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0730_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0730_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public BigDecimal getR0730_nat_amt() {
		return r0730_nat_amt;
	}




	public void setR0730_nat_amt(BigDecimal r0730_nat_amt) {
		this.r0730_nat_amt = r0730_nat_amt;
	}




	public BigDecimal getR0730_non_res_nat_amt() {
		return r0730_non_res_nat_amt;
	}




	public void setR0730_non_res_nat_amt(BigDecimal r0730_non_res_nat_amt) {
		this.r0730_non_res_nat_amt = r0730_non_res_nat_amt;
	}




	public BigDecimal getR0730_over_3_years_nat_amt() {
		return r0730_over_3_years_nat_amt;
	}




	public void setR0730_over_3_years_nat_amt(BigDecimal r0730_over_3_years_nat_amt) {
		this.r0730_over_3_years_nat_amt = r0730_over_3_years_nat_amt;
	}




	public BigDecimal getR0730_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0730_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0730_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0730_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0730_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0730_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0730_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0730_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0730_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0730_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0730_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0730_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0730_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0730_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0730_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0730_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0730_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0730_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0730_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0730_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0730_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0730_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0730_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0730_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0730_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0730_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0730_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0730_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0730_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0730_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0730_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0730_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0730_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0730_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0730_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0730_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0730_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0730_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0730_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0730_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0730_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0730_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0730_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0730_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0730_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0730_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0730_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0730_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0730_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0730_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0730_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0730_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0730_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0730_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0730_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0730_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0730_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0730_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0730_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0730_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0730_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0730_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0730_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0730_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0730_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0730_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0730_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0730_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0730_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0730_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0730_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0730_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public String getR0730_product() {
		return r0730_product;
	}




	public void setR0730_product(String r0730_product) {
		this.r0730_product = r0730_product;
	}




	public BigDecimal getR0730_pro_bought_net_gain_loss() {
		return r0730_pro_bought_net_gain_loss;
	}




	public void setR0730_pro_bought_net_gain_loss(BigDecimal r0730_pro_bought_net_gain_loss) {
		this.r0730_pro_bought_net_gain_loss = r0730_pro_bought_net_gain_loss;
	}




	public BigDecimal getR0730_pro_sold_net_gain_loss() {
		return r0730_pro_sold_net_gain_loss;
	}




	public void setR0730_pro_sold_net_gain_loss(BigDecimal r0730_pro_sold_net_gain_loss) {
		this.r0730_pro_sold_net_gain_loss = r0730_pro_sold_net_gain_loss;
	}




	public BigDecimal getR0730_res_1_to_3_years_mkt_val() {
		return r0730_res_1_to_3_years_mkt_val;
	}




	public void setR0730_res_1_to_3_years_mkt_val(BigDecimal r0730_res_1_to_3_years_mkt_val) {
		this.r0730_res_1_to_3_years_mkt_val = r0730_res_1_to_3_years_mkt_val;
	}




	public BigDecimal getR0730_res_lessthan_1_year_mkt_val() {
		return r0730_res_lessthan_1_year_mkt_val;
	}




	public void setR0730_res_lessthan_1_year_mkt_val(BigDecimal r0730_res_lessthan_1_year_mkt_val) {
		this.r0730_res_lessthan_1_year_mkt_val = r0730_res_lessthan_1_year_mkt_val;
	}




	public BigDecimal getR0730_res_morethan_3_years_mkt_val() {
		return r0730_res_morethan_3_years_mkt_val;
	}




	public void setR0730_res_morethan_3_years_mkt_val(BigDecimal r0730_res_morethan_3_years_mkt_val) {
		this.r0730_res_morethan_3_years_mkt_val = r0730_res_morethan_3_years_mkt_val;
	}




	public BigDecimal getR0730_res_nat_amt() {
		return r0730_res_nat_amt;
	}




	public void setR0730_res_nat_amt(BigDecimal r0730_res_nat_amt) {
		this.r0730_res_nat_amt = r0730_res_nat_amt;
	}




	public BigDecimal getR0730_sold_hedg_net_delta_pos() {
		return r0730_sold_hedg_net_delta_pos;
	}




	public void setR0730_sold_hedg_net_delta_pos(BigDecimal r0730_sold_hedg_net_delta_pos) {
		this.r0730_sold_hedg_net_delta_pos = r0730_sold_hedg_net_delta_pos;
	}




	public BigDecimal getR0730_sold_trad_net_delta_pos() {
		return r0730_sold_trad_net_delta_pos;
	}




	public void setR0730_sold_trad_net_delta_pos(BigDecimal r0730_sold_trad_net_delta_pos) {
		this.r0730_sold_trad_net_delta_pos = r0730_sold_trad_net_delta_pos;
	}




	public BigDecimal getR0730_trad_nat_amt() {
		return r0730_trad_nat_amt;
	}




	public void setR0730_trad_nat_amt(BigDecimal r0730_trad_nat_amt) {
		this.r0730_trad_nat_amt = r0730_trad_nat_amt;
	}




	public BigDecimal getR0730_within_1_year_nat_amt() {
		return r0730_within_1_year_nat_amt;
	}




	public void setR0730_within_1_year_nat_amt(BigDecimal r0730_within_1_year_nat_amt) {
		this.r0730_within_1_year_nat_amt = r0730_within_1_year_nat_amt;
	}




	public String getR0740_product() {
		return r0740_product;
	}




	public void setR0740_product(String r0740_product) {
		this.r0740_product = r0740_product;
	}




	public String getR0750_product() {
		return r0750_product;
	}




	public void setR0750_product(String r0750_product) {
		this.r0750_product = r0750_product;
	}




	public BigDecimal getR0760_1_to_3_years_nat_amt() {
		return r0760_1_to_3_years_nat_amt;
	}




	public void setR0760_1_to_3_years_nat_amt(BigDecimal r0760_1_to_3_years_nat_amt) {
		this.r0760_1_to_3_years_nat_amt = r0760_1_to_3_years_nat_amt;
	}




	public BigDecimal getR0760_bought_hedg_net_delta_pos() {
		return r0760_bought_hedg_net_delta_pos;
	}




	public void setR0760_bought_hedg_net_delta_pos(BigDecimal r0760_bought_hedg_net_delta_pos) {
		this.r0760_bought_hedg_net_delta_pos = r0760_bought_hedg_net_delta_pos;
	}




	public BigDecimal getR0760_bought_trad_net_delta_pos() {
		return r0760_bought_trad_net_delta_pos;
	}




	public void setR0760_bought_trad_net_delta_pos(BigDecimal r0760_bought_trad_net_delta_pos) {
		this.r0760_bought_trad_net_delta_pos = r0760_bought_trad_net_delta_pos;
	}




	public BigDecimal getR0760_gross_mkt_val() {
		return r0760_gross_mkt_val;
	}




	public void setR0760_gross_mkt_val(BigDecimal r0760_gross_mkt_val) {
		this.r0760_gross_mkt_val = r0760_gross_mkt_val;
	}




	public BigDecimal getR0760_hedg_nat_amt() {
		return r0760_hedg_nat_amt;
	}




	public void setR0760_hedg_nat_amt(BigDecimal r0760_hedg_nat_amt) {
		this.r0760_hedg_nat_amt = r0760_hedg_nat_amt;
	}




	public BigDecimal getR0760_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0760_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0760_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0760_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0760_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0760_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0760_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0760_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0760_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0760_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0760_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0760_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0760_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0760_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0760_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0760_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0760_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0760_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0760_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0760_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0760_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0760_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0760_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0760_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0760_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0760_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0760_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0760_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0760_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0760_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0760_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0760_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0760_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0760_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0760_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0760_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0760_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0760_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0760_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0760_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0760_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0760_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0760_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0760_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0760_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0760_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0760_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0760_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0760_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0760_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0760_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0760_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0760_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0760_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0760_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0760_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0760_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0760_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0760_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0760_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0760_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0760_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0760_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0760_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0760_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0760_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0760_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0760_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0760_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0760_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0760_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0760_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public BigDecimal getR0760_nat_amt() {
		return r0760_nat_amt;
	}




	public void setR0760_nat_amt(BigDecimal r0760_nat_amt) {
		this.r0760_nat_amt = r0760_nat_amt;
	}




	public BigDecimal getR0760_non_res_nat_amt() {
		return r0760_non_res_nat_amt;
	}




	public void setR0760_non_res_nat_amt(BigDecimal r0760_non_res_nat_amt) {
		this.r0760_non_res_nat_amt = r0760_non_res_nat_amt;
	}




	public BigDecimal getR0760_over_3_years_nat_amt() {
		return r0760_over_3_years_nat_amt;
	}




	public void setR0760_over_3_years_nat_amt(BigDecimal r0760_over_3_years_nat_amt) {
		this.r0760_over_3_years_nat_amt = r0760_over_3_years_nat_amt;
	}




	public BigDecimal getR0760_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0760_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0760_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0760_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0760_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0760_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0760_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0760_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0760_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0760_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0760_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0760_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0760_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0760_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0760_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0760_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0760_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0760_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0760_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0760_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0760_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0760_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0760_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0760_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0760_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0760_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0760_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0760_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0760_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0760_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0760_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0760_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0760_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0760_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0760_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0760_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0760_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0760_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0760_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0760_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0760_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0760_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0760_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0760_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0760_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0760_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0760_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0760_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0760_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0760_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0760_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0760_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0760_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0760_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0760_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0760_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0760_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0760_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0760_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0760_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0760_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0760_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0760_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0760_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0760_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0760_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0760_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0760_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0760_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0760_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0760_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0760_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public String getR0760_product() {
		return r0760_product;
	}




	public void setR0760_product(String r0760_product) {
		this.r0760_product = r0760_product;
	}




	public BigDecimal getR0760_pro_bought_net_gain_loss() {
		return r0760_pro_bought_net_gain_loss;
	}




	public void setR0760_pro_bought_net_gain_loss(BigDecimal r0760_pro_bought_net_gain_loss) {
		this.r0760_pro_bought_net_gain_loss = r0760_pro_bought_net_gain_loss;
	}




	public BigDecimal getR0760_pro_sold_net_gain_loss() {
		return r0760_pro_sold_net_gain_loss;
	}




	public void setR0760_pro_sold_net_gain_loss(BigDecimal r0760_pro_sold_net_gain_loss) {
		this.r0760_pro_sold_net_gain_loss = r0760_pro_sold_net_gain_loss;
	}




	public BigDecimal getR0760_res_1_to_3_years_mkt_val() {
		return r0760_res_1_to_3_years_mkt_val;
	}




	public void setR0760_res_1_to_3_years_mkt_val(BigDecimal r0760_res_1_to_3_years_mkt_val) {
		this.r0760_res_1_to_3_years_mkt_val = r0760_res_1_to_3_years_mkt_val;
	}




	public BigDecimal getR0760_res_lessthan_1_year_mkt_val() {
		return r0760_res_lessthan_1_year_mkt_val;
	}




	public void setR0760_res_lessthan_1_year_mkt_val(BigDecimal r0760_res_lessthan_1_year_mkt_val) {
		this.r0760_res_lessthan_1_year_mkt_val = r0760_res_lessthan_1_year_mkt_val;
	}




	public BigDecimal getR0760_res_morethan_3_years_mkt_val() {
		return r0760_res_morethan_3_years_mkt_val;
	}




	public void setR0760_res_morethan_3_years_mkt_val(BigDecimal r0760_res_morethan_3_years_mkt_val) {
		this.r0760_res_morethan_3_years_mkt_val = r0760_res_morethan_3_years_mkt_val;
	}




	public BigDecimal getR0760_res_nat_amt() {
		return r0760_res_nat_amt;
	}




	public void setR0760_res_nat_amt(BigDecimal r0760_res_nat_amt) {
		this.r0760_res_nat_amt = r0760_res_nat_amt;
	}




	public BigDecimal getR0760_sold_hedg_net_delta_pos() {
		return r0760_sold_hedg_net_delta_pos;
	}




	public void setR0760_sold_hedg_net_delta_pos(BigDecimal r0760_sold_hedg_net_delta_pos) {
		this.r0760_sold_hedg_net_delta_pos = r0760_sold_hedg_net_delta_pos;
	}




	public BigDecimal getR0760_sold_trad_net_delta_pos() {
		return r0760_sold_trad_net_delta_pos;
	}




	public void setR0760_sold_trad_net_delta_pos(BigDecimal r0760_sold_trad_net_delta_pos) {
		this.r0760_sold_trad_net_delta_pos = r0760_sold_trad_net_delta_pos;
	}




	public BigDecimal getR0760_trad_nat_amt() {
		return r0760_trad_nat_amt;
	}




	public void setR0760_trad_nat_amt(BigDecimal r0760_trad_nat_amt) {
		this.r0760_trad_nat_amt = r0760_trad_nat_amt;
	}




	public BigDecimal getR0760_within_1_year_nat_amt() {
		return r0760_within_1_year_nat_amt;
	}




	public void setR0760_within_1_year_nat_amt(BigDecimal r0760_within_1_year_nat_amt) {
		this.r0760_within_1_year_nat_amt = r0760_within_1_year_nat_amt;
	}




	public BigDecimal getR0770_1_to_3_years_nat_amt() {
		return r0770_1_to_3_years_nat_amt;
	}




	public void setR0770_1_to_3_years_nat_amt(BigDecimal r0770_1_to_3_years_nat_amt) {
		this.r0770_1_to_3_years_nat_amt = r0770_1_to_3_years_nat_amt;
	}




	public BigDecimal getR0770_bought_hedg_net_delta_pos() {
		return r0770_bought_hedg_net_delta_pos;
	}




	public void setR0770_bought_hedg_net_delta_pos(BigDecimal r0770_bought_hedg_net_delta_pos) {
		this.r0770_bought_hedg_net_delta_pos = r0770_bought_hedg_net_delta_pos;
	}




	public BigDecimal getR0770_bought_trad_net_delta_pos() {
		return r0770_bought_trad_net_delta_pos;
	}




	public void setR0770_bought_trad_net_delta_pos(BigDecimal r0770_bought_trad_net_delta_pos) {
		this.r0770_bought_trad_net_delta_pos = r0770_bought_trad_net_delta_pos;
	}




	public BigDecimal getR0770_gross_mkt_val() {
		return r0770_gross_mkt_val;
	}




	public void setR0770_gross_mkt_val(BigDecimal r0770_gross_mkt_val) {
		this.r0770_gross_mkt_val = r0770_gross_mkt_val;
	}




	public BigDecimal getR0770_hedg_nat_amt() {
		return r0770_hedg_nat_amt;
	}




	public void setR0770_hedg_nat_amt(BigDecimal r0770_hedg_nat_amt) {
		this.r0770_hedg_nat_amt = r0770_hedg_nat_amt;
	}




	public BigDecimal getR0770_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0770_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0770_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0770_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0770_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0770_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0770_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0770_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0770_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0770_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0770_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0770_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0770_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0770_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0770_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0770_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0770_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0770_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0770_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0770_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0770_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0770_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0770_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0770_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0770_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0770_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0770_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0770_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0770_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0770_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0770_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0770_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0770_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0770_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0770_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0770_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0770_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0770_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0770_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0770_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0770_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0770_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0770_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0770_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0770_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0770_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0770_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0770_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0770_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0770_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0770_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0770_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0770_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0770_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0770_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0770_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0770_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0770_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0770_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0770_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0770_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0770_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0770_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0770_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0770_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0770_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0770_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0770_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0770_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0770_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0770_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0770_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public BigDecimal getR0770_nat_amt() {
		return r0770_nat_amt;
	}




	public void setR0770_nat_amt(BigDecimal r0770_nat_amt) {
		this.r0770_nat_amt = r0770_nat_amt;
	}




	public BigDecimal getR0770_non_res_nat_amt() {
		return r0770_non_res_nat_amt;
	}




	public void setR0770_non_res_nat_amt(BigDecimal r0770_non_res_nat_amt) {
		this.r0770_non_res_nat_amt = r0770_non_res_nat_amt;
	}




	public BigDecimal getR0770_over_3_years_nat_amt() {
		return r0770_over_3_years_nat_amt;
	}




	public void setR0770_over_3_years_nat_amt(BigDecimal r0770_over_3_years_nat_amt) {
		this.r0770_over_3_years_nat_amt = r0770_over_3_years_nat_amt;
	}




	public BigDecimal getR0770_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0770_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0770_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0770_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0770_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0770_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0770_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0770_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0770_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0770_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0770_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0770_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0770_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0770_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0770_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0770_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0770_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0770_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0770_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0770_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0770_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0770_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0770_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0770_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0770_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0770_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0770_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0770_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0770_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0770_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0770_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0770_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0770_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0770_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0770_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0770_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0770_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0770_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0770_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0770_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0770_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0770_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0770_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0770_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0770_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0770_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0770_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0770_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0770_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0770_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0770_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0770_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0770_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0770_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0770_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0770_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0770_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0770_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0770_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0770_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0770_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0770_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0770_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0770_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0770_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0770_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0770_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0770_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0770_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0770_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0770_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0770_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public String getR0770_product() {
		return r0770_product;
	}




	public void setR0770_product(String r0770_product) {
		this.r0770_product = r0770_product;
	}




	public BigDecimal getR0770_pro_bought_net_gain_loss() {
		return r0770_pro_bought_net_gain_loss;
	}




	public void setR0770_pro_bought_net_gain_loss(BigDecimal r0770_pro_bought_net_gain_loss) {
		this.r0770_pro_bought_net_gain_loss = r0770_pro_bought_net_gain_loss;
	}




	public BigDecimal getR0770_pro_sold_net_gain_loss() {
		return r0770_pro_sold_net_gain_loss;
	}




	public void setR0770_pro_sold_net_gain_loss(BigDecimal r0770_pro_sold_net_gain_loss) {
		this.r0770_pro_sold_net_gain_loss = r0770_pro_sold_net_gain_loss;
	}




	public BigDecimal getR0770_res_1_to_3_years_mkt_val() {
		return r0770_res_1_to_3_years_mkt_val;
	}




	public void setR0770_res_1_to_3_years_mkt_val(BigDecimal r0770_res_1_to_3_years_mkt_val) {
		this.r0770_res_1_to_3_years_mkt_val = r0770_res_1_to_3_years_mkt_val;
	}




	public BigDecimal getR0770_res_lessthan_1_year_mkt_val() {
		return r0770_res_lessthan_1_year_mkt_val;
	}




	public void setR0770_res_lessthan_1_year_mkt_val(BigDecimal r0770_res_lessthan_1_year_mkt_val) {
		this.r0770_res_lessthan_1_year_mkt_val = r0770_res_lessthan_1_year_mkt_val;
	}




	public BigDecimal getR0770_res_morethan_3_years_mkt_val() {
		return r0770_res_morethan_3_years_mkt_val;
	}




	public void setR0770_res_morethan_3_years_mkt_val(BigDecimal r0770_res_morethan_3_years_mkt_val) {
		this.r0770_res_morethan_3_years_mkt_val = r0770_res_morethan_3_years_mkt_val;
	}




	public BigDecimal getR0770_res_nat_amt() {
		return r0770_res_nat_amt;
	}




	public void setR0770_res_nat_amt(BigDecimal r0770_res_nat_amt) {
		this.r0770_res_nat_amt = r0770_res_nat_amt;
	}




	public BigDecimal getR0770_sold_hedg_net_delta_pos() {
		return r0770_sold_hedg_net_delta_pos;
	}




	public void setR0770_sold_hedg_net_delta_pos(BigDecimal r0770_sold_hedg_net_delta_pos) {
		this.r0770_sold_hedg_net_delta_pos = r0770_sold_hedg_net_delta_pos;
	}




	public BigDecimal getR0770_sold_trad_net_delta_pos() {
		return r0770_sold_trad_net_delta_pos;
	}




	public void setR0770_sold_trad_net_delta_pos(BigDecimal r0770_sold_trad_net_delta_pos) {
		this.r0770_sold_trad_net_delta_pos = r0770_sold_trad_net_delta_pos;
	}




	public BigDecimal getR0770_trad_nat_amt() {
		return r0770_trad_nat_amt;
	}




	public void setR0770_trad_nat_amt(BigDecimal r0770_trad_nat_amt) {
		this.r0770_trad_nat_amt = r0770_trad_nat_amt;
	}




	public BigDecimal getR0770_within_1_year_nat_amt() {
		return r0770_within_1_year_nat_amt;
	}




	public void setR0770_within_1_year_nat_amt(BigDecimal r0770_within_1_year_nat_amt) {
		this.r0770_within_1_year_nat_amt = r0770_within_1_year_nat_amt;
	}




	public BigDecimal getR0780_1_to_3_years_nat_amt() {
		return r0780_1_to_3_years_nat_amt;
	}




	public void setR0780_1_to_3_years_nat_amt(BigDecimal r0780_1_to_3_years_nat_amt) {
		this.r0780_1_to_3_years_nat_amt = r0780_1_to_3_years_nat_amt;
	}




	public BigDecimal getR0780_bought_hedg_net_delta_pos() {
		return r0780_bought_hedg_net_delta_pos;
	}




	public void setR0780_bought_hedg_net_delta_pos(BigDecimal r0780_bought_hedg_net_delta_pos) {
		this.r0780_bought_hedg_net_delta_pos = r0780_bought_hedg_net_delta_pos;
	}




	public BigDecimal getR0780_bought_trad_net_delta_pos() {
		return r0780_bought_trad_net_delta_pos;
	}




	public void setR0780_bought_trad_net_delta_pos(BigDecimal r0780_bought_trad_net_delta_pos) {
		this.r0780_bought_trad_net_delta_pos = r0780_bought_trad_net_delta_pos;
	}




	public BigDecimal getR0780_gross_mkt_val() {
		return r0780_gross_mkt_val;
	}




	public void setR0780_gross_mkt_val(BigDecimal r0780_gross_mkt_val) {
		this.r0780_gross_mkt_val = r0780_gross_mkt_val;
	}




	public BigDecimal getR0780_hedg_nat_amt() {
		return r0780_hedg_nat_amt;
	}




	public void setR0780_hedg_nat_amt(BigDecimal r0780_hedg_nat_amt) {
		this.r0780_hedg_nat_amt = r0780_hedg_nat_amt;
	}




	public BigDecimal getR0780_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0780_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0780_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0780_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0780_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0780_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0780_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0780_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0780_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0780_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0780_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0780_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0780_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0780_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0780_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0780_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0780_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0780_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0780_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0780_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0780_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0780_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0780_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0780_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0780_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0780_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0780_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0780_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0780_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0780_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0780_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0780_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0780_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0780_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0780_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0780_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0780_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0780_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0780_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0780_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0780_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0780_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0780_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0780_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0780_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0780_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0780_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0780_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0780_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0780_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0780_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0780_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0780_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0780_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0780_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0780_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0780_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0780_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0780_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0780_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0780_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0780_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0780_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0780_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0780_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0780_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0780_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0780_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0780_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0780_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0780_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0780_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public BigDecimal getR0780_nat_amt() {
		return r0780_nat_amt;
	}




	public void setR0780_nat_amt(BigDecimal r0780_nat_amt) {
		this.r0780_nat_amt = r0780_nat_amt;
	}




	public BigDecimal getR0780_non_res_nat_amt() {
		return r0780_non_res_nat_amt;
	}




	public void setR0780_non_res_nat_amt(BigDecimal r0780_non_res_nat_amt) {
		this.r0780_non_res_nat_amt = r0780_non_res_nat_amt;
	}




	public BigDecimal getR0780_over_3_years_nat_amt() {
		return r0780_over_3_years_nat_amt;
	}




	public void setR0780_over_3_years_nat_amt(BigDecimal r0780_over_3_years_nat_amt) {
		this.r0780_over_3_years_nat_amt = r0780_over_3_years_nat_amt;
	}




	public BigDecimal getR0780_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0780_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0780_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0780_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0780_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0780_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0780_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0780_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0780_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0780_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0780_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0780_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0780_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0780_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0780_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0780_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0780_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0780_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0780_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0780_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0780_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0780_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0780_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0780_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0780_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0780_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0780_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0780_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0780_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0780_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0780_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0780_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0780_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0780_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0780_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0780_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0780_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0780_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0780_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0780_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0780_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0780_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0780_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0780_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0780_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0780_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0780_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0780_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0780_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0780_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0780_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0780_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0780_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0780_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0780_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0780_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0780_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0780_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0780_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0780_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0780_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0780_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0780_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0780_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0780_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0780_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0780_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0780_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0780_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0780_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0780_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0780_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public String getR0780_product() {
		return r0780_product;
	}




	public void setR0780_product(String r0780_product) {
		this.r0780_product = r0780_product;
	}




	public BigDecimal getR0780_pro_bought_net_gain_loss() {
		return r0780_pro_bought_net_gain_loss;
	}




	public void setR0780_pro_bought_net_gain_loss(BigDecimal r0780_pro_bought_net_gain_loss) {
		this.r0780_pro_bought_net_gain_loss = r0780_pro_bought_net_gain_loss;
	}




	public BigDecimal getR0780_pro_sold_net_gain_loss() {
		return r0780_pro_sold_net_gain_loss;
	}




	public void setR0780_pro_sold_net_gain_loss(BigDecimal r0780_pro_sold_net_gain_loss) {
		this.r0780_pro_sold_net_gain_loss = r0780_pro_sold_net_gain_loss;
	}




	public BigDecimal getR0780_res_1_to_3_years_mkt_val() {
		return r0780_res_1_to_3_years_mkt_val;
	}




	public void setR0780_res_1_to_3_years_mkt_val(BigDecimal r0780_res_1_to_3_years_mkt_val) {
		this.r0780_res_1_to_3_years_mkt_val = r0780_res_1_to_3_years_mkt_val;
	}




	public BigDecimal getR0780_res_lessthan_1_year_mkt_val() {
		return r0780_res_lessthan_1_year_mkt_val;
	}




	public void setR0780_res_lessthan_1_year_mkt_val(BigDecimal r0780_res_lessthan_1_year_mkt_val) {
		this.r0780_res_lessthan_1_year_mkt_val = r0780_res_lessthan_1_year_mkt_val;
	}




	public BigDecimal getR0780_res_morethan_3_years_mkt_val() {
		return r0780_res_morethan_3_years_mkt_val;
	}




	public void setR0780_res_morethan_3_years_mkt_val(BigDecimal r0780_res_morethan_3_years_mkt_val) {
		this.r0780_res_morethan_3_years_mkt_val = r0780_res_morethan_3_years_mkt_val;
	}




	public BigDecimal getR0780_res_nat_amt() {
		return r0780_res_nat_amt;
	}




	public void setR0780_res_nat_amt(BigDecimal r0780_res_nat_amt) {
		this.r0780_res_nat_amt = r0780_res_nat_amt;
	}




	public BigDecimal getR0780_sold_hedg_net_delta_pos() {
		return r0780_sold_hedg_net_delta_pos;
	}




	public void setR0780_sold_hedg_net_delta_pos(BigDecimal r0780_sold_hedg_net_delta_pos) {
		this.r0780_sold_hedg_net_delta_pos = r0780_sold_hedg_net_delta_pos;
	}




	public BigDecimal getR0780_sold_trad_net_delta_pos() {
		return r0780_sold_trad_net_delta_pos;
	}




	public void setR0780_sold_trad_net_delta_pos(BigDecimal r0780_sold_trad_net_delta_pos) {
		this.r0780_sold_trad_net_delta_pos = r0780_sold_trad_net_delta_pos;
	}




	public BigDecimal getR0780_trad_nat_amt() {
		return r0780_trad_nat_amt;
	}




	public void setR0780_trad_nat_amt(BigDecimal r0780_trad_nat_amt) {
		this.r0780_trad_nat_amt = r0780_trad_nat_amt;
	}




	public BigDecimal getR0780_within_1_year_nat_amt() {
		return r0780_within_1_year_nat_amt;
	}




	public void setR0780_within_1_year_nat_amt(BigDecimal r0780_within_1_year_nat_amt) {
		this.r0780_within_1_year_nat_amt = r0780_within_1_year_nat_amt;
	}




	public BigDecimal getR0790_1_to_3_years_nat_amt() {
		return r0790_1_to_3_years_nat_amt;
	}




	public void setR0790_1_to_3_years_nat_amt(BigDecimal r0790_1_to_3_years_nat_amt) {
		this.r0790_1_to_3_years_nat_amt = r0790_1_to_3_years_nat_amt;
	}




	public BigDecimal getR0790_bought_hedg_net_delta_pos() {
		return r0790_bought_hedg_net_delta_pos;
	}




	public void setR0790_bought_hedg_net_delta_pos(BigDecimal r0790_bought_hedg_net_delta_pos) {
		this.r0790_bought_hedg_net_delta_pos = r0790_bought_hedg_net_delta_pos;
	}




	public BigDecimal getR0790_bought_trad_net_delta_pos() {
		return r0790_bought_trad_net_delta_pos;
	}




	public void setR0790_bought_trad_net_delta_pos(BigDecimal r0790_bought_trad_net_delta_pos) {
		this.r0790_bought_trad_net_delta_pos = r0790_bought_trad_net_delta_pos;
	}




	public BigDecimal getR0790_gross_mkt_val() {
		return r0790_gross_mkt_val;
	}




	public void setR0790_gross_mkt_val(BigDecimal r0790_gross_mkt_val) {
		this.r0790_gross_mkt_val = r0790_gross_mkt_val;
	}




	public BigDecimal getR0790_hedg_nat_amt() {
		return r0790_hedg_nat_amt;
	}




	public void setR0790_hedg_nat_amt(BigDecimal r0790_hedg_nat_amt) {
		this.r0790_hedg_nat_amt = r0790_hedg_nat_amt;
	}




	public BigDecimal getR0790_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0790_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0790_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0790_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0790_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0790_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0790_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0790_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0790_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0790_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0790_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0790_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0790_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0790_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0790_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0790_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0790_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0790_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0790_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0790_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0790_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0790_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0790_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0790_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0790_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0790_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0790_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0790_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0790_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0790_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0790_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0790_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0790_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0790_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0790_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0790_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0790_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0790_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0790_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0790_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0790_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0790_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0790_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0790_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0790_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0790_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0790_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0790_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0790_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0790_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0790_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0790_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0790_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0790_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0790_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0790_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0790_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0790_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0790_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0790_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0790_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0790_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0790_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0790_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0790_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0790_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0790_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0790_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0790_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0790_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0790_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0790_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public BigDecimal getR0790_nat_amt() {
		return r0790_nat_amt;
	}




	public void setR0790_nat_amt(BigDecimal r0790_nat_amt) {
		this.r0790_nat_amt = r0790_nat_amt;
	}




	public BigDecimal getR0790_non_res_nat_amt() {
		return r0790_non_res_nat_amt;
	}




	public void setR0790_non_res_nat_amt(BigDecimal r0790_non_res_nat_amt) {
		this.r0790_non_res_nat_amt = r0790_non_res_nat_amt;
	}




	public BigDecimal getR0790_over_3_years_nat_amt() {
		return r0790_over_3_years_nat_amt;
	}




	public void setR0790_over_3_years_nat_amt(BigDecimal r0790_over_3_years_nat_amt) {
		this.r0790_over_3_years_nat_amt = r0790_over_3_years_nat_amt;
	}




	public BigDecimal getR0790_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0790_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0790_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0790_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0790_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0790_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0790_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0790_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0790_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0790_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0790_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0790_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0790_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0790_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0790_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0790_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0790_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0790_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0790_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0790_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0790_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0790_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0790_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0790_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0790_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0790_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0790_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0790_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0790_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0790_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0790_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0790_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0790_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0790_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0790_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0790_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0790_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0790_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0790_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0790_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0790_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0790_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0790_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0790_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0790_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0790_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0790_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0790_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0790_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0790_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0790_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0790_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0790_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0790_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0790_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0790_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0790_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0790_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0790_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0790_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0790_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0790_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0790_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0790_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0790_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0790_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0790_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0790_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0790_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0790_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0790_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0790_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public String getR0790_product() {
		return r0790_product;
	}




	public void setR0790_product(String r0790_product) {
		this.r0790_product = r0790_product;
	}




	public BigDecimal getR0790_pro_bought_net_gain_loss() {
		return r0790_pro_bought_net_gain_loss;
	}




	public void setR0790_pro_bought_net_gain_loss(BigDecimal r0790_pro_bought_net_gain_loss) {
		this.r0790_pro_bought_net_gain_loss = r0790_pro_bought_net_gain_loss;
	}




	public BigDecimal getR0790_pro_sold_net_gain_loss() {
		return r0790_pro_sold_net_gain_loss;
	}




	public void setR0790_pro_sold_net_gain_loss(BigDecimal r0790_pro_sold_net_gain_loss) {
		this.r0790_pro_sold_net_gain_loss = r0790_pro_sold_net_gain_loss;
	}




	public BigDecimal getR0790_res_1_to_3_years_mkt_val() {
		return r0790_res_1_to_3_years_mkt_val;
	}




	public void setR0790_res_1_to_3_years_mkt_val(BigDecimal r0790_res_1_to_3_years_mkt_val) {
		this.r0790_res_1_to_3_years_mkt_val = r0790_res_1_to_3_years_mkt_val;
	}




	public BigDecimal getR0790_res_lessthan_1_year_mkt_val() {
		return r0790_res_lessthan_1_year_mkt_val;
	}




	public void setR0790_res_lessthan_1_year_mkt_val(BigDecimal r0790_res_lessthan_1_year_mkt_val) {
		this.r0790_res_lessthan_1_year_mkt_val = r0790_res_lessthan_1_year_mkt_val;
	}




	public BigDecimal getR0790_res_morethan_3_years_mkt_val() {
		return r0790_res_morethan_3_years_mkt_val;
	}




	public void setR0790_res_morethan_3_years_mkt_val(BigDecimal r0790_res_morethan_3_years_mkt_val) {
		this.r0790_res_morethan_3_years_mkt_val = r0790_res_morethan_3_years_mkt_val;
	}




	public BigDecimal getR0790_res_nat_amt() {
		return r0790_res_nat_amt;
	}




	public void setR0790_res_nat_amt(BigDecimal r0790_res_nat_amt) {
		this.r0790_res_nat_amt = r0790_res_nat_amt;
	}




	public BigDecimal getR0790_sold_hedg_net_delta_pos() {
		return r0790_sold_hedg_net_delta_pos;
	}




	public void setR0790_sold_hedg_net_delta_pos(BigDecimal r0790_sold_hedg_net_delta_pos) {
		this.r0790_sold_hedg_net_delta_pos = r0790_sold_hedg_net_delta_pos;
	}




	public BigDecimal getR0790_sold_trad_net_delta_pos() {
		return r0790_sold_trad_net_delta_pos;
	}




	public void setR0790_sold_trad_net_delta_pos(BigDecimal r0790_sold_trad_net_delta_pos) {
		this.r0790_sold_trad_net_delta_pos = r0790_sold_trad_net_delta_pos;
	}




	public BigDecimal getR0790_trad_nat_amt() {
		return r0790_trad_nat_amt;
	}




	public void setR0790_trad_nat_amt(BigDecimal r0790_trad_nat_amt) {
		this.r0790_trad_nat_amt = r0790_trad_nat_amt;
	}




	public BigDecimal getR0790_within_1_year_nat_amt() {
		return r0790_within_1_year_nat_amt;
	}




	public void setR0790_within_1_year_nat_amt(BigDecimal r0790_within_1_year_nat_amt) {
		this.r0790_within_1_year_nat_amt = r0790_within_1_year_nat_amt;
	}




	public BigDecimal getR0800_1_to_3_years_nat_amt() {
		return r0800_1_to_3_years_nat_amt;
	}




	public void setR0800_1_to_3_years_nat_amt(BigDecimal r0800_1_to_3_years_nat_amt) {
		this.r0800_1_to_3_years_nat_amt = r0800_1_to_3_years_nat_amt;
	}




	public BigDecimal getR0800_bought_hedg_net_delta_pos() {
		return r0800_bought_hedg_net_delta_pos;
	}




	public void setR0800_bought_hedg_net_delta_pos(BigDecimal r0800_bought_hedg_net_delta_pos) {
		this.r0800_bought_hedg_net_delta_pos = r0800_bought_hedg_net_delta_pos;
	}




	public BigDecimal getR0800_bought_trad_net_delta_pos() {
		return r0800_bought_trad_net_delta_pos;
	}




	public void setR0800_bought_trad_net_delta_pos(BigDecimal r0800_bought_trad_net_delta_pos) {
		this.r0800_bought_trad_net_delta_pos = r0800_bought_trad_net_delta_pos;
	}




	public BigDecimal getR0800_gross_mkt_val() {
		return r0800_gross_mkt_val;
	}




	public void setR0800_gross_mkt_val(BigDecimal r0800_gross_mkt_val) {
		this.r0800_gross_mkt_val = r0800_gross_mkt_val;
	}




	public BigDecimal getR0800_hedg_nat_amt() {
		return r0800_hedg_nat_amt;
	}




	public void setR0800_hedg_nat_amt(BigDecimal r0800_hedg_nat_amt) {
		this.r0800_hedg_nat_amt = r0800_hedg_nat_amt;
	}




	public BigDecimal getR0800_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0800_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0800_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0800_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0800_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0800_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0800_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0800_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0800_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0800_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0800_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0800_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0800_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0800_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0800_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0800_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0800_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0800_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0800_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0800_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0800_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0800_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0800_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0800_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0800_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0800_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0800_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0800_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0800_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0800_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0800_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0800_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0800_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0800_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0800_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0800_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0800_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0800_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0800_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0800_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0800_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0800_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0800_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0800_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0800_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0800_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0800_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0800_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0800_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0800_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0800_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0800_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0800_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0800_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0800_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0800_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0800_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0800_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0800_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0800_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0800_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0800_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0800_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0800_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0800_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0800_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0800_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0800_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0800_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0800_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0800_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0800_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public BigDecimal getR0800_nat_amt() {
		return r0800_nat_amt;
	}




	public void setR0800_nat_amt(BigDecimal r0800_nat_amt) {
		this.r0800_nat_amt = r0800_nat_amt;
	}




	public BigDecimal getR0800_non_res_nat_amt() {
		return r0800_non_res_nat_amt;
	}




	public void setR0800_non_res_nat_amt(BigDecimal r0800_non_res_nat_amt) {
		this.r0800_non_res_nat_amt = r0800_non_res_nat_amt;
	}




	public BigDecimal getR0800_over_3_years_nat_amt() {
		return r0800_over_3_years_nat_amt;
	}




	public void setR0800_over_3_years_nat_amt(BigDecimal r0800_over_3_years_nat_amt) {
		this.r0800_over_3_years_nat_amt = r0800_over_3_years_nat_amt;
	}




	public BigDecimal getR0800_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0800_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0800_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0800_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0800_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0800_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0800_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0800_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0800_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0800_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0800_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0800_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0800_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0800_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0800_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0800_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0800_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0800_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0800_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0800_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0800_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0800_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0800_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0800_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0800_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0800_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0800_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0800_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0800_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0800_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0800_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0800_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0800_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0800_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0800_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0800_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0800_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0800_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0800_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0800_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0800_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0800_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0800_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0800_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0800_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0800_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0800_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0800_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0800_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0800_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0800_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0800_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0800_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0800_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0800_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0800_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0800_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0800_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0800_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0800_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0800_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0800_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0800_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0800_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0800_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0800_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0800_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0800_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0800_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0800_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0800_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0800_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public String getR0800_product() {
		return r0800_product;
	}




	public void setR0800_product(String r0800_product) {
		this.r0800_product = r0800_product;
	}




	public BigDecimal getR0800_pro_bought_net_gain_loss() {
		return r0800_pro_bought_net_gain_loss;
	}




	public void setR0800_pro_bought_net_gain_loss(BigDecimal r0800_pro_bought_net_gain_loss) {
		this.r0800_pro_bought_net_gain_loss = r0800_pro_bought_net_gain_loss;
	}




	public BigDecimal getR0800_pro_sold_net_gain_loss() {
		return r0800_pro_sold_net_gain_loss;
	}




	public void setR0800_pro_sold_net_gain_loss(BigDecimal r0800_pro_sold_net_gain_loss) {
		this.r0800_pro_sold_net_gain_loss = r0800_pro_sold_net_gain_loss;
	}




	public BigDecimal getR0800_res_1_to_3_years_mkt_val() {
		return r0800_res_1_to_3_years_mkt_val;
	}




	public void setR0800_res_1_to_3_years_mkt_val(BigDecimal r0800_res_1_to_3_years_mkt_val) {
		this.r0800_res_1_to_3_years_mkt_val = r0800_res_1_to_3_years_mkt_val;
	}




	public BigDecimal getR0800_res_lessthan_1_year_mkt_val() {
		return r0800_res_lessthan_1_year_mkt_val;
	}




	public void setR0800_res_lessthan_1_year_mkt_val(BigDecimal r0800_res_lessthan_1_year_mkt_val) {
		this.r0800_res_lessthan_1_year_mkt_val = r0800_res_lessthan_1_year_mkt_val;
	}




	public BigDecimal getR0800_res_morethan_3_years_mkt_val() {
		return r0800_res_morethan_3_years_mkt_val;
	}




	public void setR0800_res_morethan_3_years_mkt_val(BigDecimal r0800_res_morethan_3_years_mkt_val) {
		this.r0800_res_morethan_3_years_mkt_val = r0800_res_morethan_3_years_mkt_val;
	}




	public BigDecimal getR0800_res_nat_amt() {
		return r0800_res_nat_amt;
	}




	public void setR0800_res_nat_amt(BigDecimal r0800_res_nat_amt) {
		this.r0800_res_nat_amt = r0800_res_nat_amt;
	}




	public BigDecimal getR0800_sold_hedg_net_delta_pos() {
		return r0800_sold_hedg_net_delta_pos;
	}




	public void setR0800_sold_hedg_net_delta_pos(BigDecimal r0800_sold_hedg_net_delta_pos) {
		this.r0800_sold_hedg_net_delta_pos = r0800_sold_hedg_net_delta_pos;
	}




	public BigDecimal getR0800_sold_trad_net_delta_pos() {
		return r0800_sold_trad_net_delta_pos;
	}




	public void setR0800_sold_trad_net_delta_pos(BigDecimal r0800_sold_trad_net_delta_pos) {
		this.r0800_sold_trad_net_delta_pos = r0800_sold_trad_net_delta_pos;
	}




	public BigDecimal getR0800_trad_nat_amt() {
		return r0800_trad_nat_amt;
	}




	public void setR0800_trad_nat_amt(BigDecimal r0800_trad_nat_amt) {
		this.r0800_trad_nat_amt = r0800_trad_nat_amt;
	}




	public BigDecimal getR0800_within_1_year_nat_amt() {
		return r0800_within_1_year_nat_amt;
	}




	public void setR0800_within_1_year_nat_amt(BigDecimal r0800_within_1_year_nat_amt) {
		this.r0800_within_1_year_nat_amt = r0800_within_1_year_nat_amt;
	}




	public BigDecimal getR0810_1_to_3_years_nat_amt() {
		return r0810_1_to_3_years_nat_amt;
	}




	public void setR0810_1_to_3_years_nat_amt(BigDecimal r0810_1_to_3_years_nat_amt) {
		this.r0810_1_to_3_years_nat_amt = r0810_1_to_3_years_nat_amt;
	}




	public BigDecimal getR0810_bought_hedg_net_delta_pos() {
		return r0810_bought_hedg_net_delta_pos;
	}




	public void setR0810_bought_hedg_net_delta_pos(BigDecimal r0810_bought_hedg_net_delta_pos) {
		this.r0810_bought_hedg_net_delta_pos = r0810_bought_hedg_net_delta_pos;
	}




	public BigDecimal getR0810_bought_trad_net_delta_pos() {
		return r0810_bought_trad_net_delta_pos;
	}




	public void setR0810_bought_trad_net_delta_pos(BigDecimal r0810_bought_trad_net_delta_pos) {
		this.r0810_bought_trad_net_delta_pos = r0810_bought_trad_net_delta_pos;
	}




	public BigDecimal getR0810_gross_mkt_val() {
		return r0810_gross_mkt_val;
	}




	public void setR0810_gross_mkt_val(BigDecimal r0810_gross_mkt_val) {
		this.r0810_gross_mkt_val = r0810_gross_mkt_val;
	}




	public BigDecimal getR0810_hedg_nat_amt() {
		return r0810_hedg_nat_amt;
	}




	public void setR0810_hedg_nat_amt(BigDecimal r0810_hedg_nat_amt) {
		this.r0810_hedg_nat_amt = r0810_hedg_nat_amt;
	}




	public BigDecimal getR0810_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0810_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0810_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0810_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0810_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0810_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0810_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0810_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0810_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0810_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0810_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0810_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0810_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0810_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0810_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0810_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0810_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0810_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0810_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0810_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0810_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0810_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0810_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0810_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0810_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0810_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0810_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0810_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0810_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0810_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0810_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0810_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0810_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0810_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0810_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0810_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0810_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0810_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0810_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0810_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0810_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0810_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0810_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0810_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0810_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0810_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0810_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0810_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0810_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0810_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0810_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0810_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0810_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0810_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0810_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0810_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0810_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0810_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0810_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0810_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0810_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0810_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0810_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0810_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0810_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0810_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0810_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0810_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0810_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0810_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0810_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0810_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public BigDecimal getR0810_nat_amt() {
		return r0810_nat_amt;
	}




	public void setR0810_nat_amt(BigDecimal r0810_nat_amt) {
		this.r0810_nat_amt = r0810_nat_amt;
	}




	public BigDecimal getR0810_non_res_nat_amt() {
		return r0810_non_res_nat_amt;
	}




	public void setR0810_non_res_nat_amt(BigDecimal r0810_non_res_nat_amt) {
		this.r0810_non_res_nat_amt = r0810_non_res_nat_amt;
	}




	public BigDecimal getR0810_over_3_years_nat_amt() {
		return r0810_over_3_years_nat_amt;
	}




	public void setR0810_over_3_years_nat_amt(BigDecimal r0810_over_3_years_nat_amt) {
		this.r0810_over_3_years_nat_amt = r0810_over_3_years_nat_amt;
	}




	public BigDecimal getR0810_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0810_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0810_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0810_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0810_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0810_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0810_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0810_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0810_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0810_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0810_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0810_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0810_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0810_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public void setR0810_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0810_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0810_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0810_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0810_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0810_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public void setR0810_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0810_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0810_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0810_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0810_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0810_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public void setR0810_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0810_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0810_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0810_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}




	public BigDecimal getR0810_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0810_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public void setR0810_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0810_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0810_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0810_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}




	public BigDecimal getR0810_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0810_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public void setR0810_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0810_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0810_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0810_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0810_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0810_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public void setR0810_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0810_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0810_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0810_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}




	public BigDecimal getR0810_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0810_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public void setR0810_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0810_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0810_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0810_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0810_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0810_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public void setR0810_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0810_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0810_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0810_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}




	public BigDecimal getR0810_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0810_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public void setR0810_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0810_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0810_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0810_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}




	public BigDecimal getR0810_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0810_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public void setR0810_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0810_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0810_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0810_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}




	public String getR0810_product() {
		return r0810_product;
	}




	public void setR0810_product(String r0810_product) {
		this.r0810_product = r0810_product;
	}




	public BigDecimal getR0810_pro_bought_net_gain_loss() {
		return r0810_pro_bought_net_gain_loss;
	}




	public void setR0810_pro_bought_net_gain_loss(BigDecimal r0810_pro_bought_net_gain_loss) {
		this.r0810_pro_bought_net_gain_loss = r0810_pro_bought_net_gain_loss;
	}




	public BigDecimal getR0810_pro_sold_net_gain_loss() {
		return r0810_pro_sold_net_gain_loss;
	}




	public void setR0810_pro_sold_net_gain_loss(BigDecimal r0810_pro_sold_net_gain_loss) {
		this.r0810_pro_sold_net_gain_loss = r0810_pro_sold_net_gain_loss;
	}




	public BigDecimal getR0810_res_1_to_3_years_mkt_val() {
		return r0810_res_1_to_3_years_mkt_val;
	}




	public void setR0810_res_1_to_3_years_mkt_val(BigDecimal r0810_res_1_to_3_years_mkt_val) {
		this.r0810_res_1_to_3_years_mkt_val = r0810_res_1_to_3_years_mkt_val;
	}




	public BigDecimal getR0810_res_lessthan_1_year_mkt_val() {
		return r0810_res_lessthan_1_year_mkt_val;
	}




	public void setR0810_res_lessthan_1_year_mkt_val(BigDecimal r0810_res_lessthan_1_year_mkt_val) {
		this.r0810_res_lessthan_1_year_mkt_val = r0810_res_lessthan_1_year_mkt_val;
	}




	public BigDecimal getR0810_res_morethan_3_years_mkt_val() {
		return r0810_res_morethan_3_years_mkt_val;
	}




	public void setR0810_res_morethan_3_years_mkt_val(BigDecimal r0810_res_morethan_3_years_mkt_val) {
		this.r0810_res_morethan_3_years_mkt_val = r0810_res_morethan_3_years_mkt_val;
	}




	public BigDecimal getR0810_res_nat_amt() {
		return r0810_res_nat_amt;
	}




	public void setR0810_res_nat_amt(BigDecimal r0810_res_nat_amt) {
		this.r0810_res_nat_amt = r0810_res_nat_amt;
	}




	public BigDecimal getR0810_sold_hedg_net_delta_pos() {
		return r0810_sold_hedg_net_delta_pos;
	}




	public void setR0810_sold_hedg_net_delta_pos(BigDecimal r0810_sold_hedg_net_delta_pos) {
		this.r0810_sold_hedg_net_delta_pos = r0810_sold_hedg_net_delta_pos;
	}




	public BigDecimal getR0810_sold_trad_net_delta_pos() {
		return r0810_sold_trad_net_delta_pos;
	}




	public void setR0810_sold_trad_net_delta_pos(BigDecimal r0810_sold_trad_net_delta_pos) {
		this.r0810_sold_trad_net_delta_pos = r0810_sold_trad_net_delta_pos;
	}




	public BigDecimal getR0810_trad_nat_amt() {
		return r0810_trad_nat_amt;
	}




	public void setR0810_trad_nat_amt(BigDecimal r0810_trad_nat_amt) {
		this.r0810_trad_nat_amt = r0810_trad_nat_amt;
	}




	public BigDecimal getR0810_within_1_year_nat_amt() {
		return r0810_within_1_year_nat_amt;
	}




	public void setR0810_within_1_year_nat_amt(BigDecimal r0810_within_1_year_nat_amt) {
		this.r0810_within_1_year_nat_amt = r0810_within_1_year_nat_amt;
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




	public CBUAE_BRF7_3_Summary_Entity3() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
