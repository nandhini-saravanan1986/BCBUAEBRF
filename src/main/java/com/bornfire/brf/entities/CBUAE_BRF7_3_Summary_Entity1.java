package com.bornfire.brf.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CBUAE_BRF7_3_SUMMARYTABLE1")
public class CBUAE_BRF7_3_Summary_Entity1 {

	private  String  r0010_product;
	private  String  r0020_product;
	private  BigDecimal  r0030_1_to_3_years_nat_amt;
	private  BigDecimal  r0030_bought_hedg_net_delta_pos;
	private  BigDecimal  r0030_bought_trad_net_delta_pos;
	private  BigDecimal  r0030_gross_mkt_val;
	private  BigDecimal  r0030_hedg_nat_amt;
	private  BigDecimal  r0030_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0030_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0030_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0030_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0030_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0030_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0030_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0030_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0030_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0030_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0030_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0030_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0030_nat_amt;
	private  BigDecimal  r0030_non_res_nat_amt;
	private  BigDecimal  r0030_over_3_years_nat_amt;
	private  BigDecimal  r0030_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0030_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0030_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0030_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0030_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0030_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0030_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0030_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0030_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0030_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0030_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0030_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0030_product;
	private  BigDecimal  r0030_pro_bought_net_gain_loss;
	private  BigDecimal  r0030_pro_sold_net_gain_loss;
	private  BigDecimal  r0030_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0030_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0030_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0030_res_nat_amt;
	private  BigDecimal  r0030_sold_hedg_net_delta_pos;
	private  BigDecimal  r0030_sold_trad_net_delta_pos;
	private  BigDecimal  r0030_trad_nat_amt;
	private  BigDecimal  r0030_within_1_year_nat_amt;
	private  BigDecimal  r0040_1_to_3_years_nat_amt;
	private  BigDecimal  r0040_bought_hedg_net_delta_pos;
	private  BigDecimal  r0040_bought_trad_net_delta_pos;
	private  BigDecimal  r0040_gross_mkt_val;
	private  BigDecimal  r0040_hedg_nat_amt;
	private  BigDecimal  r0040_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0040_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0040_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0040_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0040_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0040_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0040_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0040_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0040_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0040_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0040_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0040_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0040_nat_amt;
	private  BigDecimal  r0040_non_res_nat_amt;
	private  BigDecimal  r0040_over_3_years_nat_amt;
	private  BigDecimal  r0040_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0040_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0040_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0040_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0040_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0040_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0040_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0040_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0040_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0040_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0040_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0040_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0040_product;
	private  BigDecimal  r0040_pro_bought_net_gain_loss;
	private  BigDecimal  r0040_pro_sold_net_gain_loss;
	private  BigDecimal  r0040_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0040_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0040_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0040_res_nat_amt;
	private  BigDecimal  r0040_sold_hedg_net_delta_pos;
	private  BigDecimal  r0040_sold_trad_net_delta_pos;
	private  BigDecimal  r0040_trad_nat_amt;
	private  BigDecimal  r0040_within_1_year_nat_amt;
	private  BigDecimal  r0050_1_to_3_years_nat_amt;
	private  BigDecimal  r0050_bought_hedg_net_delta_pos;
	private  BigDecimal  r0050_bought_trad_net_delta_pos;
	private  BigDecimal  r0050_gross_mkt_val;
	private  BigDecimal  r0050_hedg_nat_amt;
	private  BigDecimal  r0050_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0050_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0050_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0050_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0050_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0050_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0050_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0050_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0050_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0050_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0050_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0050_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0050_nat_amt;
	private  BigDecimal  r0050_non_res_nat_amt;
	private  BigDecimal  r0050_over_3_years_nat_amt;
	private  BigDecimal  r0050_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0050_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0050_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0050_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0050_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0050_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0050_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0050_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0050_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0050_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0050_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0050_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0050_product;
	private  BigDecimal  r0050_pro_bought_net_gain_loss;
	private  BigDecimal  r0050_pro_sold_net_gain_loss;
	private  BigDecimal  r0050_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0050_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0050_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0050_res_nat_amt;
	private  BigDecimal  r0050_sold_hedg_net_delta_pos;
	private  BigDecimal  r0050_sold_trad_net_delta_pos;
	private  BigDecimal  r0050_trad_nat_amt;
	private  BigDecimal  r0050_within_1_year_nat_amt;
	private  BigDecimal  r0060_1_to_3_years_nat_amt;
	private  BigDecimal  r0060_bought_hedg_net_delta_pos;
	private  BigDecimal  r0060_bought_trad_net_delta_pos;
	private  BigDecimal  r0060_gross_mkt_val;
	private  BigDecimal  r0060_hedg_nat_amt;
	private  BigDecimal  r0060_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0060_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0060_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0060_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0060_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0060_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0060_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0060_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0060_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0060_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0060_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0060_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0060_nat_amt;
	private  BigDecimal  r0060_non_res_nat_amt;
	private  BigDecimal  r0060_over_3_years_nat_amt;
	private  BigDecimal  r0060_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0060_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0060_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0060_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0060_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0060_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0060_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0060_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0060_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0060_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0060_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0060_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0060_product;
	private  BigDecimal  r0060_pro_bought_net_gain_loss;
	private  BigDecimal  r0060_pro_sold_net_gain_loss;
	private  BigDecimal  r0060_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0060_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0060_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0060_res_nat_amt;
	private  BigDecimal  r0060_sold_hedg_net_delta_pos;
	private  BigDecimal  r0060_sold_trad_net_delta_pos;
	private  BigDecimal  r0060_trad_nat_amt;
	private  BigDecimal  r0060_within_1_year_nat_amt;
	private  BigDecimal  r0070_1_to_3_years_nat_amt;
	private  BigDecimal  r0070_bought_hedg_net_delta_pos;
	private  BigDecimal  r0070_bought_trad_net_delta_pos;
	private  BigDecimal  r0070_gross_mkt_val;
	private  BigDecimal  r0070_hedg_nat_amt;
	private  BigDecimal  r0070_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0070_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0070_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0070_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0070_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0070_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0070_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0070_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0070_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0070_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0070_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0070_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0070_nat_amt;
	private  BigDecimal  r0070_non_res_nat_amt;
	private  BigDecimal  r0070_over_3_years_nat_amt;
	private  BigDecimal  r0070_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0070_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0070_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0070_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0070_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0070_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0070_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0070_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0070_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0070_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0070_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0070_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0070_product;
	private  BigDecimal  r0070_pro_bought_net_gain_loss;
	private  BigDecimal  r0070_pro_sold_net_gain_loss;
	private  BigDecimal  r0070_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0070_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0070_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0070_res_nat_amt;
	private  BigDecimal  r0070_sold_hedg_net_delta_pos;
	private  BigDecimal  r0070_sold_trad_net_delta_pos;
	private  BigDecimal  r0070_trad_nat_amt;
	private  BigDecimal  r0070_within_1_year_nat_amt;
	private  BigDecimal  r0080_1_to_3_years_nat_amt;
	private  BigDecimal  r0080_bought_hedg_net_delta_pos;
	private  BigDecimal  r0080_bought_trad_net_delta_pos;
	private  BigDecimal  r0080_gross_mkt_val;
	private  BigDecimal  r0080_hedg_nat_amt;
	private  BigDecimal  r0080_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0080_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0080_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0080_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0080_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0080_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0080_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0080_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0080_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0080_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0080_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0080_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0080_nat_amt;
	private  BigDecimal  r0080_non_res_nat_amt;
	private  BigDecimal  r0080_over_3_years_nat_amt;
	private  BigDecimal  r0080_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0080_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0080_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0080_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0080_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0080_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0080_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0080_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0080_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0080_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0080_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0080_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0080_product;
	private  BigDecimal  r0080_pro_bought_net_gain_loss;
	private  BigDecimal  r0080_pro_sold_net_gain_loss;
	private  BigDecimal  r0080_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0080_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0080_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0080_res_nat_amt;
	private  BigDecimal  r0080_sold_hedg_net_delta_pos;
	private  BigDecimal  r0080_sold_trad_net_delta_pos;
	private  BigDecimal  r0080_trad_nat_amt;
	private  BigDecimal  r0080_within_1_year_nat_amt;
	private  BigDecimal  r0090_1_to_3_years_nat_amt;
	private  BigDecimal  r0090_bought_hedg_net_delta_pos;
	private  BigDecimal  r0090_bought_trad_net_delta_pos;
	private  BigDecimal  r0090_gross_mkt_val;
	private  BigDecimal  r0090_hedg_nat_amt;
	private  BigDecimal  r0090_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0090_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0090_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0090_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0090_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0090_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0090_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0090_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0090_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0090_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0090_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0090_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0090_nat_amt;
	private  BigDecimal  r0090_non_res_nat_amt;
	private  BigDecimal  r0090_over_3_years_nat_amt;
	private  BigDecimal  r0090_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0090_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0090_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0090_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0090_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0090_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0090_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0090_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0090_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0090_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0090_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0090_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0090_product;
	private  BigDecimal  r0090_pro_bought_net_gain_loss;
	private  BigDecimal  r0090_pro_sold_net_gain_loss;
	private  BigDecimal  r0090_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0090_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0090_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0090_res_nat_amt;
	private  BigDecimal  r0090_sold_hedg_net_delta_pos;
	private  BigDecimal  r0090_sold_trad_net_delta_pos;
	private  BigDecimal  r0090_trad_nat_amt;
	private  BigDecimal  r0090_within_1_year_nat_amt;
	private  BigDecimal  r0100_1_to_3_years_nat_amt;
	private  BigDecimal  r0100_bought_hedg_net_delta_pos;
	private  BigDecimal  r0100_bought_trad_net_delta_pos;
	private  BigDecimal  r0100_gross_mkt_val;
	private  BigDecimal  r0100_hedg_nat_amt;
	private  BigDecimal  r0100_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0100_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0100_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0100_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0100_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0100_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0100_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0100_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0100_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0100_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0100_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0100_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0100_nat_amt;
	private  BigDecimal  r0100_non_res_nat_amt;
	private  BigDecimal  r0100_over_3_years_nat_amt;
	private  BigDecimal  r0100_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0100_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0100_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0100_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0100_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0100_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0100_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0100_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0100_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0100_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0100_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0100_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0100_product;
	private  BigDecimal  r0100_pro_bought_net_gain_loss;
	private  BigDecimal  r0100_pro_sold_net_gain_loss;
	private  BigDecimal  r0100_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0100_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0100_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0100_res_nat_amt;
	private  BigDecimal  r0100_sold_hedg_net_delta_pos;
	private  BigDecimal  r0100_sold_trad_net_delta_pos;
	private  BigDecimal  r0100_trad_nat_amt;
	private  BigDecimal  r0100_within_1_year_nat_amt;
	private  BigDecimal  r0110_1_to_3_years_nat_amt;
	private  BigDecimal  r0110_bought_hedg_net_delta_pos;
	private  BigDecimal  r0110_bought_trad_net_delta_pos;
	private  BigDecimal  r0110_gross_mkt_val;
	private  BigDecimal  r0110_hedg_nat_amt;
	private  BigDecimal  r0110_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0110_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0110_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0110_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0110_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0110_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0110_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0110_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0110_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0110_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0110_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0110_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0110_nat_amt;
	private  BigDecimal  r0110_non_res_nat_amt;
	private  BigDecimal  r0110_over_3_years_nat_amt;
	private  BigDecimal  r0110_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0110_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0110_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0110_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0110_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0110_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0110_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0110_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0110_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0110_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0110_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0110_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0110_product;
	private  BigDecimal  r0110_pro_bought_net_gain_loss;
	private  BigDecimal  r0110_pro_sold_net_gain_loss;
	private  BigDecimal  r0110_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0110_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0110_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0110_res_nat_amt;
	private  BigDecimal  r0110_sold_hedg_net_delta_pos;
	private  BigDecimal  r0110_sold_trad_net_delta_pos;
	private  BigDecimal  r0110_trad_nat_amt;
	private  BigDecimal  r0110_within_1_year_nat_amt;
	private  BigDecimal  r0120_1_to_3_years_nat_amt;
	private  BigDecimal  r0120_bought_hedg_net_delta_pos;
	private  BigDecimal  r0120_bought_trad_net_delta_pos;
	private  BigDecimal  r0120_gross_mkt_val;
	private  BigDecimal  r0120_hedg_nat_amt;
	private  BigDecimal  r0120_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0120_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0120_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0120_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0120_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0120_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0120_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0120_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0120_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0120_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0120_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0120_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0120_nat_amt;
	private  BigDecimal  r0120_non_res_nat_amt;
	private  BigDecimal  r0120_over_3_years_nat_amt;
	private  BigDecimal  r0120_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0120_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0120_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0120_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0120_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0120_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0120_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0120_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0120_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0120_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0120_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0120_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0120_product;
	private  BigDecimal  r0120_pro_bought_net_gain_loss;
	private  BigDecimal  r0120_pro_sold_net_gain_loss;
	private  BigDecimal  r0120_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0120_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0120_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0120_res_nat_amt;
	private  BigDecimal  r0120_sold_hedg_net_delta_pos;
	private  BigDecimal  r0120_sold_trad_net_delta_pos;
	private  BigDecimal  r0120_trad_nat_amt;
	private  BigDecimal  r0120_within_1_year_nat_amt;
	private  BigDecimal  r0130_1_to_3_years_nat_amt;
	private  BigDecimal  r0130_bought_hedg_net_delta_pos;
	private  BigDecimal  r0130_bought_trad_net_delta_pos;
	private  BigDecimal  r0130_gross_mkt_val;
	private  BigDecimal  r0130_hedg_nat_amt;
	private  BigDecimal  r0130_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0130_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0130_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0130_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0130_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0130_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0130_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0130_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0130_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0130_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0130_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0130_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0130_nat_amt;
	private  BigDecimal  r0130_non_res_nat_amt;
	private  BigDecimal  r0130_over_3_years_nat_amt;
	private  BigDecimal  r0130_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0130_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0130_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0130_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0130_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0130_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0130_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0130_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0130_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0130_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0130_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0130_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0130_product;
	private  BigDecimal  r0130_pro_bought_net_gain_loss;
	private  BigDecimal  r0130_pro_sold_net_gain_loss;
	private  BigDecimal  r0130_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0130_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0130_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0130_res_nat_amt;
	private  BigDecimal  r0130_sold_hedg_net_delta_pos;
	private  BigDecimal  r0130_sold_trad_net_delta_pos;
	private  BigDecimal  r0130_trad_nat_amt;
	private  BigDecimal  r0130_within_1_year_nat_amt;
	private  BigDecimal  r0140_1_to_3_years_nat_amt;
	private  BigDecimal  r0140_bought_hedg_net_delta_pos;
	private  BigDecimal  r0140_bought_trad_net_delta_pos;
	private  BigDecimal  r0140_gross_mkt_val;
	private  BigDecimal  r0140_hedg_nat_amt;
	private  BigDecimal  r0140_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0140_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0140_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0140_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0140_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0140_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0140_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0140_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0140_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0140_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0140_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0140_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0140_nat_amt;
	private  BigDecimal  r0140_non_res_nat_amt;
	private  BigDecimal  r0140_over_3_years_nat_amt;
	private  BigDecimal  r0140_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0140_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0140_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0140_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0140_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0140_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0140_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0140_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0140_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0140_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0140_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0140_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0140_product;
	private  BigDecimal  r0140_pro_bought_net_gain_loss;
	private  BigDecimal  r0140_pro_sold_net_gain_loss;
	private  BigDecimal  r0140_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0140_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0140_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0140_res_nat_amt;
	private  BigDecimal  r0140_sold_hedg_net_delta_pos;
	private  BigDecimal  r0140_sold_trad_net_delta_pos;
	private  BigDecimal  r0140_trad_nat_amt;
	private  BigDecimal  r0140_within_1_year_nat_amt;
	private  BigDecimal  r0150_1_to_3_years_nat_amt;
	private  BigDecimal  r0150_bought_hedg_net_delta_pos;
	private  BigDecimal  r0150_bought_trad_net_delta_pos;
	private  BigDecimal  r0150_gross_mkt_val;
	private  BigDecimal  r0150_hedg_nat_amt;
	private  BigDecimal  r0150_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0150_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0150_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0150_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0150_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0150_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0150_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0150_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0150_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0150_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0150_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0150_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0150_nat_amt;
	private  BigDecimal  r0150_non_res_nat_amt;
	private  BigDecimal  r0150_over_3_years_nat_amt;
	private  BigDecimal  r0150_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0150_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0150_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0150_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0150_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0150_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0150_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0150_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0150_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0150_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0150_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0150_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0150_product;
	private  BigDecimal  r0150_pro_bought_net_gain_loss;
	private  BigDecimal  r0150_pro_sold_net_gain_loss;
	private  BigDecimal  r0150_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0150_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0150_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0150_res_nat_amt;
	private  BigDecimal  r0150_sold_hedg_net_delta_pos;
	private  BigDecimal  r0150_sold_trad_net_delta_pos;
	private  BigDecimal  r0150_trad_nat_amt;
	private  BigDecimal  r0150_within_1_year_nat_amt;
	private  BigDecimal  r0160_1_to_3_years_nat_amt;
	private  BigDecimal  r0160_bought_hedg_net_delta_pos;
	private  BigDecimal  r0160_bought_trad_net_delta_pos;
	private  BigDecimal  r0160_gross_mkt_val;
	private  BigDecimal  r0160_hedg_nat_amt;
	private  BigDecimal  r0160_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0160_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0160_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0160_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0160_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0160_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0160_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0160_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0160_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0160_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0160_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0160_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0160_nat_amt;
	private  BigDecimal  r0160_non_res_nat_amt;
	private  BigDecimal  r0160_over_3_years_nat_amt;
	private  BigDecimal  r0160_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0160_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0160_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0160_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0160_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0160_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0160_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0160_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0160_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0160_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0160_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0160_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0160_product;
	private  BigDecimal  r0160_pro_bought_net_gain_loss;
	private  BigDecimal  r0160_pro_sold_net_gain_loss;
	private  BigDecimal  r0160_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0160_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0160_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0160_res_nat_amt;
	private  BigDecimal  r0160_sold_hedg_net_delta_pos;
	private  BigDecimal  r0160_sold_trad_net_delta_pos;
	private  BigDecimal  r0160_trad_nat_amt;
	private  BigDecimal  r0160_within_1_year_nat_amt;
	private  BigDecimal  r0170_1_to_3_years_nat_amt;
	private  BigDecimal  r0170_bought_hedg_net_delta_pos;
	private  BigDecimal  r0170_bought_trad_net_delta_pos;
	private  BigDecimal  r0170_gross_mkt_val;
	private  BigDecimal  r0170_hedg_nat_amt;
	private  BigDecimal  r0170_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0170_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0170_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0170_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0170_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0170_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0170_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0170_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0170_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0170_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0170_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0170_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0170_nat_amt;
	private  BigDecimal  r0170_non_res_nat_amt;
	private  BigDecimal  r0170_over_3_years_nat_amt;
	private  BigDecimal  r0170_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0170_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0170_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0170_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0170_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0170_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0170_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0170_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0170_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0170_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0170_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0170_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0170_product;
	private  BigDecimal  r0170_pro_bought_net_gain_loss;
	private  BigDecimal  r0170_pro_sold_net_gain_loss;
	private  BigDecimal  r0170_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0170_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0170_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0170_res_nat_amt;
	private  BigDecimal  r0170_sold_hedg_net_delta_pos;
	private  BigDecimal  r0170_sold_trad_net_delta_pos;
	private  BigDecimal  r0170_trad_nat_amt;
	private  BigDecimal  r0170_within_1_year_nat_amt;
	private  String  r0180_product;
	private  BigDecimal  r0190_1_to_3_years_nat_amt;
	private  BigDecimal  r0190_bought_hedg_net_delta_pos;
	private  BigDecimal  r0190_bought_trad_net_delta_pos;
	private  BigDecimal  r0190_gross_mkt_val;
	private  BigDecimal  r0190_hedg_nat_amt;
	private  BigDecimal  r0190_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0190_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0190_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0190_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0190_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0190_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0190_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0190_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0190_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0190_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0190_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0190_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0190_nat_amt;
	private  BigDecimal  r0190_non_res_nat_amt;
	private  BigDecimal  r0190_over_3_years_nat_amt;
	private  BigDecimal  r0190_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0190_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0190_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0190_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0190_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0190_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0190_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0190_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0190_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0190_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0190_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0190_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0190_product;
	private  BigDecimal  r0190_pro_bought_net_gain_loss;
	private  BigDecimal  r0190_pro_sold_net_gain_loss;
	private  BigDecimal  r0190_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0190_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0190_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0190_res_nat_amt;
	private  BigDecimal  r0190_sold_hedg_net_delta_pos;
	private  BigDecimal  r0190_sold_trad_net_delta_pos;
	private  BigDecimal  r0190_trad_nat_amt;
	private  BigDecimal  r0190_within_1_year_nat_amt;
	private  BigDecimal  r0200_1_to_3_years_nat_amt;
	private  BigDecimal  r0200_bought_hedg_net_delta_pos;
	private  BigDecimal  r0200_bought_trad_net_delta_pos;
	private  BigDecimal  r0200_gross_mkt_val;
	private  BigDecimal  r0200_hedg_nat_amt;
	private  BigDecimal  r0200_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0200_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0200_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0200_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0200_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0200_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0200_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0200_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0200_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0200_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0200_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0200_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0200_nat_amt;
	private  BigDecimal  r0200_non_res_nat_amt;
	private  BigDecimal  r0200_over_3_years_nat_amt;
	private  BigDecimal  r0200_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0200_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0200_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0200_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0200_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0200_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0200_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0200_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0200_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0200_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0200_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0200_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0200_product;
	private  BigDecimal  r0200_pro_bought_net_gain_loss;
	private  BigDecimal  r0200_pro_sold_net_gain_loss;
	private  BigDecimal  r0200_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0200_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0200_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0200_res_nat_amt;
	private  BigDecimal  r0200_sold_hedg_net_delta_pos;
	private  BigDecimal  r0200_sold_trad_net_delta_pos;
	private  BigDecimal  r0200_trad_nat_amt;
	private  BigDecimal  r0200_within_1_year_nat_amt;
	private  BigDecimal  r0210_1_to_3_years_nat_amt;
	private  BigDecimal  r0210_bought_hedg_net_delta_pos;
	private  BigDecimal  r0210_bought_trad_net_delta_pos;
	private  BigDecimal  r0210_gross_mkt_val;
	private  BigDecimal  r0210_hedg_nat_amt;
	private  BigDecimal  r0210_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0210_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0210_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0210_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0210_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0210_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0210_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0210_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0210_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0210_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0210_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0210_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0210_nat_amt;
	private  BigDecimal  r0210_non_res_nat_amt;
	private  BigDecimal  r0210_over_3_years_nat_amt;
	private  BigDecimal  r0210_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0210_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0210_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0210_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0210_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0210_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0210_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0210_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0210_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0210_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0210_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0210_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0210_product;
	private  BigDecimal  r0210_pro_bought_net_gain_loss;
	private  BigDecimal  r0210_pro_sold_net_gain_loss;
	private  BigDecimal  r0210_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0210_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0210_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0210_res_nat_amt;
	private  BigDecimal  r0210_sold_hedg_net_delta_pos;
	private  BigDecimal  r0210_sold_trad_net_delta_pos;
	private  BigDecimal  r0210_trad_nat_amt;
	private  BigDecimal  r0210_within_1_year_nat_amt;
	private  BigDecimal  r0220_1_to_3_years_nat_amt;
	private  BigDecimal  r0220_bought_hedg_net_delta_pos;
	private  BigDecimal  r0220_bought_trad_net_delta_pos;
	private  BigDecimal  r0220_gross_mkt_val;
	private  BigDecimal  r0220_hedg_nat_amt;
	private  BigDecimal  r0220_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0220_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0220_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0220_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0220_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0220_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0220_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0220_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0220_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0220_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0220_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0220_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0220_nat_amt;
	private  BigDecimal  r0220_non_res_nat_amt;
	private  BigDecimal  r0220_over_3_years_nat_amt;
	private  BigDecimal  r0220_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0220_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0220_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0220_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0220_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0220_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0220_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0220_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0220_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0220_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0220_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0220_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0220_product;
	private  BigDecimal  r0220_pro_bought_net_gain_loss;
	private  BigDecimal  r0220_pro_sold_net_gain_loss;
	private  BigDecimal  r0220_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0220_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0220_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0220_res_nat_amt;
	private  BigDecimal  r0220_sold_hedg_net_delta_pos;
	private  BigDecimal  r0220_sold_trad_net_delta_pos;
	private  BigDecimal  r0220_trad_nat_amt;
	private  BigDecimal  r0220_within_1_year_nat_amt;
	private  BigDecimal  r0230_1_to_3_years_nat_amt;
	private  BigDecimal  r0230_bought_hedg_net_delta_pos;
	private  BigDecimal  r0230_bought_trad_net_delta_pos;
	private  BigDecimal  r0230_gross_mkt_val;
	private  BigDecimal  r0230_hedg_nat_amt;
	private  BigDecimal  r0230_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0230_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0230_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0230_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0230_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0230_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0230_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0230_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0230_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0230_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0230_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0230_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0230_nat_amt;
	private  BigDecimal  r0230_non_res_nat_amt;
	private  BigDecimal  r0230_over_3_years_nat_amt;
	private  BigDecimal  r0230_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0230_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0230_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0230_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0230_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0230_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0230_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0230_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0230_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0230_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0230_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0230_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0230_product;
	private  BigDecimal  r0230_pro_bought_net_gain_loss;
	private  BigDecimal  r0230_pro_sold_net_gain_loss;
	private  BigDecimal  r0230_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0230_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0230_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0230_res_nat_amt;
	private  BigDecimal  r0230_sold_hedg_net_delta_pos;
	private  BigDecimal  r0230_sold_trad_net_delta_pos;
	private  BigDecimal  r0230_trad_nat_amt;
	private  BigDecimal  r0230_within_1_year_nat_amt;
	private  BigDecimal  r0240_1_to_3_years_nat_amt;
	private  BigDecimal  r0240_bought_hedg_net_delta_pos;
	private  BigDecimal  r0240_bought_trad_net_delta_pos;
	private  BigDecimal  r0240_gross_mkt_val;
	private  BigDecimal  r0240_hedg_nat_amt;
	private  BigDecimal  r0240_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0240_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0240_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0240_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0240_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0240_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0240_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0240_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0240_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0240_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0240_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0240_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0240_nat_amt;
	private  BigDecimal  r0240_non_res_nat_amt;
	private  BigDecimal  r0240_over_3_years_nat_amt;
	private  BigDecimal  r0240_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0240_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0240_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0240_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0240_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0240_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0240_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0240_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0240_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0240_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0240_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0240_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0240_product;
	private  BigDecimal  r0240_pro_bought_net_gain_loss;
	private  BigDecimal  r0240_pro_sold_net_gain_loss;
	private  BigDecimal  r0240_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0240_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0240_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0240_res_nat_amt;
	private  BigDecimal  r0240_sold_hedg_net_delta_pos;
	private  BigDecimal  r0240_sold_trad_net_delta_pos;
	private  BigDecimal  r0240_trad_nat_amt;
	private  BigDecimal  r0240_within_1_year_nat_amt;
	private  BigDecimal  r0250_1_to_3_years_nat_amt;
	private  BigDecimal  r0250_bought_hedg_net_delta_pos;
	private  BigDecimal  r0250_bought_trad_net_delta_pos;
	private  BigDecimal  r0250_gross_mkt_val;
	private  BigDecimal  r0250_hedg_nat_amt;
	private  BigDecimal  r0250_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0250_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0250_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0250_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0250_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0250_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0250_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0250_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0250_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0250_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0250_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0250_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0250_nat_amt;
	private  BigDecimal  r0250_non_res_nat_amt;
	private  BigDecimal  r0250_over_3_years_nat_amt;
	private  BigDecimal  r0250_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0250_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0250_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0250_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0250_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0250_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0250_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0250_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0250_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0250_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0250_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0250_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0250_product;
	private  BigDecimal  r0250_pro_bought_net_gain_loss;
	private  BigDecimal  r0250_pro_sold_net_gain_loss;
	private  BigDecimal  r0250_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0250_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0250_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0250_res_nat_amt;
	private  BigDecimal  r0250_sold_hedg_net_delta_pos;
	private  BigDecimal  r0250_sold_trad_net_delta_pos;
	private  BigDecimal  r0250_trad_nat_amt;
	private  BigDecimal  r0250_within_1_year_nat_amt;
	private  BigDecimal  r0260_1_to_3_years_nat_amt;
	private  BigDecimal  r0260_bought_hedg_net_delta_pos;
	private  BigDecimal  r0260_bought_trad_net_delta_pos;
	private  BigDecimal  r0260_gross_mkt_val;
	private  BigDecimal  r0260_hedg_nat_amt;
	private  BigDecimal  r0260_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0260_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0260_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0260_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0260_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0260_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0260_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0260_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0260_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0260_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0260_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0260_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  BigDecimal  r0260_nat_amt;
	private  BigDecimal  r0260_non_res_nat_amt;
	private  BigDecimal  r0260_over_3_years_nat_amt;
	private  BigDecimal  r0260_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0260_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0260_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0260_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	private  BigDecimal  r0260_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	private  BigDecimal  r0260_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	private  BigDecimal  r0260_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	private  BigDecimal  r0260_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	private  BigDecimal  r0260_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	private  BigDecimal  r0260_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	private  BigDecimal  r0260_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	private  BigDecimal  r0260_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	private  String  r0260_product;
	private  BigDecimal  r0260_pro_bought_net_gain_loss;
	private  BigDecimal  r0260_pro_sold_net_gain_loss;
	private  BigDecimal  r0260_res_1_to_3_years_mkt_val;
	private  BigDecimal  r0260_res_lessthan_1_year_mkt_val;
	private  BigDecimal  r0260_res_morethan_3_years_mkt_val;
	private  BigDecimal  r0260_res_nat_amt;
	private  BigDecimal  r0260_sold_hedg_net_delta_pos;
	private  BigDecimal  r0260_sold_trad_net_delta_pos;
	private  BigDecimal  r0260_trad_nat_amt;
	private  BigDecimal  r0260_within_1_year_nat_amt;
	private  BigDecimal  report_code;
	@Id    
	private  Date  report_date;
	private  BigDecimal  report_desc;
	private  BigDecimal  report_frequency;
	private  BigDecimal  report_version;
	public String getR0010_product() {
		return r0010_product;
	}
	public void setR0010_product(String r0010_product) {
		this.r0010_product = r0010_product;
	}
	public String getR0020_product() {
		return r0020_product;
	}
	public void setR0020_product(String r0020_product) {
		this.r0020_product = r0020_product;
	}
	public BigDecimal getR0030_1_to_3_years_nat_amt() {
		return r0030_1_to_3_years_nat_amt;
	}
	public void setR0030_1_to_3_years_nat_amt(BigDecimal r0030_1_to_3_years_nat_amt) {
		this.r0030_1_to_3_years_nat_amt = r0030_1_to_3_years_nat_amt;
	}
	public BigDecimal getR0030_bought_hedg_net_delta_pos() {
		return r0030_bought_hedg_net_delta_pos;
	}
	public void setR0030_bought_hedg_net_delta_pos(BigDecimal r0030_bought_hedg_net_delta_pos) {
		this.r0030_bought_hedg_net_delta_pos = r0030_bought_hedg_net_delta_pos;
	}
	public BigDecimal getR0030_bought_trad_net_delta_pos() {
		return r0030_bought_trad_net_delta_pos;
	}
	public void setR0030_bought_trad_net_delta_pos(BigDecimal r0030_bought_trad_net_delta_pos) {
		this.r0030_bought_trad_net_delta_pos = r0030_bought_trad_net_delta_pos;
	}
	public BigDecimal getR0030_gross_mkt_val() {
		return r0030_gross_mkt_val;
	}
	public void setR0030_gross_mkt_val(BigDecimal r0030_gross_mkt_val) {
		this.r0030_gross_mkt_val = r0030_gross_mkt_val;
	}
	public BigDecimal getR0030_hedg_nat_amt() {
		return r0030_hedg_nat_amt;
	}
	public void setR0030_hedg_nat_amt(BigDecimal r0030_hedg_nat_amt) {
		this.r0030_hedg_nat_amt = r0030_hedg_nat_amt;
	}
	public BigDecimal getR0030_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0030_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0030_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0030_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0030_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0030_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0030_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0030_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0030_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0030_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0030_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0030_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0030_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0030_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0030_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0030_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0030_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0030_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0030_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0030_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0030_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0030_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0030_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0030_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0030_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0030_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0030_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0030_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0030_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0030_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0030_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0030_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0030_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0030_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0030_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0030_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0030_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0030_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0030_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0030_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0030_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0030_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0030_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0030_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0030_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0030_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0030_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0030_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0030_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0030_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0030_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0030_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0030_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0030_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0030_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0030_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0030_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0030_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0030_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0030_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0030_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0030_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0030_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0030_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0030_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0030_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0030_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0030_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0030_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0030_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0030_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0030_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public BigDecimal getR0030_nat_amt() {
		return r0030_nat_amt;
	}
	public void setR0030_nat_amt(BigDecimal r0030_nat_amt) {
		this.r0030_nat_amt = r0030_nat_amt;
	}
	public BigDecimal getR0030_non_res_nat_amt() {
		return r0030_non_res_nat_amt;
	}
	public void setR0030_non_res_nat_amt(BigDecimal r0030_non_res_nat_amt) {
		this.r0030_non_res_nat_amt = r0030_non_res_nat_amt;
	}
	public BigDecimal getR0030_over_3_years_nat_amt() {
		return r0030_over_3_years_nat_amt;
	}
	public void setR0030_over_3_years_nat_amt(BigDecimal r0030_over_3_years_nat_amt) {
		this.r0030_over_3_years_nat_amt = r0030_over_3_years_nat_amt;
	}
	public BigDecimal getR0030_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0030_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0030_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0030_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0030_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0030_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0030_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0030_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0030_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0030_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0030_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0030_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0030_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0030_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0030_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0030_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0030_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0030_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0030_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0030_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0030_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0030_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0030_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0030_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0030_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0030_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0030_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0030_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0030_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0030_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0030_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0030_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0030_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0030_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0030_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0030_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0030_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0030_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0030_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0030_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0030_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0030_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0030_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0030_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0030_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0030_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0030_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0030_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0030_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0030_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0030_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0030_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0030_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0030_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0030_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0030_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0030_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0030_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0030_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0030_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0030_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0030_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0030_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0030_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0030_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0030_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0030_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0030_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0030_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0030_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0030_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0030_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public String getR0030_product() {
		return r0030_product;
	}
	public void setR0030_product(String r0030_product) {
		this.r0030_product = r0030_product;
	}
	public BigDecimal getR0030_pro_bought_net_gain_loss() {
		return r0030_pro_bought_net_gain_loss;
	}
	public void setR0030_pro_bought_net_gain_loss(BigDecimal r0030_pro_bought_net_gain_loss) {
		this.r0030_pro_bought_net_gain_loss = r0030_pro_bought_net_gain_loss;
	}
	public BigDecimal getR0030_pro_sold_net_gain_loss() {
		return r0030_pro_sold_net_gain_loss;
	}
	public void setR0030_pro_sold_net_gain_loss(BigDecimal r0030_pro_sold_net_gain_loss) {
		this.r0030_pro_sold_net_gain_loss = r0030_pro_sold_net_gain_loss;
	}
	public BigDecimal getR0030_res_1_to_3_years_mkt_val() {
		return r0030_res_1_to_3_years_mkt_val;
	}
	public void setR0030_res_1_to_3_years_mkt_val(BigDecimal r0030_res_1_to_3_years_mkt_val) {
		this.r0030_res_1_to_3_years_mkt_val = r0030_res_1_to_3_years_mkt_val;
	}
	public BigDecimal getR0030_res_lessthan_1_year_mkt_val() {
		return r0030_res_lessthan_1_year_mkt_val;
	}
	public void setR0030_res_lessthan_1_year_mkt_val(BigDecimal r0030_res_lessthan_1_year_mkt_val) {
		this.r0030_res_lessthan_1_year_mkt_val = r0030_res_lessthan_1_year_mkt_val;
	}
	public BigDecimal getR0030_res_morethan_3_years_mkt_val() {
		return r0030_res_morethan_3_years_mkt_val;
	}
	public void setR0030_res_morethan_3_years_mkt_val(BigDecimal r0030_res_morethan_3_years_mkt_val) {
		this.r0030_res_morethan_3_years_mkt_val = r0030_res_morethan_3_years_mkt_val;
	}
	public BigDecimal getR0030_res_nat_amt() {
		return r0030_res_nat_amt;
	}
	public void setR0030_res_nat_amt(BigDecimal r0030_res_nat_amt) {
		this.r0030_res_nat_amt = r0030_res_nat_amt;
	}
	public BigDecimal getR0030_sold_hedg_net_delta_pos() {
		return r0030_sold_hedg_net_delta_pos;
	}
	public void setR0030_sold_hedg_net_delta_pos(BigDecimal r0030_sold_hedg_net_delta_pos) {
		this.r0030_sold_hedg_net_delta_pos = r0030_sold_hedg_net_delta_pos;
	}
	public BigDecimal getR0030_sold_trad_net_delta_pos() {
		return r0030_sold_trad_net_delta_pos;
	}
	public void setR0030_sold_trad_net_delta_pos(BigDecimal r0030_sold_trad_net_delta_pos) {
		this.r0030_sold_trad_net_delta_pos = r0030_sold_trad_net_delta_pos;
	}
	public BigDecimal getR0030_trad_nat_amt() {
		return r0030_trad_nat_amt;
	}
	public void setR0030_trad_nat_amt(BigDecimal r0030_trad_nat_amt) {
		this.r0030_trad_nat_amt = r0030_trad_nat_amt;
	}
	public BigDecimal getR0030_within_1_year_nat_amt() {
		return r0030_within_1_year_nat_amt;
	}
	public void setR0030_within_1_year_nat_amt(BigDecimal r0030_within_1_year_nat_amt) {
		this.r0030_within_1_year_nat_amt = r0030_within_1_year_nat_amt;
	}
	public BigDecimal getR0040_1_to_3_years_nat_amt() {
		return r0040_1_to_3_years_nat_amt;
	}
	public void setR0040_1_to_3_years_nat_amt(BigDecimal r0040_1_to_3_years_nat_amt) {
		this.r0040_1_to_3_years_nat_amt = r0040_1_to_3_years_nat_amt;
	}
	public BigDecimal getR0040_bought_hedg_net_delta_pos() {
		return r0040_bought_hedg_net_delta_pos;
	}
	public void setR0040_bought_hedg_net_delta_pos(BigDecimal r0040_bought_hedg_net_delta_pos) {
		this.r0040_bought_hedg_net_delta_pos = r0040_bought_hedg_net_delta_pos;
	}
	public BigDecimal getR0040_bought_trad_net_delta_pos() {
		return r0040_bought_trad_net_delta_pos;
	}
	public void setR0040_bought_trad_net_delta_pos(BigDecimal r0040_bought_trad_net_delta_pos) {
		this.r0040_bought_trad_net_delta_pos = r0040_bought_trad_net_delta_pos;
	}
	public BigDecimal getR0040_gross_mkt_val() {
		return r0040_gross_mkt_val;
	}
	public void setR0040_gross_mkt_val(BigDecimal r0040_gross_mkt_val) {
		this.r0040_gross_mkt_val = r0040_gross_mkt_val;
	}
	public BigDecimal getR0040_hedg_nat_amt() {
		return r0040_hedg_nat_amt;
	}
	public void setR0040_hedg_nat_amt(BigDecimal r0040_hedg_nat_amt) {
		this.r0040_hedg_nat_amt = r0040_hedg_nat_amt;
	}
	public BigDecimal getR0040_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0040_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0040_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0040_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0040_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0040_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0040_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0040_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0040_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0040_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0040_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0040_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0040_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0040_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0040_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0040_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0040_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0040_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0040_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0040_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0040_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0040_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0040_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0040_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0040_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0040_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0040_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0040_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0040_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0040_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0040_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0040_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0040_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0040_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0040_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0040_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0040_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0040_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0040_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0040_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0040_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0040_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0040_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0040_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0040_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0040_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0040_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0040_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0040_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0040_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0040_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0040_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0040_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0040_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0040_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0040_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0040_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0040_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0040_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0040_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0040_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0040_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0040_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0040_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0040_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0040_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0040_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0040_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0040_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0040_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0040_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0040_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public BigDecimal getR0040_nat_amt() {
		return r0040_nat_amt;
	}
	public void setR0040_nat_amt(BigDecimal r0040_nat_amt) {
		this.r0040_nat_amt = r0040_nat_amt;
	}
	public BigDecimal getR0040_non_res_nat_amt() {
		return r0040_non_res_nat_amt;
	}
	public void setR0040_non_res_nat_amt(BigDecimal r0040_non_res_nat_amt) {
		this.r0040_non_res_nat_amt = r0040_non_res_nat_amt;
	}
	public BigDecimal getR0040_over_3_years_nat_amt() {
		return r0040_over_3_years_nat_amt;
	}
	public void setR0040_over_3_years_nat_amt(BigDecimal r0040_over_3_years_nat_amt) {
		this.r0040_over_3_years_nat_amt = r0040_over_3_years_nat_amt;
	}
	public BigDecimal getR0040_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0040_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0040_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0040_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0040_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0040_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0040_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0040_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0040_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0040_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0040_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0040_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0040_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0040_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0040_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0040_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0040_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0040_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0040_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0040_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0040_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0040_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0040_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0040_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0040_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0040_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0040_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0040_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0040_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0040_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0040_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0040_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0040_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0040_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0040_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0040_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0040_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0040_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0040_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0040_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0040_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0040_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0040_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0040_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0040_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0040_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0040_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0040_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0040_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0040_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0040_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0040_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0040_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0040_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0040_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0040_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0040_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0040_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0040_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0040_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0040_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0040_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0040_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0040_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0040_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0040_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0040_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0040_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0040_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0040_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0040_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0040_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public String getR0040_product() {
		return r0040_product;
	}
	public void setR0040_product(String r0040_product) {
		this.r0040_product = r0040_product;
	}
	public BigDecimal getR0040_pro_bought_net_gain_loss() {
		return r0040_pro_bought_net_gain_loss;
	}
	public void setR0040_pro_bought_net_gain_loss(BigDecimal r0040_pro_bought_net_gain_loss) {
		this.r0040_pro_bought_net_gain_loss = r0040_pro_bought_net_gain_loss;
	}
	public BigDecimal getR0040_pro_sold_net_gain_loss() {
		return r0040_pro_sold_net_gain_loss;
	}
	public void setR0040_pro_sold_net_gain_loss(BigDecimal r0040_pro_sold_net_gain_loss) {
		this.r0040_pro_sold_net_gain_loss = r0040_pro_sold_net_gain_loss;
	}
	public BigDecimal getR0040_res_1_to_3_years_mkt_val() {
		return r0040_res_1_to_3_years_mkt_val;
	}
	public void setR0040_res_1_to_3_years_mkt_val(BigDecimal r0040_res_1_to_3_years_mkt_val) {
		this.r0040_res_1_to_3_years_mkt_val = r0040_res_1_to_3_years_mkt_val;
	}
	public BigDecimal getR0040_res_lessthan_1_year_mkt_val() {
		return r0040_res_lessthan_1_year_mkt_val;
	}
	public void setR0040_res_lessthan_1_year_mkt_val(BigDecimal r0040_res_lessthan_1_year_mkt_val) {
		this.r0040_res_lessthan_1_year_mkt_val = r0040_res_lessthan_1_year_mkt_val;
	}
	public BigDecimal getR0040_res_morethan_3_years_mkt_val() {
		return r0040_res_morethan_3_years_mkt_val;
	}
	public void setR0040_res_morethan_3_years_mkt_val(BigDecimal r0040_res_morethan_3_years_mkt_val) {
		this.r0040_res_morethan_3_years_mkt_val = r0040_res_morethan_3_years_mkt_val;
	}
	public BigDecimal getR0040_res_nat_amt() {
		return r0040_res_nat_amt;
	}
	public void setR0040_res_nat_amt(BigDecimal r0040_res_nat_amt) {
		this.r0040_res_nat_amt = r0040_res_nat_amt;
	}
	public BigDecimal getR0040_sold_hedg_net_delta_pos() {
		return r0040_sold_hedg_net_delta_pos;
	}
	public void setR0040_sold_hedg_net_delta_pos(BigDecimal r0040_sold_hedg_net_delta_pos) {
		this.r0040_sold_hedg_net_delta_pos = r0040_sold_hedg_net_delta_pos;
	}
	public BigDecimal getR0040_sold_trad_net_delta_pos() {
		return r0040_sold_trad_net_delta_pos;
	}
	public void setR0040_sold_trad_net_delta_pos(BigDecimal r0040_sold_trad_net_delta_pos) {
		this.r0040_sold_trad_net_delta_pos = r0040_sold_trad_net_delta_pos;
	}
	public BigDecimal getR0040_trad_nat_amt() {
		return r0040_trad_nat_amt;
	}
	public void setR0040_trad_nat_amt(BigDecimal r0040_trad_nat_amt) {
		this.r0040_trad_nat_amt = r0040_trad_nat_amt;
	}
	public BigDecimal getR0040_within_1_year_nat_amt() {
		return r0040_within_1_year_nat_amt;
	}
	public void setR0040_within_1_year_nat_amt(BigDecimal r0040_within_1_year_nat_amt) {
		this.r0040_within_1_year_nat_amt = r0040_within_1_year_nat_amt;
	}
	public BigDecimal getR0050_1_to_3_years_nat_amt() {
		return r0050_1_to_3_years_nat_amt;
	}
	public void setR0050_1_to_3_years_nat_amt(BigDecimal r0050_1_to_3_years_nat_amt) {
		this.r0050_1_to_3_years_nat_amt = r0050_1_to_3_years_nat_amt;
	}
	public BigDecimal getR0050_bought_hedg_net_delta_pos() {
		return r0050_bought_hedg_net_delta_pos;
	}
	public void setR0050_bought_hedg_net_delta_pos(BigDecimal r0050_bought_hedg_net_delta_pos) {
		this.r0050_bought_hedg_net_delta_pos = r0050_bought_hedg_net_delta_pos;
	}
	public BigDecimal getR0050_bought_trad_net_delta_pos() {
		return r0050_bought_trad_net_delta_pos;
	}
	public void setR0050_bought_trad_net_delta_pos(BigDecimal r0050_bought_trad_net_delta_pos) {
		this.r0050_bought_trad_net_delta_pos = r0050_bought_trad_net_delta_pos;
	}
	public BigDecimal getR0050_gross_mkt_val() {
		return r0050_gross_mkt_val;
	}
	public void setR0050_gross_mkt_val(BigDecimal r0050_gross_mkt_val) {
		this.r0050_gross_mkt_val = r0050_gross_mkt_val;
	}
	public BigDecimal getR0050_hedg_nat_amt() {
		return r0050_hedg_nat_amt;
	}
	public void setR0050_hedg_nat_amt(BigDecimal r0050_hedg_nat_amt) {
		this.r0050_hedg_nat_amt = r0050_hedg_nat_amt;
	}
	public BigDecimal getR0050_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0050_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0050_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0050_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0050_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0050_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0050_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0050_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0050_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0050_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0050_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0050_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0050_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0050_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0050_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0050_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0050_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0050_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0050_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0050_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0050_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0050_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0050_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0050_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0050_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0050_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0050_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0050_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0050_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0050_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0050_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0050_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0050_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0050_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0050_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0050_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0050_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0050_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0050_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0050_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0050_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0050_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0050_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0050_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0050_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0050_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0050_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0050_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0050_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0050_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0050_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0050_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0050_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0050_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0050_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0050_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0050_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0050_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0050_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0050_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0050_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0050_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0050_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0050_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0050_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0050_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0050_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0050_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0050_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0050_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0050_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0050_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public BigDecimal getR0050_nat_amt() {
		return r0050_nat_amt;
	}
	public void setR0050_nat_amt(BigDecimal r0050_nat_amt) {
		this.r0050_nat_amt = r0050_nat_amt;
	}
	public BigDecimal getR0050_non_res_nat_amt() {
		return r0050_non_res_nat_amt;
	}
	public void setR0050_non_res_nat_amt(BigDecimal r0050_non_res_nat_amt) {
		this.r0050_non_res_nat_amt = r0050_non_res_nat_amt;
	}
	public BigDecimal getR0050_over_3_years_nat_amt() {
		return r0050_over_3_years_nat_amt;
	}
	public void setR0050_over_3_years_nat_amt(BigDecimal r0050_over_3_years_nat_amt) {
		this.r0050_over_3_years_nat_amt = r0050_over_3_years_nat_amt;
	}
	public BigDecimal getR0050_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0050_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0050_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0050_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0050_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0050_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0050_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0050_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0050_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0050_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0050_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0050_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0050_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0050_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0050_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0050_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0050_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0050_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0050_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0050_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0050_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0050_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0050_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0050_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0050_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0050_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0050_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0050_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0050_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0050_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0050_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0050_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0050_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0050_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0050_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0050_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0050_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0050_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0050_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0050_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0050_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0050_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0050_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0050_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0050_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0050_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0050_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0050_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0050_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0050_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0050_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0050_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0050_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0050_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0050_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0050_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0050_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0050_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0050_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0050_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0050_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0050_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0050_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0050_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0050_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0050_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0050_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0050_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0050_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0050_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0050_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0050_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public String getR0050_product() {
		return r0050_product;
	}
	public void setR0050_product(String r0050_product) {
		this.r0050_product = r0050_product;
	}
	public BigDecimal getR0050_pro_bought_net_gain_loss() {
		return r0050_pro_bought_net_gain_loss;
	}
	public void setR0050_pro_bought_net_gain_loss(BigDecimal r0050_pro_bought_net_gain_loss) {
		this.r0050_pro_bought_net_gain_loss = r0050_pro_bought_net_gain_loss;
	}
	public BigDecimal getR0050_pro_sold_net_gain_loss() {
		return r0050_pro_sold_net_gain_loss;
	}
	public void setR0050_pro_sold_net_gain_loss(BigDecimal r0050_pro_sold_net_gain_loss) {
		this.r0050_pro_sold_net_gain_loss = r0050_pro_sold_net_gain_loss;
	}
	public BigDecimal getR0050_res_1_to_3_years_mkt_val() {
		return r0050_res_1_to_3_years_mkt_val;
	}
	public void setR0050_res_1_to_3_years_mkt_val(BigDecimal r0050_res_1_to_3_years_mkt_val) {
		this.r0050_res_1_to_3_years_mkt_val = r0050_res_1_to_3_years_mkt_val;
	}
	public BigDecimal getR0050_res_lessthan_1_year_mkt_val() {
		return r0050_res_lessthan_1_year_mkt_val;
	}
	public void setR0050_res_lessthan_1_year_mkt_val(BigDecimal r0050_res_lessthan_1_year_mkt_val) {
		this.r0050_res_lessthan_1_year_mkt_val = r0050_res_lessthan_1_year_mkt_val;
	}
	public BigDecimal getR0050_res_morethan_3_years_mkt_val() {
		return r0050_res_morethan_3_years_mkt_val;
	}
	public void setR0050_res_morethan_3_years_mkt_val(BigDecimal r0050_res_morethan_3_years_mkt_val) {
		this.r0050_res_morethan_3_years_mkt_val = r0050_res_morethan_3_years_mkt_val;
	}
	public BigDecimal getR0050_res_nat_amt() {
		return r0050_res_nat_amt;
	}
	public void setR0050_res_nat_amt(BigDecimal r0050_res_nat_amt) {
		this.r0050_res_nat_amt = r0050_res_nat_amt;
	}
	public BigDecimal getR0050_sold_hedg_net_delta_pos() {
		return r0050_sold_hedg_net_delta_pos;
	}
	public void setR0050_sold_hedg_net_delta_pos(BigDecimal r0050_sold_hedg_net_delta_pos) {
		this.r0050_sold_hedg_net_delta_pos = r0050_sold_hedg_net_delta_pos;
	}
	public BigDecimal getR0050_sold_trad_net_delta_pos() {
		return r0050_sold_trad_net_delta_pos;
	}
	public void setR0050_sold_trad_net_delta_pos(BigDecimal r0050_sold_trad_net_delta_pos) {
		this.r0050_sold_trad_net_delta_pos = r0050_sold_trad_net_delta_pos;
	}
	public BigDecimal getR0050_trad_nat_amt() {
		return r0050_trad_nat_amt;
	}
	public void setR0050_trad_nat_amt(BigDecimal r0050_trad_nat_amt) {
		this.r0050_trad_nat_amt = r0050_trad_nat_amt;
	}
	public BigDecimal getR0050_within_1_year_nat_amt() {
		return r0050_within_1_year_nat_amt;
	}
	public void setR0050_within_1_year_nat_amt(BigDecimal r0050_within_1_year_nat_amt) {
		this.r0050_within_1_year_nat_amt = r0050_within_1_year_nat_amt;
	}
	public BigDecimal getR0060_1_to_3_years_nat_amt() {
		return r0060_1_to_3_years_nat_amt;
	}
	public void setR0060_1_to_3_years_nat_amt(BigDecimal r0060_1_to_3_years_nat_amt) {
		this.r0060_1_to_3_years_nat_amt = r0060_1_to_3_years_nat_amt;
	}
	public BigDecimal getR0060_bought_hedg_net_delta_pos() {
		return r0060_bought_hedg_net_delta_pos;
	}
	public void setR0060_bought_hedg_net_delta_pos(BigDecimal r0060_bought_hedg_net_delta_pos) {
		this.r0060_bought_hedg_net_delta_pos = r0060_bought_hedg_net_delta_pos;
	}
	public BigDecimal getR0060_bought_trad_net_delta_pos() {
		return r0060_bought_trad_net_delta_pos;
	}
	public void setR0060_bought_trad_net_delta_pos(BigDecimal r0060_bought_trad_net_delta_pos) {
		this.r0060_bought_trad_net_delta_pos = r0060_bought_trad_net_delta_pos;
	}
	public BigDecimal getR0060_gross_mkt_val() {
		return r0060_gross_mkt_val;
	}
	public void setR0060_gross_mkt_val(BigDecimal r0060_gross_mkt_val) {
		this.r0060_gross_mkt_val = r0060_gross_mkt_val;
	}
	public BigDecimal getR0060_hedg_nat_amt() {
		return r0060_hedg_nat_amt;
	}
	public void setR0060_hedg_nat_amt(BigDecimal r0060_hedg_nat_amt) {
		this.r0060_hedg_nat_amt = r0060_hedg_nat_amt;
	}
	public BigDecimal getR0060_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0060_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0060_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0060_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0060_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0060_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0060_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0060_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0060_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0060_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0060_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0060_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0060_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0060_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0060_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0060_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0060_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0060_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0060_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0060_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0060_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0060_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0060_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0060_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0060_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0060_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0060_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0060_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0060_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0060_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0060_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0060_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0060_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0060_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0060_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0060_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0060_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0060_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0060_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0060_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0060_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0060_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0060_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0060_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0060_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0060_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0060_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0060_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0060_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0060_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0060_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0060_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0060_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0060_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0060_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0060_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0060_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0060_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0060_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0060_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0060_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0060_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0060_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0060_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0060_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0060_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0060_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0060_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0060_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0060_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0060_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0060_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public BigDecimal getR0060_nat_amt() {
		return r0060_nat_amt;
	}
	public void setR0060_nat_amt(BigDecimal r0060_nat_amt) {
		this.r0060_nat_amt = r0060_nat_amt;
	}
	public BigDecimal getR0060_non_res_nat_amt() {
		return r0060_non_res_nat_amt;
	}
	public void setR0060_non_res_nat_amt(BigDecimal r0060_non_res_nat_amt) {
		this.r0060_non_res_nat_amt = r0060_non_res_nat_amt;
	}
	public BigDecimal getR0060_over_3_years_nat_amt() {
		return r0060_over_3_years_nat_amt;
	}
	public void setR0060_over_3_years_nat_amt(BigDecimal r0060_over_3_years_nat_amt) {
		this.r0060_over_3_years_nat_amt = r0060_over_3_years_nat_amt;
	}
	public BigDecimal getR0060_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0060_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0060_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0060_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0060_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0060_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0060_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0060_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0060_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0060_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0060_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0060_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0060_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0060_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0060_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0060_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0060_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0060_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0060_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0060_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0060_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0060_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0060_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0060_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0060_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0060_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0060_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0060_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0060_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0060_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0060_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0060_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0060_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0060_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0060_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0060_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0060_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0060_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0060_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0060_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0060_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0060_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0060_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0060_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0060_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0060_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0060_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0060_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0060_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0060_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0060_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0060_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0060_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0060_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0060_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0060_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0060_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0060_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0060_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0060_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0060_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0060_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0060_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0060_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0060_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0060_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0060_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0060_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0060_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0060_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0060_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0060_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public String getR0060_product() {
		return r0060_product;
	}
	public void setR0060_product(String r0060_product) {
		this.r0060_product = r0060_product;
	}
	public BigDecimal getR0060_pro_bought_net_gain_loss() {
		return r0060_pro_bought_net_gain_loss;
	}
	public void setR0060_pro_bought_net_gain_loss(BigDecimal r0060_pro_bought_net_gain_loss) {
		this.r0060_pro_bought_net_gain_loss = r0060_pro_bought_net_gain_loss;
	}
	public BigDecimal getR0060_pro_sold_net_gain_loss() {
		return r0060_pro_sold_net_gain_loss;
	}
	public void setR0060_pro_sold_net_gain_loss(BigDecimal r0060_pro_sold_net_gain_loss) {
		this.r0060_pro_sold_net_gain_loss = r0060_pro_sold_net_gain_loss;
	}
	public BigDecimal getR0060_res_1_to_3_years_mkt_val() {
		return r0060_res_1_to_3_years_mkt_val;
	}
	public void setR0060_res_1_to_3_years_mkt_val(BigDecimal r0060_res_1_to_3_years_mkt_val) {
		this.r0060_res_1_to_3_years_mkt_val = r0060_res_1_to_3_years_mkt_val;
	}
	public BigDecimal getR0060_res_lessthan_1_year_mkt_val() {
		return r0060_res_lessthan_1_year_mkt_val;
	}
	public void setR0060_res_lessthan_1_year_mkt_val(BigDecimal r0060_res_lessthan_1_year_mkt_val) {
		this.r0060_res_lessthan_1_year_mkt_val = r0060_res_lessthan_1_year_mkt_val;
	}
	public BigDecimal getR0060_res_morethan_3_years_mkt_val() {
		return r0060_res_morethan_3_years_mkt_val;
	}
	public void setR0060_res_morethan_3_years_mkt_val(BigDecimal r0060_res_morethan_3_years_mkt_val) {
		this.r0060_res_morethan_3_years_mkt_val = r0060_res_morethan_3_years_mkt_val;
	}
	public BigDecimal getR0060_res_nat_amt() {
		return r0060_res_nat_amt;
	}
	public void setR0060_res_nat_amt(BigDecimal r0060_res_nat_amt) {
		this.r0060_res_nat_amt = r0060_res_nat_amt;
	}
	public BigDecimal getR0060_sold_hedg_net_delta_pos() {
		return r0060_sold_hedg_net_delta_pos;
	}
	public void setR0060_sold_hedg_net_delta_pos(BigDecimal r0060_sold_hedg_net_delta_pos) {
		this.r0060_sold_hedg_net_delta_pos = r0060_sold_hedg_net_delta_pos;
	}
	public BigDecimal getR0060_sold_trad_net_delta_pos() {
		return r0060_sold_trad_net_delta_pos;
	}
	public void setR0060_sold_trad_net_delta_pos(BigDecimal r0060_sold_trad_net_delta_pos) {
		this.r0060_sold_trad_net_delta_pos = r0060_sold_trad_net_delta_pos;
	}
	public BigDecimal getR0060_trad_nat_amt() {
		return r0060_trad_nat_amt;
	}
	public void setR0060_trad_nat_amt(BigDecimal r0060_trad_nat_amt) {
		this.r0060_trad_nat_amt = r0060_trad_nat_amt;
	}
	public BigDecimal getR0060_within_1_year_nat_amt() {
		return r0060_within_1_year_nat_amt;
	}
	public void setR0060_within_1_year_nat_amt(BigDecimal r0060_within_1_year_nat_amt) {
		this.r0060_within_1_year_nat_amt = r0060_within_1_year_nat_amt;
	}
	public BigDecimal getR0070_1_to_3_years_nat_amt() {
		return r0070_1_to_3_years_nat_amt;
	}
	public void setR0070_1_to_3_years_nat_amt(BigDecimal r0070_1_to_3_years_nat_amt) {
		this.r0070_1_to_3_years_nat_amt = r0070_1_to_3_years_nat_amt;
	}
	public BigDecimal getR0070_bought_hedg_net_delta_pos() {
		return r0070_bought_hedg_net_delta_pos;
	}
	public void setR0070_bought_hedg_net_delta_pos(BigDecimal r0070_bought_hedg_net_delta_pos) {
		this.r0070_bought_hedg_net_delta_pos = r0070_bought_hedg_net_delta_pos;
	}
	public BigDecimal getR0070_bought_trad_net_delta_pos() {
		return r0070_bought_trad_net_delta_pos;
	}
	public void setR0070_bought_trad_net_delta_pos(BigDecimal r0070_bought_trad_net_delta_pos) {
		this.r0070_bought_trad_net_delta_pos = r0070_bought_trad_net_delta_pos;
	}
	public BigDecimal getR0070_gross_mkt_val() {
		return r0070_gross_mkt_val;
	}
	public void setR0070_gross_mkt_val(BigDecimal r0070_gross_mkt_val) {
		this.r0070_gross_mkt_val = r0070_gross_mkt_val;
	}
	public BigDecimal getR0070_hedg_nat_amt() {
		return r0070_hedg_nat_amt;
	}
	public void setR0070_hedg_nat_amt(BigDecimal r0070_hedg_nat_amt) {
		this.r0070_hedg_nat_amt = r0070_hedg_nat_amt;
	}
	public BigDecimal getR0070_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0070_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0070_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0070_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0070_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0070_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0070_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0070_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0070_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0070_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0070_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0070_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0070_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0070_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0070_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0070_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0070_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0070_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0070_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0070_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0070_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0070_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0070_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0070_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0070_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0070_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0070_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0070_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0070_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0070_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0070_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0070_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0070_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0070_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0070_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0070_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0070_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0070_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0070_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0070_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0070_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0070_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0070_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0070_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0070_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0070_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0070_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0070_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0070_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0070_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0070_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0070_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0070_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0070_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0070_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0070_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0070_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0070_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0070_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0070_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0070_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0070_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0070_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0070_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0070_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0070_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0070_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0070_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0070_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0070_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0070_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0070_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public BigDecimal getR0070_nat_amt() {
		return r0070_nat_amt;
	}
	public void setR0070_nat_amt(BigDecimal r0070_nat_amt) {
		this.r0070_nat_amt = r0070_nat_amt;
	}
	public BigDecimal getR0070_non_res_nat_amt() {
		return r0070_non_res_nat_amt;
	}
	public void setR0070_non_res_nat_amt(BigDecimal r0070_non_res_nat_amt) {
		this.r0070_non_res_nat_amt = r0070_non_res_nat_amt;
	}
	public BigDecimal getR0070_over_3_years_nat_amt() {
		return r0070_over_3_years_nat_amt;
	}
	public void setR0070_over_3_years_nat_amt(BigDecimal r0070_over_3_years_nat_amt) {
		this.r0070_over_3_years_nat_amt = r0070_over_3_years_nat_amt;
	}
	public BigDecimal getR0070_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0070_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0070_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0070_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0070_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0070_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0070_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0070_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0070_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0070_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0070_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0070_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0070_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0070_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0070_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0070_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0070_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0070_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0070_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0070_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0070_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0070_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0070_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0070_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0070_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0070_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0070_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0070_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0070_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0070_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0070_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0070_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0070_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0070_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0070_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0070_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0070_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0070_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0070_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0070_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0070_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0070_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0070_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0070_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0070_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0070_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0070_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0070_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0070_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0070_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0070_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0070_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0070_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0070_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0070_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0070_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0070_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0070_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0070_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0070_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0070_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0070_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0070_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0070_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0070_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0070_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0070_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0070_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0070_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0070_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0070_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0070_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public String getR0070_product() {
		return r0070_product;
	}
	public void setR0070_product(String r0070_product) {
		this.r0070_product = r0070_product;
	}
	public BigDecimal getR0070_pro_bought_net_gain_loss() {
		return r0070_pro_bought_net_gain_loss;
	}
	public void setR0070_pro_bought_net_gain_loss(BigDecimal r0070_pro_bought_net_gain_loss) {
		this.r0070_pro_bought_net_gain_loss = r0070_pro_bought_net_gain_loss;
	}
	public BigDecimal getR0070_pro_sold_net_gain_loss() {
		return r0070_pro_sold_net_gain_loss;
	}
	public void setR0070_pro_sold_net_gain_loss(BigDecimal r0070_pro_sold_net_gain_loss) {
		this.r0070_pro_sold_net_gain_loss = r0070_pro_sold_net_gain_loss;
	}
	public BigDecimal getR0070_res_1_to_3_years_mkt_val() {
		return r0070_res_1_to_3_years_mkt_val;
	}
	public void setR0070_res_1_to_3_years_mkt_val(BigDecimal r0070_res_1_to_3_years_mkt_val) {
		this.r0070_res_1_to_3_years_mkt_val = r0070_res_1_to_3_years_mkt_val;
	}
	public BigDecimal getR0070_res_lessthan_1_year_mkt_val() {
		return r0070_res_lessthan_1_year_mkt_val;
	}
	public void setR0070_res_lessthan_1_year_mkt_val(BigDecimal r0070_res_lessthan_1_year_mkt_val) {
		this.r0070_res_lessthan_1_year_mkt_val = r0070_res_lessthan_1_year_mkt_val;
	}
	public BigDecimal getR0070_res_morethan_3_years_mkt_val() {
		return r0070_res_morethan_3_years_mkt_val;
	}
	public void setR0070_res_morethan_3_years_mkt_val(BigDecimal r0070_res_morethan_3_years_mkt_val) {
		this.r0070_res_morethan_3_years_mkt_val = r0070_res_morethan_3_years_mkt_val;
	}
	public BigDecimal getR0070_res_nat_amt() {
		return r0070_res_nat_amt;
	}
	public void setR0070_res_nat_amt(BigDecimal r0070_res_nat_amt) {
		this.r0070_res_nat_amt = r0070_res_nat_amt;
	}
	public BigDecimal getR0070_sold_hedg_net_delta_pos() {
		return r0070_sold_hedg_net_delta_pos;
	}
	public void setR0070_sold_hedg_net_delta_pos(BigDecimal r0070_sold_hedg_net_delta_pos) {
		this.r0070_sold_hedg_net_delta_pos = r0070_sold_hedg_net_delta_pos;
	}
	public BigDecimal getR0070_sold_trad_net_delta_pos() {
		return r0070_sold_trad_net_delta_pos;
	}
	public void setR0070_sold_trad_net_delta_pos(BigDecimal r0070_sold_trad_net_delta_pos) {
		this.r0070_sold_trad_net_delta_pos = r0070_sold_trad_net_delta_pos;
	}
	public BigDecimal getR0070_trad_nat_amt() {
		return r0070_trad_nat_amt;
	}
	public void setR0070_trad_nat_amt(BigDecimal r0070_trad_nat_amt) {
		this.r0070_trad_nat_amt = r0070_trad_nat_amt;
	}
	public BigDecimal getR0070_within_1_year_nat_amt() {
		return r0070_within_1_year_nat_amt;
	}
	public void setR0070_within_1_year_nat_amt(BigDecimal r0070_within_1_year_nat_amt) {
		this.r0070_within_1_year_nat_amt = r0070_within_1_year_nat_amt;
	}
	public BigDecimal getR0080_1_to_3_years_nat_amt() {
		return r0080_1_to_3_years_nat_amt;
	}
	public void setR0080_1_to_3_years_nat_amt(BigDecimal r0080_1_to_3_years_nat_amt) {
		this.r0080_1_to_3_years_nat_amt = r0080_1_to_3_years_nat_amt;
	}
	public BigDecimal getR0080_bought_hedg_net_delta_pos() {
		return r0080_bought_hedg_net_delta_pos;
	}
	public void setR0080_bought_hedg_net_delta_pos(BigDecimal r0080_bought_hedg_net_delta_pos) {
		this.r0080_bought_hedg_net_delta_pos = r0080_bought_hedg_net_delta_pos;
	}
	public BigDecimal getR0080_bought_trad_net_delta_pos() {
		return r0080_bought_trad_net_delta_pos;
	}
	public void setR0080_bought_trad_net_delta_pos(BigDecimal r0080_bought_trad_net_delta_pos) {
		this.r0080_bought_trad_net_delta_pos = r0080_bought_trad_net_delta_pos;
	}
	public BigDecimal getR0080_gross_mkt_val() {
		return r0080_gross_mkt_val;
	}
	public void setR0080_gross_mkt_val(BigDecimal r0080_gross_mkt_val) {
		this.r0080_gross_mkt_val = r0080_gross_mkt_val;
	}
	public BigDecimal getR0080_hedg_nat_amt() {
		return r0080_hedg_nat_amt;
	}
	public void setR0080_hedg_nat_amt(BigDecimal r0080_hedg_nat_amt) {
		this.r0080_hedg_nat_amt = r0080_hedg_nat_amt;
	}
	public BigDecimal getR0080_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0080_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0080_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0080_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0080_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0080_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0080_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0080_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0080_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0080_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0080_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0080_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0080_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0080_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0080_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0080_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0080_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0080_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0080_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0080_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0080_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0080_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0080_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0080_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0080_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0080_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0080_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0080_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0080_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0080_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0080_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0080_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0080_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0080_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0080_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0080_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0080_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0080_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0080_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0080_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0080_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0080_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0080_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0080_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0080_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0080_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0080_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0080_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0080_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0080_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0080_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0080_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0080_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0080_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0080_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0080_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0080_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0080_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0080_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0080_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0080_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0080_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0080_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0080_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0080_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0080_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0080_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0080_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0080_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0080_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0080_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0080_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public BigDecimal getR0080_nat_amt() {
		return r0080_nat_amt;
	}
	public void setR0080_nat_amt(BigDecimal r0080_nat_amt) {
		this.r0080_nat_amt = r0080_nat_amt;
	}
	public BigDecimal getR0080_non_res_nat_amt() {
		return r0080_non_res_nat_amt;
	}
	public void setR0080_non_res_nat_amt(BigDecimal r0080_non_res_nat_amt) {
		this.r0080_non_res_nat_amt = r0080_non_res_nat_amt;
	}
	public BigDecimal getR0080_over_3_years_nat_amt() {
		return r0080_over_3_years_nat_amt;
	}
	public void setR0080_over_3_years_nat_amt(BigDecimal r0080_over_3_years_nat_amt) {
		this.r0080_over_3_years_nat_amt = r0080_over_3_years_nat_amt;
	}
	public BigDecimal getR0080_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0080_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0080_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0080_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0080_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0080_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0080_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0080_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0080_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0080_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0080_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0080_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0080_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0080_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0080_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0080_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0080_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0080_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0080_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0080_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0080_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0080_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0080_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0080_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0080_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0080_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0080_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0080_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0080_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0080_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0080_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0080_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0080_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0080_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0080_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0080_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0080_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0080_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0080_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0080_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0080_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0080_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0080_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0080_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0080_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0080_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0080_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0080_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0080_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0080_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0080_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0080_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0080_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0080_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0080_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0080_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0080_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0080_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0080_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0080_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0080_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0080_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0080_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0080_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0080_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0080_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0080_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0080_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0080_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0080_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0080_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0080_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public String getR0080_product() {
		return r0080_product;
	}
	public void setR0080_product(String r0080_product) {
		this.r0080_product = r0080_product;
	}
	public BigDecimal getR0080_pro_bought_net_gain_loss() {
		return r0080_pro_bought_net_gain_loss;
	}
	public void setR0080_pro_bought_net_gain_loss(BigDecimal r0080_pro_bought_net_gain_loss) {
		this.r0080_pro_bought_net_gain_loss = r0080_pro_bought_net_gain_loss;
	}
	public BigDecimal getR0080_pro_sold_net_gain_loss() {
		return r0080_pro_sold_net_gain_loss;
	}
	public void setR0080_pro_sold_net_gain_loss(BigDecimal r0080_pro_sold_net_gain_loss) {
		this.r0080_pro_sold_net_gain_loss = r0080_pro_sold_net_gain_loss;
	}
	public BigDecimal getR0080_res_1_to_3_years_mkt_val() {
		return r0080_res_1_to_3_years_mkt_val;
	}
	public void setR0080_res_1_to_3_years_mkt_val(BigDecimal r0080_res_1_to_3_years_mkt_val) {
		this.r0080_res_1_to_3_years_mkt_val = r0080_res_1_to_3_years_mkt_val;
	}
	public BigDecimal getR0080_res_lessthan_1_year_mkt_val() {
		return r0080_res_lessthan_1_year_mkt_val;
	}
	public void setR0080_res_lessthan_1_year_mkt_val(BigDecimal r0080_res_lessthan_1_year_mkt_val) {
		this.r0080_res_lessthan_1_year_mkt_val = r0080_res_lessthan_1_year_mkt_val;
	}
	public BigDecimal getR0080_res_morethan_3_years_mkt_val() {
		return r0080_res_morethan_3_years_mkt_val;
	}
	public void setR0080_res_morethan_3_years_mkt_val(BigDecimal r0080_res_morethan_3_years_mkt_val) {
		this.r0080_res_morethan_3_years_mkt_val = r0080_res_morethan_3_years_mkt_val;
	}
	public BigDecimal getR0080_res_nat_amt() {
		return r0080_res_nat_amt;
	}
	public void setR0080_res_nat_amt(BigDecimal r0080_res_nat_amt) {
		this.r0080_res_nat_amt = r0080_res_nat_amt;
	}
	public BigDecimal getR0080_sold_hedg_net_delta_pos() {
		return r0080_sold_hedg_net_delta_pos;
	}
	public void setR0080_sold_hedg_net_delta_pos(BigDecimal r0080_sold_hedg_net_delta_pos) {
		this.r0080_sold_hedg_net_delta_pos = r0080_sold_hedg_net_delta_pos;
	}
	public BigDecimal getR0080_sold_trad_net_delta_pos() {
		return r0080_sold_trad_net_delta_pos;
	}
	public void setR0080_sold_trad_net_delta_pos(BigDecimal r0080_sold_trad_net_delta_pos) {
		this.r0080_sold_trad_net_delta_pos = r0080_sold_trad_net_delta_pos;
	}
	public BigDecimal getR0080_trad_nat_amt() {
		return r0080_trad_nat_amt;
	}
	public void setR0080_trad_nat_amt(BigDecimal r0080_trad_nat_amt) {
		this.r0080_trad_nat_amt = r0080_trad_nat_amt;
	}
	public BigDecimal getR0080_within_1_year_nat_amt() {
		return r0080_within_1_year_nat_amt;
	}
	public void setR0080_within_1_year_nat_amt(BigDecimal r0080_within_1_year_nat_amt) {
		this.r0080_within_1_year_nat_amt = r0080_within_1_year_nat_amt;
	}
	public BigDecimal getR0090_1_to_3_years_nat_amt() {
		return r0090_1_to_3_years_nat_amt;
	}
	public void setR0090_1_to_3_years_nat_amt(BigDecimal r0090_1_to_3_years_nat_amt) {
		this.r0090_1_to_3_years_nat_amt = r0090_1_to_3_years_nat_amt;
	}
	public BigDecimal getR0090_bought_hedg_net_delta_pos() {
		return r0090_bought_hedg_net_delta_pos;
	}
	public void setR0090_bought_hedg_net_delta_pos(BigDecimal r0090_bought_hedg_net_delta_pos) {
		this.r0090_bought_hedg_net_delta_pos = r0090_bought_hedg_net_delta_pos;
	}
	public BigDecimal getR0090_bought_trad_net_delta_pos() {
		return r0090_bought_trad_net_delta_pos;
	}
	public void setR0090_bought_trad_net_delta_pos(BigDecimal r0090_bought_trad_net_delta_pos) {
		this.r0090_bought_trad_net_delta_pos = r0090_bought_trad_net_delta_pos;
	}
	public BigDecimal getR0090_gross_mkt_val() {
		return r0090_gross_mkt_val;
	}
	public void setR0090_gross_mkt_val(BigDecimal r0090_gross_mkt_val) {
		this.r0090_gross_mkt_val = r0090_gross_mkt_val;
	}
	public BigDecimal getR0090_hedg_nat_amt() {
		return r0090_hedg_nat_amt;
	}
	public void setR0090_hedg_nat_amt(BigDecimal r0090_hedg_nat_amt) {
		this.r0090_hedg_nat_amt = r0090_hedg_nat_amt;
	}
	public BigDecimal getR0090_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0090_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0090_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0090_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0090_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0090_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0090_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0090_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0090_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0090_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0090_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0090_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0090_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0090_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0090_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0090_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0090_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0090_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0090_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0090_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0090_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0090_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0090_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0090_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0090_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0090_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0090_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0090_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0090_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0090_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0090_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0090_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0090_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0090_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0090_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0090_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0090_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0090_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0090_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0090_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0090_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0090_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0090_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0090_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0090_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0090_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0090_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0090_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0090_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0090_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0090_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0090_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0090_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0090_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0090_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0090_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0090_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0090_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0090_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0090_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0090_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0090_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0090_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0090_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0090_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0090_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0090_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0090_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0090_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0090_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0090_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0090_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public BigDecimal getR0090_nat_amt() {
		return r0090_nat_amt;
	}
	public void setR0090_nat_amt(BigDecimal r0090_nat_amt) {
		this.r0090_nat_amt = r0090_nat_amt;
	}
	public BigDecimal getR0090_non_res_nat_amt() {
		return r0090_non_res_nat_amt;
	}
	public void setR0090_non_res_nat_amt(BigDecimal r0090_non_res_nat_amt) {
		this.r0090_non_res_nat_amt = r0090_non_res_nat_amt;
	}
	public BigDecimal getR0090_over_3_years_nat_amt() {
		return r0090_over_3_years_nat_amt;
	}
	public void setR0090_over_3_years_nat_amt(BigDecimal r0090_over_3_years_nat_amt) {
		this.r0090_over_3_years_nat_amt = r0090_over_3_years_nat_amt;
	}
	public BigDecimal getR0090_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0090_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0090_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0090_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0090_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0090_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0090_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0090_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0090_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0090_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0090_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0090_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0090_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0090_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0090_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0090_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0090_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0090_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0090_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0090_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0090_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0090_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0090_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0090_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0090_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0090_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0090_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0090_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0090_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0090_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0090_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0090_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0090_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0090_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0090_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0090_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0090_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0090_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0090_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0090_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0090_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0090_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0090_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0090_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0090_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0090_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0090_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0090_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0090_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0090_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0090_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0090_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0090_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0090_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0090_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0090_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0090_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0090_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0090_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0090_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0090_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0090_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0090_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0090_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0090_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0090_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0090_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0090_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0090_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0090_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0090_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0090_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public String getR0090_product() {
		return r0090_product;
	}
	public void setR0090_product(String r0090_product) {
		this.r0090_product = r0090_product;
	}
	public BigDecimal getR0090_pro_bought_net_gain_loss() {
		return r0090_pro_bought_net_gain_loss;
	}
	public void setR0090_pro_bought_net_gain_loss(BigDecimal r0090_pro_bought_net_gain_loss) {
		this.r0090_pro_bought_net_gain_loss = r0090_pro_bought_net_gain_loss;
	}
	public BigDecimal getR0090_pro_sold_net_gain_loss() {
		return r0090_pro_sold_net_gain_loss;
	}
	public void setR0090_pro_sold_net_gain_loss(BigDecimal r0090_pro_sold_net_gain_loss) {
		this.r0090_pro_sold_net_gain_loss = r0090_pro_sold_net_gain_loss;
	}
	public BigDecimal getR0090_res_1_to_3_years_mkt_val() {
		return r0090_res_1_to_3_years_mkt_val;
	}
	public void setR0090_res_1_to_3_years_mkt_val(BigDecimal r0090_res_1_to_3_years_mkt_val) {
		this.r0090_res_1_to_3_years_mkt_val = r0090_res_1_to_3_years_mkt_val;
	}
	public BigDecimal getR0090_res_lessthan_1_year_mkt_val() {
		return r0090_res_lessthan_1_year_mkt_val;
	}
	public void setR0090_res_lessthan_1_year_mkt_val(BigDecimal r0090_res_lessthan_1_year_mkt_val) {
		this.r0090_res_lessthan_1_year_mkt_val = r0090_res_lessthan_1_year_mkt_val;
	}
	public BigDecimal getR0090_res_morethan_3_years_mkt_val() {
		return r0090_res_morethan_3_years_mkt_val;
	}
	public void setR0090_res_morethan_3_years_mkt_val(BigDecimal r0090_res_morethan_3_years_mkt_val) {
		this.r0090_res_morethan_3_years_mkt_val = r0090_res_morethan_3_years_mkt_val;
	}
	public BigDecimal getR0090_res_nat_amt() {
		return r0090_res_nat_amt;
	}
	public void setR0090_res_nat_amt(BigDecimal r0090_res_nat_amt) {
		this.r0090_res_nat_amt = r0090_res_nat_amt;
	}
	public BigDecimal getR0090_sold_hedg_net_delta_pos() {
		return r0090_sold_hedg_net_delta_pos;
	}
	public void setR0090_sold_hedg_net_delta_pos(BigDecimal r0090_sold_hedg_net_delta_pos) {
		this.r0090_sold_hedg_net_delta_pos = r0090_sold_hedg_net_delta_pos;
	}
	public BigDecimal getR0090_sold_trad_net_delta_pos() {
		return r0090_sold_trad_net_delta_pos;
	}
	public void setR0090_sold_trad_net_delta_pos(BigDecimal r0090_sold_trad_net_delta_pos) {
		this.r0090_sold_trad_net_delta_pos = r0090_sold_trad_net_delta_pos;
	}
	public BigDecimal getR0090_trad_nat_amt() {
		return r0090_trad_nat_amt;
	}
	public void setR0090_trad_nat_amt(BigDecimal r0090_trad_nat_amt) {
		this.r0090_trad_nat_amt = r0090_trad_nat_amt;
	}
	public BigDecimal getR0090_within_1_year_nat_amt() {
		return r0090_within_1_year_nat_amt;
	}
	public void setR0090_within_1_year_nat_amt(BigDecimal r0090_within_1_year_nat_amt) {
		this.r0090_within_1_year_nat_amt = r0090_within_1_year_nat_amt;
	}
	public BigDecimal getR0100_1_to_3_years_nat_amt() {
		return r0100_1_to_3_years_nat_amt;
	}
	public void setR0100_1_to_3_years_nat_amt(BigDecimal r0100_1_to_3_years_nat_amt) {
		this.r0100_1_to_3_years_nat_amt = r0100_1_to_3_years_nat_amt;
	}
	public BigDecimal getR0100_bought_hedg_net_delta_pos() {
		return r0100_bought_hedg_net_delta_pos;
	}
	public void setR0100_bought_hedg_net_delta_pos(BigDecimal r0100_bought_hedg_net_delta_pos) {
		this.r0100_bought_hedg_net_delta_pos = r0100_bought_hedg_net_delta_pos;
	}
	public BigDecimal getR0100_bought_trad_net_delta_pos() {
		return r0100_bought_trad_net_delta_pos;
	}
	public void setR0100_bought_trad_net_delta_pos(BigDecimal r0100_bought_trad_net_delta_pos) {
		this.r0100_bought_trad_net_delta_pos = r0100_bought_trad_net_delta_pos;
	}
	public BigDecimal getR0100_gross_mkt_val() {
		return r0100_gross_mkt_val;
	}
	public void setR0100_gross_mkt_val(BigDecimal r0100_gross_mkt_val) {
		this.r0100_gross_mkt_val = r0100_gross_mkt_val;
	}
	public BigDecimal getR0100_hedg_nat_amt() {
		return r0100_hedg_nat_amt;
	}
	public void setR0100_hedg_nat_amt(BigDecimal r0100_hedg_nat_amt) {
		this.r0100_hedg_nat_amt = r0100_hedg_nat_amt;
	}
	public BigDecimal getR0100_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0100_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0100_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0100_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0100_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0100_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0100_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0100_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0100_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0100_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0100_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0100_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0100_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0100_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0100_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0100_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0100_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0100_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0100_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0100_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0100_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0100_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0100_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0100_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0100_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0100_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0100_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0100_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0100_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0100_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0100_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0100_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0100_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0100_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0100_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0100_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0100_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0100_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0100_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0100_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0100_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0100_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0100_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0100_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0100_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0100_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0100_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0100_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0100_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0100_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0100_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0100_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0100_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0100_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0100_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0100_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0100_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0100_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0100_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0100_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0100_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0100_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0100_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0100_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0100_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0100_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0100_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0100_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0100_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0100_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0100_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0100_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public BigDecimal getR0100_nat_amt() {
		return r0100_nat_amt;
	}
	public void setR0100_nat_amt(BigDecimal r0100_nat_amt) {
		this.r0100_nat_amt = r0100_nat_amt;
	}
	public BigDecimal getR0100_non_res_nat_amt() {
		return r0100_non_res_nat_amt;
	}
	public void setR0100_non_res_nat_amt(BigDecimal r0100_non_res_nat_amt) {
		this.r0100_non_res_nat_amt = r0100_non_res_nat_amt;
	}
	public BigDecimal getR0100_over_3_years_nat_amt() {
		return r0100_over_3_years_nat_amt;
	}
	public void setR0100_over_3_years_nat_amt(BigDecimal r0100_over_3_years_nat_amt) {
		this.r0100_over_3_years_nat_amt = r0100_over_3_years_nat_amt;
	}
	public BigDecimal getR0100_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0100_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0100_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0100_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0100_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0100_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0100_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0100_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0100_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0100_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0100_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0100_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0100_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0100_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0100_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0100_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0100_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0100_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0100_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0100_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0100_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0100_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0100_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0100_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0100_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0100_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0100_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0100_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0100_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0100_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0100_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0100_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0100_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0100_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0100_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0100_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0100_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0100_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0100_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0100_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0100_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0100_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0100_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0100_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0100_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0100_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0100_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0100_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0100_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0100_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0100_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0100_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0100_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0100_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0100_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0100_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0100_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0100_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0100_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0100_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0100_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0100_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0100_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0100_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0100_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0100_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0100_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0100_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0100_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0100_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0100_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0100_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public String getR0100_product() {
		return r0100_product;
	}
	public void setR0100_product(String r0100_product) {
		this.r0100_product = r0100_product;
	}
	public BigDecimal getR0100_pro_bought_net_gain_loss() {
		return r0100_pro_bought_net_gain_loss;
	}
	public void setR0100_pro_bought_net_gain_loss(BigDecimal r0100_pro_bought_net_gain_loss) {
		this.r0100_pro_bought_net_gain_loss = r0100_pro_bought_net_gain_loss;
	}
	public BigDecimal getR0100_pro_sold_net_gain_loss() {
		return r0100_pro_sold_net_gain_loss;
	}
	public void setR0100_pro_sold_net_gain_loss(BigDecimal r0100_pro_sold_net_gain_loss) {
		this.r0100_pro_sold_net_gain_loss = r0100_pro_sold_net_gain_loss;
	}
	public BigDecimal getR0100_res_1_to_3_years_mkt_val() {
		return r0100_res_1_to_3_years_mkt_val;
	}
	public void setR0100_res_1_to_3_years_mkt_val(BigDecimal r0100_res_1_to_3_years_mkt_val) {
		this.r0100_res_1_to_3_years_mkt_val = r0100_res_1_to_3_years_mkt_val;
	}
	public BigDecimal getR0100_res_lessthan_1_year_mkt_val() {
		return r0100_res_lessthan_1_year_mkt_val;
	}
	public void setR0100_res_lessthan_1_year_mkt_val(BigDecimal r0100_res_lessthan_1_year_mkt_val) {
		this.r0100_res_lessthan_1_year_mkt_val = r0100_res_lessthan_1_year_mkt_val;
	}
	public BigDecimal getR0100_res_morethan_3_years_mkt_val() {
		return r0100_res_morethan_3_years_mkt_val;
	}
	public void setR0100_res_morethan_3_years_mkt_val(BigDecimal r0100_res_morethan_3_years_mkt_val) {
		this.r0100_res_morethan_3_years_mkt_val = r0100_res_morethan_3_years_mkt_val;
	}
	public BigDecimal getR0100_res_nat_amt() {
		return r0100_res_nat_amt;
	}
	public void setR0100_res_nat_amt(BigDecimal r0100_res_nat_amt) {
		this.r0100_res_nat_amt = r0100_res_nat_amt;
	}
	public BigDecimal getR0100_sold_hedg_net_delta_pos() {
		return r0100_sold_hedg_net_delta_pos;
	}
	public void setR0100_sold_hedg_net_delta_pos(BigDecimal r0100_sold_hedg_net_delta_pos) {
		this.r0100_sold_hedg_net_delta_pos = r0100_sold_hedg_net_delta_pos;
	}
	public BigDecimal getR0100_sold_trad_net_delta_pos() {
		return r0100_sold_trad_net_delta_pos;
	}
	public void setR0100_sold_trad_net_delta_pos(BigDecimal r0100_sold_trad_net_delta_pos) {
		this.r0100_sold_trad_net_delta_pos = r0100_sold_trad_net_delta_pos;
	}
	public BigDecimal getR0100_trad_nat_amt() {
		return r0100_trad_nat_amt;
	}
	public void setR0100_trad_nat_amt(BigDecimal r0100_trad_nat_amt) {
		this.r0100_trad_nat_amt = r0100_trad_nat_amt;
	}
	public BigDecimal getR0100_within_1_year_nat_amt() {
		return r0100_within_1_year_nat_amt;
	}
	public void setR0100_within_1_year_nat_amt(BigDecimal r0100_within_1_year_nat_amt) {
		this.r0100_within_1_year_nat_amt = r0100_within_1_year_nat_amt;
	}
	public BigDecimal getR0110_1_to_3_years_nat_amt() {
		return r0110_1_to_3_years_nat_amt;
	}
	public void setR0110_1_to_3_years_nat_amt(BigDecimal r0110_1_to_3_years_nat_amt) {
		this.r0110_1_to_3_years_nat_amt = r0110_1_to_3_years_nat_amt;
	}
	public BigDecimal getR0110_bought_hedg_net_delta_pos() {
		return r0110_bought_hedg_net_delta_pos;
	}
	public void setR0110_bought_hedg_net_delta_pos(BigDecimal r0110_bought_hedg_net_delta_pos) {
		this.r0110_bought_hedg_net_delta_pos = r0110_bought_hedg_net_delta_pos;
	}
	public BigDecimal getR0110_bought_trad_net_delta_pos() {
		return r0110_bought_trad_net_delta_pos;
	}
	public void setR0110_bought_trad_net_delta_pos(BigDecimal r0110_bought_trad_net_delta_pos) {
		this.r0110_bought_trad_net_delta_pos = r0110_bought_trad_net_delta_pos;
	}
	public BigDecimal getR0110_gross_mkt_val() {
		return r0110_gross_mkt_val;
	}
	public void setR0110_gross_mkt_val(BigDecimal r0110_gross_mkt_val) {
		this.r0110_gross_mkt_val = r0110_gross_mkt_val;
	}
	public BigDecimal getR0110_hedg_nat_amt() {
		return r0110_hedg_nat_amt;
	}
	public void setR0110_hedg_nat_amt(BigDecimal r0110_hedg_nat_amt) {
		this.r0110_hedg_nat_amt = r0110_hedg_nat_amt;
	}
	public BigDecimal getR0110_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0110_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0110_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0110_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0110_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0110_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0110_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0110_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0110_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0110_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0110_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0110_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0110_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0110_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0110_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0110_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0110_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0110_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0110_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0110_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0110_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0110_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0110_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0110_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0110_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0110_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0110_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0110_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0110_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0110_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0110_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0110_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0110_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0110_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0110_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0110_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0110_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0110_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0110_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0110_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0110_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0110_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0110_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0110_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0110_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0110_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0110_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0110_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0110_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0110_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0110_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0110_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0110_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0110_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0110_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0110_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0110_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0110_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0110_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0110_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0110_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0110_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0110_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0110_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0110_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0110_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0110_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0110_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0110_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0110_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0110_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0110_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public BigDecimal getR0110_nat_amt() {
		return r0110_nat_amt;
	}
	public void setR0110_nat_amt(BigDecimal r0110_nat_amt) {
		this.r0110_nat_amt = r0110_nat_amt;
	}
	public BigDecimal getR0110_non_res_nat_amt() {
		return r0110_non_res_nat_amt;
	}
	public void setR0110_non_res_nat_amt(BigDecimal r0110_non_res_nat_amt) {
		this.r0110_non_res_nat_amt = r0110_non_res_nat_amt;
	}
	public BigDecimal getR0110_over_3_years_nat_amt() {
		return r0110_over_3_years_nat_amt;
	}
	public void setR0110_over_3_years_nat_amt(BigDecimal r0110_over_3_years_nat_amt) {
		this.r0110_over_3_years_nat_amt = r0110_over_3_years_nat_amt;
	}
	public BigDecimal getR0110_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0110_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0110_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0110_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0110_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0110_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0110_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0110_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0110_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0110_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0110_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0110_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0110_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0110_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0110_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0110_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0110_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0110_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0110_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0110_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0110_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0110_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0110_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0110_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0110_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0110_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0110_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0110_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0110_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0110_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0110_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0110_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0110_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0110_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0110_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0110_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0110_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0110_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0110_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0110_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0110_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0110_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0110_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0110_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0110_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0110_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0110_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0110_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0110_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0110_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0110_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0110_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0110_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0110_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0110_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0110_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0110_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0110_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0110_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0110_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0110_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0110_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0110_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0110_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0110_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0110_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0110_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0110_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0110_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0110_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0110_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0110_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public String getR0110_product() {
		return r0110_product;
	}
	public void setR0110_product(String r0110_product) {
		this.r0110_product = r0110_product;
	}
	public BigDecimal getR0110_pro_bought_net_gain_loss() {
		return r0110_pro_bought_net_gain_loss;
	}
	public void setR0110_pro_bought_net_gain_loss(BigDecimal r0110_pro_bought_net_gain_loss) {
		this.r0110_pro_bought_net_gain_loss = r0110_pro_bought_net_gain_loss;
	}
	public BigDecimal getR0110_pro_sold_net_gain_loss() {
		return r0110_pro_sold_net_gain_loss;
	}
	public void setR0110_pro_sold_net_gain_loss(BigDecimal r0110_pro_sold_net_gain_loss) {
		this.r0110_pro_sold_net_gain_loss = r0110_pro_sold_net_gain_loss;
	}
	public BigDecimal getR0110_res_1_to_3_years_mkt_val() {
		return r0110_res_1_to_3_years_mkt_val;
	}
	public void setR0110_res_1_to_3_years_mkt_val(BigDecimal r0110_res_1_to_3_years_mkt_val) {
		this.r0110_res_1_to_3_years_mkt_val = r0110_res_1_to_3_years_mkt_val;
	}
	public BigDecimal getR0110_res_lessthan_1_year_mkt_val() {
		return r0110_res_lessthan_1_year_mkt_val;
	}
	public void setR0110_res_lessthan_1_year_mkt_val(BigDecimal r0110_res_lessthan_1_year_mkt_val) {
		this.r0110_res_lessthan_1_year_mkt_val = r0110_res_lessthan_1_year_mkt_val;
	}
	public BigDecimal getR0110_res_morethan_3_years_mkt_val() {
		return r0110_res_morethan_3_years_mkt_val;
	}
	public void setR0110_res_morethan_3_years_mkt_val(BigDecimal r0110_res_morethan_3_years_mkt_val) {
		this.r0110_res_morethan_3_years_mkt_val = r0110_res_morethan_3_years_mkt_val;
	}
	public BigDecimal getR0110_res_nat_amt() {
		return r0110_res_nat_amt;
	}
	public void setR0110_res_nat_amt(BigDecimal r0110_res_nat_amt) {
		this.r0110_res_nat_amt = r0110_res_nat_amt;
	}
	public BigDecimal getR0110_sold_hedg_net_delta_pos() {
		return r0110_sold_hedg_net_delta_pos;
	}
	public void setR0110_sold_hedg_net_delta_pos(BigDecimal r0110_sold_hedg_net_delta_pos) {
		this.r0110_sold_hedg_net_delta_pos = r0110_sold_hedg_net_delta_pos;
	}
	public BigDecimal getR0110_sold_trad_net_delta_pos() {
		return r0110_sold_trad_net_delta_pos;
	}
	public void setR0110_sold_trad_net_delta_pos(BigDecimal r0110_sold_trad_net_delta_pos) {
		this.r0110_sold_trad_net_delta_pos = r0110_sold_trad_net_delta_pos;
	}
	public BigDecimal getR0110_trad_nat_amt() {
		return r0110_trad_nat_amt;
	}
	public void setR0110_trad_nat_amt(BigDecimal r0110_trad_nat_amt) {
		this.r0110_trad_nat_amt = r0110_trad_nat_amt;
	}
	public BigDecimal getR0110_within_1_year_nat_amt() {
		return r0110_within_1_year_nat_amt;
	}
	public void setR0110_within_1_year_nat_amt(BigDecimal r0110_within_1_year_nat_amt) {
		this.r0110_within_1_year_nat_amt = r0110_within_1_year_nat_amt;
	}
	public BigDecimal getR0120_1_to_3_years_nat_amt() {
		return r0120_1_to_3_years_nat_amt;
	}
	public void setR0120_1_to_3_years_nat_amt(BigDecimal r0120_1_to_3_years_nat_amt) {
		this.r0120_1_to_3_years_nat_amt = r0120_1_to_3_years_nat_amt;
	}
	public BigDecimal getR0120_bought_hedg_net_delta_pos() {
		return r0120_bought_hedg_net_delta_pos;
	}
	public void setR0120_bought_hedg_net_delta_pos(BigDecimal r0120_bought_hedg_net_delta_pos) {
		this.r0120_bought_hedg_net_delta_pos = r0120_bought_hedg_net_delta_pos;
	}
	public BigDecimal getR0120_bought_trad_net_delta_pos() {
		return r0120_bought_trad_net_delta_pos;
	}
	public void setR0120_bought_trad_net_delta_pos(BigDecimal r0120_bought_trad_net_delta_pos) {
		this.r0120_bought_trad_net_delta_pos = r0120_bought_trad_net_delta_pos;
	}
	public BigDecimal getR0120_gross_mkt_val() {
		return r0120_gross_mkt_val;
	}
	public void setR0120_gross_mkt_val(BigDecimal r0120_gross_mkt_val) {
		this.r0120_gross_mkt_val = r0120_gross_mkt_val;
	}
	public BigDecimal getR0120_hedg_nat_amt() {
		return r0120_hedg_nat_amt;
	}
	public void setR0120_hedg_nat_amt(BigDecimal r0120_hedg_nat_amt) {
		this.r0120_hedg_nat_amt = r0120_hedg_nat_amt;
	}
	public BigDecimal getR0120_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0120_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0120_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0120_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0120_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0120_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0120_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0120_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0120_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0120_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0120_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0120_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0120_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0120_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0120_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0120_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0120_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0120_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0120_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0120_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0120_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0120_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0120_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0120_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0120_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0120_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0120_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0120_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0120_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0120_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0120_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0120_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0120_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0120_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0120_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0120_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0120_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0120_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0120_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0120_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0120_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0120_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0120_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0120_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0120_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0120_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0120_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0120_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0120_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0120_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0120_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0120_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0120_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0120_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0120_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0120_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0120_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0120_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0120_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0120_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0120_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0120_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0120_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0120_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0120_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0120_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0120_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0120_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0120_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0120_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0120_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0120_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public BigDecimal getR0120_nat_amt() {
		return r0120_nat_amt;
	}
	public void setR0120_nat_amt(BigDecimal r0120_nat_amt) {
		this.r0120_nat_amt = r0120_nat_amt;
	}
	public BigDecimal getR0120_non_res_nat_amt() {
		return r0120_non_res_nat_amt;
	}
	public void setR0120_non_res_nat_amt(BigDecimal r0120_non_res_nat_amt) {
		this.r0120_non_res_nat_amt = r0120_non_res_nat_amt;
	}
	public BigDecimal getR0120_over_3_years_nat_amt() {
		return r0120_over_3_years_nat_amt;
	}
	public void setR0120_over_3_years_nat_amt(BigDecimal r0120_over_3_years_nat_amt) {
		this.r0120_over_3_years_nat_amt = r0120_over_3_years_nat_amt;
	}
	public BigDecimal getR0120_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0120_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0120_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0120_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0120_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0120_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0120_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0120_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0120_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0120_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0120_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0120_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0120_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0120_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0120_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0120_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0120_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0120_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0120_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0120_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0120_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0120_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0120_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0120_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0120_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0120_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0120_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0120_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0120_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0120_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0120_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0120_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0120_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0120_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0120_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0120_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0120_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0120_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0120_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0120_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0120_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0120_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0120_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0120_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0120_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0120_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0120_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0120_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0120_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0120_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0120_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0120_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0120_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0120_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0120_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0120_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0120_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0120_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0120_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0120_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0120_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0120_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0120_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0120_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0120_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0120_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0120_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0120_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0120_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0120_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0120_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0120_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public String getR0120_product() {
		return r0120_product;
	}
	public void setR0120_product(String r0120_product) {
		this.r0120_product = r0120_product;
	}
	public BigDecimal getR0120_pro_bought_net_gain_loss() {
		return r0120_pro_bought_net_gain_loss;
	}
	public void setR0120_pro_bought_net_gain_loss(BigDecimal r0120_pro_bought_net_gain_loss) {
		this.r0120_pro_bought_net_gain_loss = r0120_pro_bought_net_gain_loss;
	}
	public BigDecimal getR0120_pro_sold_net_gain_loss() {
		return r0120_pro_sold_net_gain_loss;
	}
	public void setR0120_pro_sold_net_gain_loss(BigDecimal r0120_pro_sold_net_gain_loss) {
		this.r0120_pro_sold_net_gain_loss = r0120_pro_sold_net_gain_loss;
	}
	public BigDecimal getR0120_res_1_to_3_years_mkt_val() {
		return r0120_res_1_to_3_years_mkt_val;
	}
	public void setR0120_res_1_to_3_years_mkt_val(BigDecimal r0120_res_1_to_3_years_mkt_val) {
		this.r0120_res_1_to_3_years_mkt_val = r0120_res_1_to_3_years_mkt_val;
	}
	public BigDecimal getR0120_res_lessthan_1_year_mkt_val() {
		return r0120_res_lessthan_1_year_mkt_val;
	}
	public void setR0120_res_lessthan_1_year_mkt_val(BigDecimal r0120_res_lessthan_1_year_mkt_val) {
		this.r0120_res_lessthan_1_year_mkt_val = r0120_res_lessthan_1_year_mkt_val;
	}
	public BigDecimal getR0120_res_morethan_3_years_mkt_val() {
		return r0120_res_morethan_3_years_mkt_val;
	}
	public void setR0120_res_morethan_3_years_mkt_val(BigDecimal r0120_res_morethan_3_years_mkt_val) {
		this.r0120_res_morethan_3_years_mkt_val = r0120_res_morethan_3_years_mkt_val;
	}
	public BigDecimal getR0120_res_nat_amt() {
		return r0120_res_nat_amt;
	}
	public void setR0120_res_nat_amt(BigDecimal r0120_res_nat_amt) {
		this.r0120_res_nat_amt = r0120_res_nat_amt;
	}
	public BigDecimal getR0120_sold_hedg_net_delta_pos() {
		return r0120_sold_hedg_net_delta_pos;
	}
	public void setR0120_sold_hedg_net_delta_pos(BigDecimal r0120_sold_hedg_net_delta_pos) {
		this.r0120_sold_hedg_net_delta_pos = r0120_sold_hedg_net_delta_pos;
	}
	public BigDecimal getR0120_sold_trad_net_delta_pos() {
		return r0120_sold_trad_net_delta_pos;
	}
	public void setR0120_sold_trad_net_delta_pos(BigDecimal r0120_sold_trad_net_delta_pos) {
		this.r0120_sold_trad_net_delta_pos = r0120_sold_trad_net_delta_pos;
	}
	public BigDecimal getR0120_trad_nat_amt() {
		return r0120_trad_nat_amt;
	}
	public void setR0120_trad_nat_amt(BigDecimal r0120_trad_nat_amt) {
		this.r0120_trad_nat_amt = r0120_trad_nat_amt;
	}
	public BigDecimal getR0120_within_1_year_nat_amt() {
		return r0120_within_1_year_nat_amt;
	}
	public void setR0120_within_1_year_nat_amt(BigDecimal r0120_within_1_year_nat_amt) {
		this.r0120_within_1_year_nat_amt = r0120_within_1_year_nat_amt;
	}
	public BigDecimal getR0130_1_to_3_years_nat_amt() {
		return r0130_1_to_3_years_nat_amt;
	}
	public void setR0130_1_to_3_years_nat_amt(BigDecimal r0130_1_to_3_years_nat_amt) {
		this.r0130_1_to_3_years_nat_amt = r0130_1_to_3_years_nat_amt;
	}
	public BigDecimal getR0130_bought_hedg_net_delta_pos() {
		return r0130_bought_hedg_net_delta_pos;
	}
	public void setR0130_bought_hedg_net_delta_pos(BigDecimal r0130_bought_hedg_net_delta_pos) {
		this.r0130_bought_hedg_net_delta_pos = r0130_bought_hedg_net_delta_pos;
	}
	public BigDecimal getR0130_bought_trad_net_delta_pos() {
		return r0130_bought_trad_net_delta_pos;
	}
	public void setR0130_bought_trad_net_delta_pos(BigDecimal r0130_bought_trad_net_delta_pos) {
		this.r0130_bought_trad_net_delta_pos = r0130_bought_trad_net_delta_pos;
	}
	public BigDecimal getR0130_gross_mkt_val() {
		return r0130_gross_mkt_val;
	}
	public void setR0130_gross_mkt_val(BigDecimal r0130_gross_mkt_val) {
		this.r0130_gross_mkt_val = r0130_gross_mkt_val;
	}
	public BigDecimal getR0130_hedg_nat_amt() {
		return r0130_hedg_nat_amt;
	}
	public void setR0130_hedg_nat_amt(BigDecimal r0130_hedg_nat_amt) {
		this.r0130_hedg_nat_amt = r0130_hedg_nat_amt;
	}
	public BigDecimal getR0130_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0130_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0130_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0130_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0130_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0130_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0130_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0130_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0130_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0130_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0130_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0130_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0130_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0130_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0130_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0130_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0130_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0130_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0130_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0130_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0130_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0130_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0130_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0130_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0130_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0130_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0130_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0130_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0130_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0130_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0130_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0130_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0130_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0130_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0130_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0130_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0130_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0130_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0130_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0130_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0130_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0130_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0130_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0130_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0130_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0130_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0130_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0130_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0130_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0130_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0130_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0130_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0130_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0130_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0130_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0130_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0130_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0130_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0130_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0130_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0130_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0130_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0130_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0130_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0130_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0130_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0130_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0130_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0130_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0130_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0130_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0130_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public BigDecimal getR0130_nat_amt() {
		return r0130_nat_amt;
	}
	public void setR0130_nat_amt(BigDecimal r0130_nat_amt) {
		this.r0130_nat_amt = r0130_nat_amt;
	}
	public BigDecimal getR0130_non_res_nat_amt() {
		return r0130_non_res_nat_amt;
	}
	public void setR0130_non_res_nat_amt(BigDecimal r0130_non_res_nat_amt) {
		this.r0130_non_res_nat_amt = r0130_non_res_nat_amt;
	}
	public BigDecimal getR0130_over_3_years_nat_amt() {
		return r0130_over_3_years_nat_amt;
	}
	public void setR0130_over_3_years_nat_amt(BigDecimal r0130_over_3_years_nat_amt) {
		this.r0130_over_3_years_nat_amt = r0130_over_3_years_nat_amt;
	}
	public BigDecimal getR0130_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0130_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0130_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0130_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0130_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0130_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0130_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0130_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0130_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0130_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0130_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0130_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0130_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0130_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0130_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0130_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0130_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0130_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0130_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0130_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0130_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0130_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0130_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0130_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0130_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0130_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0130_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0130_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0130_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0130_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0130_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0130_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0130_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0130_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0130_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0130_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0130_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0130_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0130_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0130_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0130_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0130_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0130_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0130_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0130_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0130_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0130_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0130_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0130_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0130_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0130_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0130_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0130_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0130_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0130_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0130_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0130_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0130_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0130_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0130_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0130_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0130_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0130_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0130_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0130_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0130_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0130_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0130_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0130_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0130_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0130_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0130_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public String getR0130_product() {
		return r0130_product;
	}
	public void setR0130_product(String r0130_product) {
		this.r0130_product = r0130_product;
	}
	public BigDecimal getR0130_pro_bought_net_gain_loss() {
		return r0130_pro_bought_net_gain_loss;
	}
	public void setR0130_pro_bought_net_gain_loss(BigDecimal r0130_pro_bought_net_gain_loss) {
		this.r0130_pro_bought_net_gain_loss = r0130_pro_bought_net_gain_loss;
	}
	public BigDecimal getR0130_pro_sold_net_gain_loss() {
		return r0130_pro_sold_net_gain_loss;
	}
	public void setR0130_pro_sold_net_gain_loss(BigDecimal r0130_pro_sold_net_gain_loss) {
		this.r0130_pro_sold_net_gain_loss = r0130_pro_sold_net_gain_loss;
	}
	public BigDecimal getR0130_res_1_to_3_years_mkt_val() {
		return r0130_res_1_to_3_years_mkt_val;
	}
	public void setR0130_res_1_to_3_years_mkt_val(BigDecimal r0130_res_1_to_3_years_mkt_val) {
		this.r0130_res_1_to_3_years_mkt_val = r0130_res_1_to_3_years_mkt_val;
	}
	public BigDecimal getR0130_res_lessthan_1_year_mkt_val() {
		return r0130_res_lessthan_1_year_mkt_val;
	}
	public void setR0130_res_lessthan_1_year_mkt_val(BigDecimal r0130_res_lessthan_1_year_mkt_val) {
		this.r0130_res_lessthan_1_year_mkt_val = r0130_res_lessthan_1_year_mkt_val;
	}
	public BigDecimal getR0130_res_morethan_3_years_mkt_val() {
		return r0130_res_morethan_3_years_mkt_val;
	}
	public void setR0130_res_morethan_3_years_mkt_val(BigDecimal r0130_res_morethan_3_years_mkt_val) {
		this.r0130_res_morethan_3_years_mkt_val = r0130_res_morethan_3_years_mkt_val;
	}
	public BigDecimal getR0130_res_nat_amt() {
		return r0130_res_nat_amt;
	}
	public void setR0130_res_nat_amt(BigDecimal r0130_res_nat_amt) {
		this.r0130_res_nat_amt = r0130_res_nat_amt;
	}
	public BigDecimal getR0130_sold_hedg_net_delta_pos() {
		return r0130_sold_hedg_net_delta_pos;
	}
	public void setR0130_sold_hedg_net_delta_pos(BigDecimal r0130_sold_hedg_net_delta_pos) {
		this.r0130_sold_hedg_net_delta_pos = r0130_sold_hedg_net_delta_pos;
	}
	public BigDecimal getR0130_sold_trad_net_delta_pos() {
		return r0130_sold_trad_net_delta_pos;
	}
	public void setR0130_sold_trad_net_delta_pos(BigDecimal r0130_sold_trad_net_delta_pos) {
		this.r0130_sold_trad_net_delta_pos = r0130_sold_trad_net_delta_pos;
	}
	public BigDecimal getR0130_trad_nat_amt() {
		return r0130_trad_nat_amt;
	}
	public void setR0130_trad_nat_amt(BigDecimal r0130_trad_nat_amt) {
		this.r0130_trad_nat_amt = r0130_trad_nat_amt;
	}
	public BigDecimal getR0130_within_1_year_nat_amt() {
		return r0130_within_1_year_nat_amt;
	}
	public void setR0130_within_1_year_nat_amt(BigDecimal r0130_within_1_year_nat_amt) {
		this.r0130_within_1_year_nat_amt = r0130_within_1_year_nat_amt;
	}
	public BigDecimal getR0140_1_to_3_years_nat_amt() {
		return r0140_1_to_3_years_nat_amt;
	}
	public void setR0140_1_to_3_years_nat_amt(BigDecimal r0140_1_to_3_years_nat_amt) {
		this.r0140_1_to_3_years_nat_amt = r0140_1_to_3_years_nat_amt;
	}
	public BigDecimal getR0140_bought_hedg_net_delta_pos() {
		return r0140_bought_hedg_net_delta_pos;
	}
	public void setR0140_bought_hedg_net_delta_pos(BigDecimal r0140_bought_hedg_net_delta_pos) {
		this.r0140_bought_hedg_net_delta_pos = r0140_bought_hedg_net_delta_pos;
	}
	public BigDecimal getR0140_bought_trad_net_delta_pos() {
		return r0140_bought_trad_net_delta_pos;
	}
	public void setR0140_bought_trad_net_delta_pos(BigDecimal r0140_bought_trad_net_delta_pos) {
		this.r0140_bought_trad_net_delta_pos = r0140_bought_trad_net_delta_pos;
	}
	public BigDecimal getR0140_gross_mkt_val() {
		return r0140_gross_mkt_val;
	}
	public void setR0140_gross_mkt_val(BigDecimal r0140_gross_mkt_val) {
		this.r0140_gross_mkt_val = r0140_gross_mkt_val;
	}
	public BigDecimal getR0140_hedg_nat_amt() {
		return r0140_hedg_nat_amt;
	}
	public void setR0140_hedg_nat_amt(BigDecimal r0140_hedg_nat_amt) {
		this.r0140_hedg_nat_amt = r0140_hedg_nat_amt;
	}
	public BigDecimal getR0140_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0140_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0140_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0140_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0140_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0140_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0140_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0140_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0140_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0140_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0140_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0140_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0140_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0140_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0140_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0140_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0140_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0140_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0140_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0140_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0140_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0140_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0140_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0140_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0140_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0140_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0140_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0140_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0140_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0140_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0140_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0140_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0140_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0140_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0140_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0140_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0140_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0140_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0140_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0140_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0140_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0140_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0140_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0140_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0140_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0140_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0140_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0140_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0140_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0140_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0140_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0140_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0140_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0140_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0140_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0140_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0140_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0140_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0140_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0140_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0140_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0140_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0140_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0140_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0140_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0140_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0140_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0140_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0140_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0140_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0140_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0140_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public BigDecimal getR0140_nat_amt() {
		return r0140_nat_amt;
	}
	public void setR0140_nat_amt(BigDecimal r0140_nat_amt) {
		this.r0140_nat_amt = r0140_nat_amt;
	}
	public BigDecimal getR0140_non_res_nat_amt() {
		return r0140_non_res_nat_amt;
	}
	public void setR0140_non_res_nat_amt(BigDecimal r0140_non_res_nat_amt) {
		this.r0140_non_res_nat_amt = r0140_non_res_nat_amt;
	}
	public BigDecimal getR0140_over_3_years_nat_amt() {
		return r0140_over_3_years_nat_amt;
	}
	public void setR0140_over_3_years_nat_amt(BigDecimal r0140_over_3_years_nat_amt) {
		this.r0140_over_3_years_nat_amt = r0140_over_3_years_nat_amt;
	}
	public BigDecimal getR0140_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0140_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0140_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0140_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0140_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0140_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0140_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0140_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0140_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0140_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0140_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0140_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0140_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0140_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0140_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0140_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0140_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0140_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0140_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0140_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0140_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0140_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0140_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0140_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0140_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0140_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0140_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0140_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0140_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0140_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0140_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0140_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0140_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0140_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0140_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0140_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0140_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0140_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0140_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0140_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0140_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0140_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0140_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0140_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0140_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0140_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0140_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0140_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0140_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0140_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0140_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0140_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0140_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0140_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0140_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0140_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0140_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0140_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0140_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0140_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0140_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0140_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0140_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0140_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0140_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0140_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0140_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0140_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0140_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0140_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0140_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0140_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public String getR0140_product() {
		return r0140_product;
	}
	public void setR0140_product(String r0140_product) {
		this.r0140_product = r0140_product;
	}
	public BigDecimal getR0140_pro_bought_net_gain_loss() {
		return r0140_pro_bought_net_gain_loss;
	}
	public void setR0140_pro_bought_net_gain_loss(BigDecimal r0140_pro_bought_net_gain_loss) {
		this.r0140_pro_bought_net_gain_loss = r0140_pro_bought_net_gain_loss;
	}
	public BigDecimal getR0140_pro_sold_net_gain_loss() {
		return r0140_pro_sold_net_gain_loss;
	}
	public void setR0140_pro_sold_net_gain_loss(BigDecimal r0140_pro_sold_net_gain_loss) {
		this.r0140_pro_sold_net_gain_loss = r0140_pro_sold_net_gain_loss;
	}
	public BigDecimal getR0140_res_1_to_3_years_mkt_val() {
		return r0140_res_1_to_3_years_mkt_val;
	}
	public void setR0140_res_1_to_3_years_mkt_val(BigDecimal r0140_res_1_to_3_years_mkt_val) {
		this.r0140_res_1_to_3_years_mkt_val = r0140_res_1_to_3_years_mkt_val;
	}
	public BigDecimal getR0140_res_lessthan_1_year_mkt_val() {
		return r0140_res_lessthan_1_year_mkt_val;
	}
	public void setR0140_res_lessthan_1_year_mkt_val(BigDecimal r0140_res_lessthan_1_year_mkt_val) {
		this.r0140_res_lessthan_1_year_mkt_val = r0140_res_lessthan_1_year_mkt_val;
	}
	public BigDecimal getR0140_res_morethan_3_years_mkt_val() {
		return r0140_res_morethan_3_years_mkt_val;
	}
	public void setR0140_res_morethan_3_years_mkt_val(BigDecimal r0140_res_morethan_3_years_mkt_val) {
		this.r0140_res_morethan_3_years_mkt_val = r0140_res_morethan_3_years_mkt_val;
	}
	public BigDecimal getR0140_res_nat_amt() {
		return r0140_res_nat_amt;
	}
	public void setR0140_res_nat_amt(BigDecimal r0140_res_nat_amt) {
		this.r0140_res_nat_amt = r0140_res_nat_amt;
	}
	public BigDecimal getR0140_sold_hedg_net_delta_pos() {
		return r0140_sold_hedg_net_delta_pos;
	}
	public void setR0140_sold_hedg_net_delta_pos(BigDecimal r0140_sold_hedg_net_delta_pos) {
		this.r0140_sold_hedg_net_delta_pos = r0140_sold_hedg_net_delta_pos;
	}
	public BigDecimal getR0140_sold_trad_net_delta_pos() {
		return r0140_sold_trad_net_delta_pos;
	}
	public void setR0140_sold_trad_net_delta_pos(BigDecimal r0140_sold_trad_net_delta_pos) {
		this.r0140_sold_trad_net_delta_pos = r0140_sold_trad_net_delta_pos;
	}
	public BigDecimal getR0140_trad_nat_amt() {
		return r0140_trad_nat_amt;
	}
	public void setR0140_trad_nat_amt(BigDecimal r0140_trad_nat_amt) {
		this.r0140_trad_nat_amt = r0140_trad_nat_amt;
	}
	public BigDecimal getR0140_within_1_year_nat_amt() {
		return r0140_within_1_year_nat_amt;
	}
	public void setR0140_within_1_year_nat_amt(BigDecimal r0140_within_1_year_nat_amt) {
		this.r0140_within_1_year_nat_amt = r0140_within_1_year_nat_amt;
	}
	public BigDecimal getR0150_1_to_3_years_nat_amt() {
		return r0150_1_to_3_years_nat_amt;
	}
	public void setR0150_1_to_3_years_nat_amt(BigDecimal r0150_1_to_3_years_nat_amt) {
		this.r0150_1_to_3_years_nat_amt = r0150_1_to_3_years_nat_amt;
	}
	public BigDecimal getR0150_bought_hedg_net_delta_pos() {
		return r0150_bought_hedg_net_delta_pos;
	}
	public void setR0150_bought_hedg_net_delta_pos(BigDecimal r0150_bought_hedg_net_delta_pos) {
		this.r0150_bought_hedg_net_delta_pos = r0150_bought_hedg_net_delta_pos;
	}
	public BigDecimal getR0150_bought_trad_net_delta_pos() {
		return r0150_bought_trad_net_delta_pos;
	}
	public void setR0150_bought_trad_net_delta_pos(BigDecimal r0150_bought_trad_net_delta_pos) {
		this.r0150_bought_trad_net_delta_pos = r0150_bought_trad_net_delta_pos;
	}
	public BigDecimal getR0150_gross_mkt_val() {
		return r0150_gross_mkt_val;
	}
	public void setR0150_gross_mkt_val(BigDecimal r0150_gross_mkt_val) {
		this.r0150_gross_mkt_val = r0150_gross_mkt_val;
	}
	public BigDecimal getR0150_hedg_nat_amt() {
		return r0150_hedg_nat_amt;
	}
	public void setR0150_hedg_nat_amt(BigDecimal r0150_hedg_nat_amt) {
		this.r0150_hedg_nat_amt = r0150_hedg_nat_amt;
	}
	public BigDecimal getR0150_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0150_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0150_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0150_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0150_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0150_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0150_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0150_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0150_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0150_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0150_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0150_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0150_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0150_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0150_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0150_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0150_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0150_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0150_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0150_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0150_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0150_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0150_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0150_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0150_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0150_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0150_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0150_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0150_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0150_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0150_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0150_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0150_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0150_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0150_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0150_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0150_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0150_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0150_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0150_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0150_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0150_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0150_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0150_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0150_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0150_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0150_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0150_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0150_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0150_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0150_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0150_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0150_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0150_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0150_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0150_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0150_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0150_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0150_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0150_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0150_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0150_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0150_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0150_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0150_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0150_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0150_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0150_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0150_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0150_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0150_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0150_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public BigDecimal getR0150_nat_amt() {
		return r0150_nat_amt;
	}
	public void setR0150_nat_amt(BigDecimal r0150_nat_amt) {
		this.r0150_nat_amt = r0150_nat_amt;
	}
	public BigDecimal getR0150_non_res_nat_amt() {
		return r0150_non_res_nat_amt;
	}
	public void setR0150_non_res_nat_amt(BigDecimal r0150_non_res_nat_amt) {
		this.r0150_non_res_nat_amt = r0150_non_res_nat_amt;
	}
	public BigDecimal getR0150_over_3_years_nat_amt() {
		return r0150_over_3_years_nat_amt;
	}
	public void setR0150_over_3_years_nat_amt(BigDecimal r0150_over_3_years_nat_amt) {
		this.r0150_over_3_years_nat_amt = r0150_over_3_years_nat_amt;
	}
	public BigDecimal getR0150_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0150_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0150_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0150_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0150_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0150_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0150_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0150_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0150_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0150_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0150_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0150_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0150_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0150_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0150_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0150_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0150_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0150_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0150_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0150_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0150_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0150_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0150_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0150_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0150_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0150_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0150_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0150_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0150_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0150_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0150_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0150_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0150_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0150_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0150_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0150_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0150_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0150_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0150_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0150_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0150_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0150_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0150_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0150_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0150_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0150_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0150_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0150_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0150_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0150_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0150_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0150_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0150_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0150_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0150_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0150_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0150_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0150_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0150_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0150_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0150_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0150_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0150_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0150_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0150_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0150_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0150_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0150_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0150_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0150_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0150_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0150_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public String getR0150_product() {
		return r0150_product;
	}
	public void setR0150_product(String r0150_product) {
		this.r0150_product = r0150_product;
	}
	public BigDecimal getR0150_pro_bought_net_gain_loss() {
		return r0150_pro_bought_net_gain_loss;
	}
	public void setR0150_pro_bought_net_gain_loss(BigDecimal r0150_pro_bought_net_gain_loss) {
		this.r0150_pro_bought_net_gain_loss = r0150_pro_bought_net_gain_loss;
	}
	public BigDecimal getR0150_pro_sold_net_gain_loss() {
		return r0150_pro_sold_net_gain_loss;
	}
	public void setR0150_pro_sold_net_gain_loss(BigDecimal r0150_pro_sold_net_gain_loss) {
		this.r0150_pro_sold_net_gain_loss = r0150_pro_sold_net_gain_loss;
	}
	public BigDecimal getR0150_res_1_to_3_years_mkt_val() {
		return r0150_res_1_to_3_years_mkt_val;
	}
	public void setR0150_res_1_to_3_years_mkt_val(BigDecimal r0150_res_1_to_3_years_mkt_val) {
		this.r0150_res_1_to_3_years_mkt_val = r0150_res_1_to_3_years_mkt_val;
	}
	public BigDecimal getR0150_res_lessthan_1_year_mkt_val() {
		return r0150_res_lessthan_1_year_mkt_val;
	}
	public void setR0150_res_lessthan_1_year_mkt_val(BigDecimal r0150_res_lessthan_1_year_mkt_val) {
		this.r0150_res_lessthan_1_year_mkt_val = r0150_res_lessthan_1_year_mkt_val;
	}
	public BigDecimal getR0150_res_morethan_3_years_mkt_val() {
		return r0150_res_morethan_3_years_mkt_val;
	}
	public void setR0150_res_morethan_3_years_mkt_val(BigDecimal r0150_res_morethan_3_years_mkt_val) {
		this.r0150_res_morethan_3_years_mkt_val = r0150_res_morethan_3_years_mkt_val;
	}
	public BigDecimal getR0150_res_nat_amt() {
		return r0150_res_nat_amt;
	}
	public void setR0150_res_nat_amt(BigDecimal r0150_res_nat_amt) {
		this.r0150_res_nat_amt = r0150_res_nat_amt;
	}
	public BigDecimal getR0150_sold_hedg_net_delta_pos() {
		return r0150_sold_hedg_net_delta_pos;
	}
	public void setR0150_sold_hedg_net_delta_pos(BigDecimal r0150_sold_hedg_net_delta_pos) {
		this.r0150_sold_hedg_net_delta_pos = r0150_sold_hedg_net_delta_pos;
	}
	public BigDecimal getR0150_sold_trad_net_delta_pos() {
		return r0150_sold_trad_net_delta_pos;
	}
	public void setR0150_sold_trad_net_delta_pos(BigDecimal r0150_sold_trad_net_delta_pos) {
		this.r0150_sold_trad_net_delta_pos = r0150_sold_trad_net_delta_pos;
	}
	public BigDecimal getR0150_trad_nat_amt() {
		return r0150_trad_nat_amt;
	}
	public void setR0150_trad_nat_amt(BigDecimal r0150_trad_nat_amt) {
		this.r0150_trad_nat_amt = r0150_trad_nat_amt;
	}
	public BigDecimal getR0150_within_1_year_nat_amt() {
		return r0150_within_1_year_nat_amt;
	}
	public void setR0150_within_1_year_nat_amt(BigDecimal r0150_within_1_year_nat_amt) {
		this.r0150_within_1_year_nat_amt = r0150_within_1_year_nat_amt;
	}
	public BigDecimal getR0160_1_to_3_years_nat_amt() {
		return r0160_1_to_3_years_nat_amt;
	}
	public void setR0160_1_to_3_years_nat_amt(BigDecimal r0160_1_to_3_years_nat_amt) {
		this.r0160_1_to_3_years_nat_amt = r0160_1_to_3_years_nat_amt;
	}
	public BigDecimal getR0160_bought_hedg_net_delta_pos() {
		return r0160_bought_hedg_net_delta_pos;
	}
	public void setR0160_bought_hedg_net_delta_pos(BigDecimal r0160_bought_hedg_net_delta_pos) {
		this.r0160_bought_hedg_net_delta_pos = r0160_bought_hedg_net_delta_pos;
	}
	public BigDecimal getR0160_bought_trad_net_delta_pos() {
		return r0160_bought_trad_net_delta_pos;
	}
	public void setR0160_bought_trad_net_delta_pos(BigDecimal r0160_bought_trad_net_delta_pos) {
		this.r0160_bought_trad_net_delta_pos = r0160_bought_trad_net_delta_pos;
	}
	public BigDecimal getR0160_gross_mkt_val() {
		return r0160_gross_mkt_val;
	}
	public void setR0160_gross_mkt_val(BigDecimal r0160_gross_mkt_val) {
		this.r0160_gross_mkt_val = r0160_gross_mkt_val;
	}
	public BigDecimal getR0160_hedg_nat_amt() {
		return r0160_hedg_nat_amt;
	}
	public void setR0160_hedg_nat_amt(BigDecimal r0160_hedg_nat_amt) {
		this.r0160_hedg_nat_amt = r0160_hedg_nat_amt;
	}
	public BigDecimal getR0160_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0160_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0160_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0160_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0160_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0160_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0160_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0160_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0160_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0160_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0160_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0160_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0160_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0160_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0160_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0160_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0160_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0160_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0160_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0160_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0160_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0160_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0160_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0160_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0160_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0160_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0160_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0160_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0160_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0160_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0160_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0160_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0160_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0160_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0160_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0160_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0160_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0160_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0160_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0160_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0160_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0160_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0160_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0160_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0160_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0160_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0160_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0160_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0160_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0160_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0160_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0160_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0160_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0160_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0160_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0160_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0160_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0160_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0160_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0160_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0160_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0160_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0160_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0160_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0160_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0160_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0160_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0160_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0160_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0160_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0160_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0160_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public BigDecimal getR0160_nat_amt() {
		return r0160_nat_amt;
	}
	public void setR0160_nat_amt(BigDecimal r0160_nat_amt) {
		this.r0160_nat_amt = r0160_nat_amt;
	}
	public BigDecimal getR0160_non_res_nat_amt() {
		return r0160_non_res_nat_amt;
	}
	public void setR0160_non_res_nat_amt(BigDecimal r0160_non_res_nat_amt) {
		this.r0160_non_res_nat_amt = r0160_non_res_nat_amt;
	}
	public BigDecimal getR0160_over_3_years_nat_amt() {
		return r0160_over_3_years_nat_amt;
	}
	public void setR0160_over_3_years_nat_amt(BigDecimal r0160_over_3_years_nat_amt) {
		this.r0160_over_3_years_nat_amt = r0160_over_3_years_nat_amt;
	}
	public BigDecimal getR0160_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0160_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0160_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0160_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0160_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0160_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0160_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0160_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0160_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0160_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0160_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0160_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0160_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0160_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0160_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0160_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0160_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0160_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0160_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0160_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0160_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0160_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0160_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0160_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0160_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0160_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0160_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0160_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0160_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0160_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0160_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0160_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0160_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0160_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0160_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0160_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0160_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0160_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0160_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0160_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0160_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0160_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0160_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0160_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0160_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0160_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0160_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0160_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0160_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0160_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0160_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0160_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0160_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0160_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0160_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0160_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0160_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0160_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0160_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0160_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0160_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0160_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0160_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0160_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0160_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0160_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0160_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0160_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0160_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0160_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0160_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0160_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public String getR0160_product() {
		return r0160_product;
	}
	public void setR0160_product(String r0160_product) {
		this.r0160_product = r0160_product;
	}
	public BigDecimal getR0160_pro_bought_net_gain_loss() {
		return r0160_pro_bought_net_gain_loss;
	}
	public void setR0160_pro_bought_net_gain_loss(BigDecimal r0160_pro_bought_net_gain_loss) {
		this.r0160_pro_bought_net_gain_loss = r0160_pro_bought_net_gain_loss;
	}
	public BigDecimal getR0160_pro_sold_net_gain_loss() {
		return r0160_pro_sold_net_gain_loss;
	}
	public void setR0160_pro_sold_net_gain_loss(BigDecimal r0160_pro_sold_net_gain_loss) {
		this.r0160_pro_sold_net_gain_loss = r0160_pro_sold_net_gain_loss;
	}
	public BigDecimal getR0160_res_1_to_3_years_mkt_val() {
		return r0160_res_1_to_3_years_mkt_val;
	}
	public void setR0160_res_1_to_3_years_mkt_val(BigDecimal r0160_res_1_to_3_years_mkt_val) {
		this.r0160_res_1_to_3_years_mkt_val = r0160_res_1_to_3_years_mkt_val;
	}
	public BigDecimal getR0160_res_lessthan_1_year_mkt_val() {
		return r0160_res_lessthan_1_year_mkt_val;
	}
	public void setR0160_res_lessthan_1_year_mkt_val(BigDecimal r0160_res_lessthan_1_year_mkt_val) {
		this.r0160_res_lessthan_1_year_mkt_val = r0160_res_lessthan_1_year_mkt_val;
	}
	public BigDecimal getR0160_res_morethan_3_years_mkt_val() {
		return r0160_res_morethan_3_years_mkt_val;
	}
	public void setR0160_res_morethan_3_years_mkt_val(BigDecimal r0160_res_morethan_3_years_mkt_val) {
		this.r0160_res_morethan_3_years_mkt_val = r0160_res_morethan_3_years_mkt_val;
	}
	public BigDecimal getR0160_res_nat_amt() {
		return r0160_res_nat_amt;
	}
	public void setR0160_res_nat_amt(BigDecimal r0160_res_nat_amt) {
		this.r0160_res_nat_amt = r0160_res_nat_amt;
	}
	public BigDecimal getR0160_sold_hedg_net_delta_pos() {
		return r0160_sold_hedg_net_delta_pos;
	}
	public void setR0160_sold_hedg_net_delta_pos(BigDecimal r0160_sold_hedg_net_delta_pos) {
		this.r0160_sold_hedg_net_delta_pos = r0160_sold_hedg_net_delta_pos;
	}
	public BigDecimal getR0160_sold_trad_net_delta_pos() {
		return r0160_sold_trad_net_delta_pos;
	}
	public void setR0160_sold_trad_net_delta_pos(BigDecimal r0160_sold_trad_net_delta_pos) {
		this.r0160_sold_trad_net_delta_pos = r0160_sold_trad_net_delta_pos;
	}
	public BigDecimal getR0160_trad_nat_amt() {
		return r0160_trad_nat_amt;
	}
	public void setR0160_trad_nat_amt(BigDecimal r0160_trad_nat_amt) {
		this.r0160_trad_nat_amt = r0160_trad_nat_amt;
	}
	public BigDecimal getR0160_within_1_year_nat_amt() {
		return r0160_within_1_year_nat_amt;
	}
	public void setR0160_within_1_year_nat_amt(BigDecimal r0160_within_1_year_nat_amt) {
		this.r0160_within_1_year_nat_amt = r0160_within_1_year_nat_amt;
	}
	public BigDecimal getR0170_1_to_3_years_nat_amt() {
		return r0170_1_to_3_years_nat_amt;
	}
	public void setR0170_1_to_3_years_nat_amt(BigDecimal r0170_1_to_3_years_nat_amt) {
		this.r0170_1_to_3_years_nat_amt = r0170_1_to_3_years_nat_amt;
	}
	public BigDecimal getR0170_bought_hedg_net_delta_pos() {
		return r0170_bought_hedg_net_delta_pos;
	}
	public void setR0170_bought_hedg_net_delta_pos(BigDecimal r0170_bought_hedg_net_delta_pos) {
		this.r0170_bought_hedg_net_delta_pos = r0170_bought_hedg_net_delta_pos;
	}
	public BigDecimal getR0170_bought_trad_net_delta_pos() {
		return r0170_bought_trad_net_delta_pos;
	}
	public void setR0170_bought_trad_net_delta_pos(BigDecimal r0170_bought_trad_net_delta_pos) {
		this.r0170_bought_trad_net_delta_pos = r0170_bought_trad_net_delta_pos;
	}
	public BigDecimal getR0170_gross_mkt_val() {
		return r0170_gross_mkt_val;
	}
	public void setR0170_gross_mkt_val(BigDecimal r0170_gross_mkt_val) {
		this.r0170_gross_mkt_val = r0170_gross_mkt_val;
	}
	public BigDecimal getR0170_hedg_nat_amt() {
		return r0170_hedg_nat_amt;
	}
	public void setR0170_hedg_nat_amt(BigDecimal r0170_hedg_nat_amt) {
		this.r0170_hedg_nat_amt = r0170_hedg_nat_amt;
	}
	public BigDecimal getR0170_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0170_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0170_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0170_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0170_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0170_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0170_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0170_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0170_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0170_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0170_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0170_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0170_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0170_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0170_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0170_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0170_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0170_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0170_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0170_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0170_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0170_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0170_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0170_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0170_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0170_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0170_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0170_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0170_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0170_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0170_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0170_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0170_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0170_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0170_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0170_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0170_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0170_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0170_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0170_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0170_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0170_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0170_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0170_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0170_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0170_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0170_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0170_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0170_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0170_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0170_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0170_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0170_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0170_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0170_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0170_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0170_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0170_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0170_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0170_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0170_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0170_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0170_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0170_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0170_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0170_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0170_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0170_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0170_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0170_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0170_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0170_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public BigDecimal getR0170_nat_amt() {
		return r0170_nat_amt;
	}
	public void setR0170_nat_amt(BigDecimal r0170_nat_amt) {
		this.r0170_nat_amt = r0170_nat_amt;
	}
	public BigDecimal getR0170_non_res_nat_amt() {
		return r0170_non_res_nat_amt;
	}
	public void setR0170_non_res_nat_amt(BigDecimal r0170_non_res_nat_amt) {
		this.r0170_non_res_nat_amt = r0170_non_res_nat_amt;
	}
	public BigDecimal getR0170_over_3_years_nat_amt() {
		return r0170_over_3_years_nat_amt;
	}
	public void setR0170_over_3_years_nat_amt(BigDecimal r0170_over_3_years_nat_amt) {
		this.r0170_over_3_years_nat_amt = r0170_over_3_years_nat_amt;
	}
	public BigDecimal getR0170_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0170_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0170_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0170_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0170_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0170_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0170_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0170_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0170_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0170_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0170_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0170_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0170_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0170_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0170_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0170_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0170_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0170_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0170_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0170_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0170_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0170_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0170_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0170_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0170_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0170_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0170_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0170_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0170_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0170_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0170_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0170_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0170_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0170_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0170_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0170_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0170_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0170_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0170_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0170_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0170_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0170_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0170_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0170_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0170_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0170_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0170_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0170_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0170_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0170_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0170_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0170_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0170_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0170_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0170_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0170_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0170_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0170_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0170_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0170_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0170_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0170_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0170_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0170_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0170_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0170_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0170_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0170_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0170_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0170_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0170_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0170_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public String getR0170_product() {
		return r0170_product;
	}
	public void setR0170_product(String r0170_product) {
		this.r0170_product = r0170_product;
	}
	public BigDecimal getR0170_pro_bought_net_gain_loss() {
		return r0170_pro_bought_net_gain_loss;
	}
	public void setR0170_pro_bought_net_gain_loss(BigDecimal r0170_pro_bought_net_gain_loss) {
		this.r0170_pro_bought_net_gain_loss = r0170_pro_bought_net_gain_loss;
	}
	public BigDecimal getR0170_pro_sold_net_gain_loss() {
		return r0170_pro_sold_net_gain_loss;
	}
	public void setR0170_pro_sold_net_gain_loss(BigDecimal r0170_pro_sold_net_gain_loss) {
		this.r0170_pro_sold_net_gain_loss = r0170_pro_sold_net_gain_loss;
	}
	public BigDecimal getR0170_res_1_to_3_years_mkt_val() {
		return r0170_res_1_to_3_years_mkt_val;
	}
	public void setR0170_res_1_to_3_years_mkt_val(BigDecimal r0170_res_1_to_3_years_mkt_val) {
		this.r0170_res_1_to_3_years_mkt_val = r0170_res_1_to_3_years_mkt_val;
	}
	public BigDecimal getR0170_res_lessthan_1_year_mkt_val() {
		return r0170_res_lessthan_1_year_mkt_val;
	}
	public void setR0170_res_lessthan_1_year_mkt_val(BigDecimal r0170_res_lessthan_1_year_mkt_val) {
		this.r0170_res_lessthan_1_year_mkt_val = r0170_res_lessthan_1_year_mkt_val;
	}
	public BigDecimal getR0170_res_morethan_3_years_mkt_val() {
		return r0170_res_morethan_3_years_mkt_val;
	}
	public void setR0170_res_morethan_3_years_mkt_val(BigDecimal r0170_res_morethan_3_years_mkt_val) {
		this.r0170_res_morethan_3_years_mkt_val = r0170_res_morethan_3_years_mkt_val;
	}
	public BigDecimal getR0170_res_nat_amt() {
		return r0170_res_nat_amt;
	}
	public void setR0170_res_nat_amt(BigDecimal r0170_res_nat_amt) {
		this.r0170_res_nat_amt = r0170_res_nat_amt;
	}
	public BigDecimal getR0170_sold_hedg_net_delta_pos() {
		return r0170_sold_hedg_net_delta_pos;
	}
	public void setR0170_sold_hedg_net_delta_pos(BigDecimal r0170_sold_hedg_net_delta_pos) {
		this.r0170_sold_hedg_net_delta_pos = r0170_sold_hedg_net_delta_pos;
	}
	public BigDecimal getR0170_sold_trad_net_delta_pos() {
		return r0170_sold_trad_net_delta_pos;
	}
	public void setR0170_sold_trad_net_delta_pos(BigDecimal r0170_sold_trad_net_delta_pos) {
		this.r0170_sold_trad_net_delta_pos = r0170_sold_trad_net_delta_pos;
	}
	public BigDecimal getR0170_trad_nat_amt() {
		return r0170_trad_nat_amt;
	}
	public void setR0170_trad_nat_amt(BigDecimal r0170_trad_nat_amt) {
		this.r0170_trad_nat_amt = r0170_trad_nat_amt;
	}
	public BigDecimal getR0170_within_1_year_nat_amt() {
		return r0170_within_1_year_nat_amt;
	}
	public void setR0170_within_1_year_nat_amt(BigDecimal r0170_within_1_year_nat_amt) {
		this.r0170_within_1_year_nat_amt = r0170_within_1_year_nat_amt;
	}
	public String getR0180_product() {
		return r0180_product;
	}
	public void setR0180_product(String r0180_product) {
		this.r0180_product = r0180_product;
	}
	public BigDecimal getR0190_1_to_3_years_nat_amt() {
		return r0190_1_to_3_years_nat_amt;
	}
	public void setR0190_1_to_3_years_nat_amt(BigDecimal r0190_1_to_3_years_nat_amt) {
		this.r0190_1_to_3_years_nat_amt = r0190_1_to_3_years_nat_amt;
	}
	public BigDecimal getR0190_bought_hedg_net_delta_pos() {
		return r0190_bought_hedg_net_delta_pos;
	}
	public void setR0190_bought_hedg_net_delta_pos(BigDecimal r0190_bought_hedg_net_delta_pos) {
		this.r0190_bought_hedg_net_delta_pos = r0190_bought_hedg_net_delta_pos;
	}
	public BigDecimal getR0190_bought_trad_net_delta_pos() {
		return r0190_bought_trad_net_delta_pos;
	}
	public void setR0190_bought_trad_net_delta_pos(BigDecimal r0190_bought_trad_net_delta_pos) {
		this.r0190_bought_trad_net_delta_pos = r0190_bought_trad_net_delta_pos;
	}
	public BigDecimal getR0190_gross_mkt_val() {
		return r0190_gross_mkt_val;
	}
	public void setR0190_gross_mkt_val(BigDecimal r0190_gross_mkt_val) {
		this.r0190_gross_mkt_val = r0190_gross_mkt_val;
	}
	public BigDecimal getR0190_hedg_nat_amt() {
		return r0190_hedg_nat_amt;
	}
	public void setR0190_hedg_nat_amt(BigDecimal r0190_hedg_nat_amt) {
		this.r0190_hedg_nat_amt = r0190_hedg_nat_amt;
	}
	public BigDecimal getR0190_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0190_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0190_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0190_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0190_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0190_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0190_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0190_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0190_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0190_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0190_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0190_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0190_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0190_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0190_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0190_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0190_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0190_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0190_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0190_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0190_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0190_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0190_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0190_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0190_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0190_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0190_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0190_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0190_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0190_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0190_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0190_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0190_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0190_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0190_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0190_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0190_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0190_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0190_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0190_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0190_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0190_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0190_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0190_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0190_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0190_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0190_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0190_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0190_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0190_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0190_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0190_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0190_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0190_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0190_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0190_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0190_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0190_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0190_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0190_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0190_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0190_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0190_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0190_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0190_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0190_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0190_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0190_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0190_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0190_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0190_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0190_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public BigDecimal getR0190_nat_amt() {
		return r0190_nat_amt;
	}
	public void setR0190_nat_amt(BigDecimal r0190_nat_amt) {
		this.r0190_nat_amt = r0190_nat_amt;
	}
	public BigDecimal getR0190_non_res_nat_amt() {
		return r0190_non_res_nat_amt;
	}
	public void setR0190_non_res_nat_amt(BigDecimal r0190_non_res_nat_amt) {
		this.r0190_non_res_nat_amt = r0190_non_res_nat_amt;
	}
	public BigDecimal getR0190_over_3_years_nat_amt() {
		return r0190_over_3_years_nat_amt;
	}
	public void setR0190_over_3_years_nat_amt(BigDecimal r0190_over_3_years_nat_amt) {
		this.r0190_over_3_years_nat_amt = r0190_over_3_years_nat_amt;
	}
	public BigDecimal getR0190_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0190_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0190_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0190_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0190_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0190_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0190_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0190_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0190_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0190_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0190_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0190_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0190_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0190_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0190_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0190_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0190_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0190_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0190_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0190_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0190_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0190_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0190_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0190_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0190_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0190_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0190_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0190_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0190_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0190_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0190_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0190_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0190_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0190_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0190_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0190_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0190_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0190_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0190_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0190_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0190_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0190_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0190_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0190_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0190_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0190_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0190_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0190_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0190_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0190_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0190_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0190_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0190_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0190_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0190_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0190_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0190_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0190_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0190_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0190_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0190_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0190_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0190_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0190_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0190_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0190_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0190_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0190_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0190_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0190_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0190_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0190_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public String getR0190_product() {
		return r0190_product;
	}
	public void setR0190_product(String r0190_product) {
		this.r0190_product = r0190_product;
	}
	public BigDecimal getR0190_pro_bought_net_gain_loss() {
		return r0190_pro_bought_net_gain_loss;
	}
	public void setR0190_pro_bought_net_gain_loss(BigDecimal r0190_pro_bought_net_gain_loss) {
		this.r0190_pro_bought_net_gain_loss = r0190_pro_bought_net_gain_loss;
	}
	public BigDecimal getR0190_pro_sold_net_gain_loss() {
		return r0190_pro_sold_net_gain_loss;
	}
	public void setR0190_pro_sold_net_gain_loss(BigDecimal r0190_pro_sold_net_gain_loss) {
		this.r0190_pro_sold_net_gain_loss = r0190_pro_sold_net_gain_loss;
	}
	public BigDecimal getR0190_res_1_to_3_years_mkt_val() {
		return r0190_res_1_to_3_years_mkt_val;
	}
	public void setR0190_res_1_to_3_years_mkt_val(BigDecimal r0190_res_1_to_3_years_mkt_val) {
		this.r0190_res_1_to_3_years_mkt_val = r0190_res_1_to_3_years_mkt_val;
	}
	public BigDecimal getR0190_res_lessthan_1_year_mkt_val() {
		return r0190_res_lessthan_1_year_mkt_val;
	}
	public void setR0190_res_lessthan_1_year_mkt_val(BigDecimal r0190_res_lessthan_1_year_mkt_val) {
		this.r0190_res_lessthan_1_year_mkt_val = r0190_res_lessthan_1_year_mkt_val;
	}
	public BigDecimal getR0190_res_morethan_3_years_mkt_val() {
		return r0190_res_morethan_3_years_mkt_val;
	}
	public void setR0190_res_morethan_3_years_mkt_val(BigDecimal r0190_res_morethan_3_years_mkt_val) {
		this.r0190_res_morethan_3_years_mkt_val = r0190_res_morethan_3_years_mkt_val;
	}
	public BigDecimal getR0190_res_nat_amt() {
		return r0190_res_nat_amt;
	}
	public void setR0190_res_nat_amt(BigDecimal r0190_res_nat_amt) {
		this.r0190_res_nat_amt = r0190_res_nat_amt;
	}
	public BigDecimal getR0190_sold_hedg_net_delta_pos() {
		return r0190_sold_hedg_net_delta_pos;
	}
	public void setR0190_sold_hedg_net_delta_pos(BigDecimal r0190_sold_hedg_net_delta_pos) {
		this.r0190_sold_hedg_net_delta_pos = r0190_sold_hedg_net_delta_pos;
	}
	public BigDecimal getR0190_sold_trad_net_delta_pos() {
		return r0190_sold_trad_net_delta_pos;
	}
	public void setR0190_sold_trad_net_delta_pos(BigDecimal r0190_sold_trad_net_delta_pos) {
		this.r0190_sold_trad_net_delta_pos = r0190_sold_trad_net_delta_pos;
	}
	public BigDecimal getR0190_trad_nat_amt() {
		return r0190_trad_nat_amt;
	}
	public void setR0190_trad_nat_amt(BigDecimal r0190_trad_nat_amt) {
		this.r0190_trad_nat_amt = r0190_trad_nat_amt;
	}
	public BigDecimal getR0190_within_1_year_nat_amt() {
		return r0190_within_1_year_nat_amt;
	}
	public void setR0190_within_1_year_nat_amt(BigDecimal r0190_within_1_year_nat_amt) {
		this.r0190_within_1_year_nat_amt = r0190_within_1_year_nat_amt;
	}
	public BigDecimal getR0200_1_to_3_years_nat_amt() {
		return r0200_1_to_3_years_nat_amt;
	}
	public void setR0200_1_to_3_years_nat_amt(BigDecimal r0200_1_to_3_years_nat_amt) {
		this.r0200_1_to_3_years_nat_amt = r0200_1_to_3_years_nat_amt;
	}
	public BigDecimal getR0200_bought_hedg_net_delta_pos() {
		return r0200_bought_hedg_net_delta_pos;
	}
	public void setR0200_bought_hedg_net_delta_pos(BigDecimal r0200_bought_hedg_net_delta_pos) {
		this.r0200_bought_hedg_net_delta_pos = r0200_bought_hedg_net_delta_pos;
	}
	public BigDecimal getR0200_bought_trad_net_delta_pos() {
		return r0200_bought_trad_net_delta_pos;
	}
	public void setR0200_bought_trad_net_delta_pos(BigDecimal r0200_bought_trad_net_delta_pos) {
		this.r0200_bought_trad_net_delta_pos = r0200_bought_trad_net_delta_pos;
	}
	public BigDecimal getR0200_gross_mkt_val() {
		return r0200_gross_mkt_val;
	}
	public void setR0200_gross_mkt_val(BigDecimal r0200_gross_mkt_val) {
		this.r0200_gross_mkt_val = r0200_gross_mkt_val;
	}
	public BigDecimal getR0200_hedg_nat_amt() {
		return r0200_hedg_nat_amt;
	}
	public void setR0200_hedg_nat_amt(BigDecimal r0200_hedg_nat_amt) {
		this.r0200_hedg_nat_amt = r0200_hedg_nat_amt;
	}
	public BigDecimal getR0200_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0200_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0200_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0200_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0200_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0200_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0200_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0200_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0200_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0200_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0200_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0200_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0200_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0200_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0200_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0200_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0200_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0200_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0200_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0200_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0200_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0200_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0200_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0200_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0200_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0200_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0200_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0200_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0200_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0200_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0200_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0200_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0200_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0200_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0200_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0200_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0200_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0200_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0200_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0200_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0200_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0200_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0200_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0200_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0200_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0200_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0200_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0200_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0200_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0200_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0200_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0200_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0200_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0200_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0200_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0200_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0200_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0200_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0200_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0200_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0200_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0200_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0200_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0200_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0200_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0200_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0200_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0200_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0200_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0200_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0200_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0200_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public BigDecimal getR0200_nat_amt() {
		return r0200_nat_amt;
	}
	public void setR0200_nat_amt(BigDecimal r0200_nat_amt) {
		this.r0200_nat_amt = r0200_nat_amt;
	}
	public BigDecimal getR0200_non_res_nat_amt() {
		return r0200_non_res_nat_amt;
	}
	public void setR0200_non_res_nat_amt(BigDecimal r0200_non_res_nat_amt) {
		this.r0200_non_res_nat_amt = r0200_non_res_nat_amt;
	}
	public BigDecimal getR0200_over_3_years_nat_amt() {
		return r0200_over_3_years_nat_amt;
	}
	public void setR0200_over_3_years_nat_amt(BigDecimal r0200_over_3_years_nat_amt) {
		this.r0200_over_3_years_nat_amt = r0200_over_3_years_nat_amt;
	}
	public BigDecimal getR0200_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0200_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0200_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0200_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0200_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0200_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0200_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0200_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0200_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0200_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0200_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0200_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0200_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0200_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0200_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0200_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0200_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0200_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0200_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0200_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0200_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0200_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0200_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0200_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0200_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0200_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0200_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0200_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0200_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0200_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0200_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0200_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0200_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0200_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0200_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0200_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0200_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0200_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0200_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0200_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0200_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0200_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0200_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0200_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0200_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0200_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0200_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0200_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0200_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0200_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0200_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0200_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0200_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0200_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0200_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0200_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0200_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0200_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0200_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0200_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0200_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0200_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0200_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0200_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0200_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0200_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0200_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0200_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0200_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0200_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0200_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0200_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public String getR0200_product() {
		return r0200_product;
	}
	public void setR0200_product(String r0200_product) {
		this.r0200_product = r0200_product;
	}
	public BigDecimal getR0200_pro_bought_net_gain_loss() {
		return r0200_pro_bought_net_gain_loss;
	}
	public void setR0200_pro_bought_net_gain_loss(BigDecimal r0200_pro_bought_net_gain_loss) {
		this.r0200_pro_bought_net_gain_loss = r0200_pro_bought_net_gain_loss;
	}
	public BigDecimal getR0200_pro_sold_net_gain_loss() {
		return r0200_pro_sold_net_gain_loss;
	}
	public void setR0200_pro_sold_net_gain_loss(BigDecimal r0200_pro_sold_net_gain_loss) {
		this.r0200_pro_sold_net_gain_loss = r0200_pro_sold_net_gain_loss;
	}
	public BigDecimal getR0200_res_1_to_3_years_mkt_val() {
		return r0200_res_1_to_3_years_mkt_val;
	}
	public void setR0200_res_1_to_3_years_mkt_val(BigDecimal r0200_res_1_to_3_years_mkt_val) {
		this.r0200_res_1_to_3_years_mkt_val = r0200_res_1_to_3_years_mkt_val;
	}
	public BigDecimal getR0200_res_lessthan_1_year_mkt_val() {
		return r0200_res_lessthan_1_year_mkt_val;
	}
	public void setR0200_res_lessthan_1_year_mkt_val(BigDecimal r0200_res_lessthan_1_year_mkt_val) {
		this.r0200_res_lessthan_1_year_mkt_val = r0200_res_lessthan_1_year_mkt_val;
	}
	public BigDecimal getR0200_res_morethan_3_years_mkt_val() {
		return r0200_res_morethan_3_years_mkt_val;
	}
	public void setR0200_res_morethan_3_years_mkt_val(BigDecimal r0200_res_morethan_3_years_mkt_val) {
		this.r0200_res_morethan_3_years_mkt_val = r0200_res_morethan_3_years_mkt_val;
	}
	public BigDecimal getR0200_res_nat_amt() {
		return r0200_res_nat_amt;
	}
	public void setR0200_res_nat_amt(BigDecimal r0200_res_nat_amt) {
		this.r0200_res_nat_amt = r0200_res_nat_amt;
	}
	public BigDecimal getR0200_sold_hedg_net_delta_pos() {
		return r0200_sold_hedg_net_delta_pos;
	}
	public void setR0200_sold_hedg_net_delta_pos(BigDecimal r0200_sold_hedg_net_delta_pos) {
		this.r0200_sold_hedg_net_delta_pos = r0200_sold_hedg_net_delta_pos;
	}
	public BigDecimal getR0200_sold_trad_net_delta_pos() {
		return r0200_sold_trad_net_delta_pos;
	}
	public void setR0200_sold_trad_net_delta_pos(BigDecimal r0200_sold_trad_net_delta_pos) {
		this.r0200_sold_trad_net_delta_pos = r0200_sold_trad_net_delta_pos;
	}
	public BigDecimal getR0200_trad_nat_amt() {
		return r0200_trad_nat_amt;
	}
	public void setR0200_trad_nat_amt(BigDecimal r0200_trad_nat_amt) {
		this.r0200_trad_nat_amt = r0200_trad_nat_amt;
	}
	public BigDecimal getR0200_within_1_year_nat_amt() {
		return r0200_within_1_year_nat_amt;
	}
	public void setR0200_within_1_year_nat_amt(BigDecimal r0200_within_1_year_nat_amt) {
		this.r0200_within_1_year_nat_amt = r0200_within_1_year_nat_amt;
	}
	public BigDecimal getR0210_1_to_3_years_nat_amt() {
		return r0210_1_to_3_years_nat_amt;
	}
	public void setR0210_1_to_3_years_nat_amt(BigDecimal r0210_1_to_3_years_nat_amt) {
		this.r0210_1_to_3_years_nat_amt = r0210_1_to_3_years_nat_amt;
	}
	public BigDecimal getR0210_bought_hedg_net_delta_pos() {
		return r0210_bought_hedg_net_delta_pos;
	}
	public void setR0210_bought_hedg_net_delta_pos(BigDecimal r0210_bought_hedg_net_delta_pos) {
		this.r0210_bought_hedg_net_delta_pos = r0210_bought_hedg_net_delta_pos;
	}
	public BigDecimal getR0210_bought_trad_net_delta_pos() {
		return r0210_bought_trad_net_delta_pos;
	}
	public void setR0210_bought_trad_net_delta_pos(BigDecimal r0210_bought_trad_net_delta_pos) {
		this.r0210_bought_trad_net_delta_pos = r0210_bought_trad_net_delta_pos;
	}
	public BigDecimal getR0210_gross_mkt_val() {
		return r0210_gross_mkt_val;
	}
	public void setR0210_gross_mkt_val(BigDecimal r0210_gross_mkt_val) {
		this.r0210_gross_mkt_val = r0210_gross_mkt_val;
	}
	public BigDecimal getR0210_hedg_nat_amt() {
		return r0210_hedg_nat_amt;
	}
	public void setR0210_hedg_nat_amt(BigDecimal r0210_hedg_nat_amt) {
		this.r0210_hedg_nat_amt = r0210_hedg_nat_amt;
	}
	public BigDecimal getR0210_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0210_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0210_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0210_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0210_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0210_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0210_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0210_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0210_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0210_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0210_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0210_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0210_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0210_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0210_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0210_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0210_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0210_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0210_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0210_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0210_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0210_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0210_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0210_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0210_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0210_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0210_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0210_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0210_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0210_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0210_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0210_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0210_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0210_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0210_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0210_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0210_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0210_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0210_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0210_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0210_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0210_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0210_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0210_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0210_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0210_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0210_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0210_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0210_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0210_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0210_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0210_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0210_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0210_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0210_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0210_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0210_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0210_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0210_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0210_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0210_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0210_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0210_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0210_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0210_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0210_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0210_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0210_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0210_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0210_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0210_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0210_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public BigDecimal getR0210_nat_amt() {
		return r0210_nat_amt;
	}
	public void setR0210_nat_amt(BigDecimal r0210_nat_amt) {
		this.r0210_nat_amt = r0210_nat_amt;
	}
	public BigDecimal getR0210_non_res_nat_amt() {
		return r0210_non_res_nat_amt;
	}
	public void setR0210_non_res_nat_amt(BigDecimal r0210_non_res_nat_amt) {
		this.r0210_non_res_nat_amt = r0210_non_res_nat_amt;
	}
	public BigDecimal getR0210_over_3_years_nat_amt() {
		return r0210_over_3_years_nat_amt;
	}
	public void setR0210_over_3_years_nat_amt(BigDecimal r0210_over_3_years_nat_amt) {
		this.r0210_over_3_years_nat_amt = r0210_over_3_years_nat_amt;
	}
	public BigDecimal getR0210_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0210_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0210_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0210_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0210_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0210_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0210_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0210_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0210_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0210_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0210_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0210_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0210_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0210_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0210_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0210_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0210_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0210_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0210_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0210_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0210_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0210_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0210_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0210_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0210_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0210_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0210_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0210_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0210_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0210_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0210_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0210_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0210_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0210_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0210_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0210_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0210_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0210_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0210_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0210_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0210_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0210_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0210_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0210_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0210_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0210_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0210_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0210_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0210_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0210_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0210_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0210_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0210_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0210_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0210_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0210_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0210_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0210_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0210_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0210_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0210_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0210_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0210_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0210_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0210_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0210_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0210_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0210_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0210_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0210_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0210_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0210_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public String getR0210_product() {
		return r0210_product;
	}
	public void setR0210_product(String r0210_product) {
		this.r0210_product = r0210_product;
	}
	public BigDecimal getR0210_pro_bought_net_gain_loss() {
		return r0210_pro_bought_net_gain_loss;
	}
	public void setR0210_pro_bought_net_gain_loss(BigDecimal r0210_pro_bought_net_gain_loss) {
		this.r0210_pro_bought_net_gain_loss = r0210_pro_bought_net_gain_loss;
	}
	public BigDecimal getR0210_pro_sold_net_gain_loss() {
		return r0210_pro_sold_net_gain_loss;
	}
	public void setR0210_pro_sold_net_gain_loss(BigDecimal r0210_pro_sold_net_gain_loss) {
		this.r0210_pro_sold_net_gain_loss = r0210_pro_sold_net_gain_loss;
	}
	public BigDecimal getR0210_res_1_to_3_years_mkt_val() {
		return r0210_res_1_to_3_years_mkt_val;
	}
	public void setR0210_res_1_to_3_years_mkt_val(BigDecimal r0210_res_1_to_3_years_mkt_val) {
		this.r0210_res_1_to_3_years_mkt_val = r0210_res_1_to_3_years_mkt_val;
	}
	public BigDecimal getR0210_res_lessthan_1_year_mkt_val() {
		return r0210_res_lessthan_1_year_mkt_val;
	}
	public void setR0210_res_lessthan_1_year_mkt_val(BigDecimal r0210_res_lessthan_1_year_mkt_val) {
		this.r0210_res_lessthan_1_year_mkt_val = r0210_res_lessthan_1_year_mkt_val;
	}
	public BigDecimal getR0210_res_morethan_3_years_mkt_val() {
		return r0210_res_morethan_3_years_mkt_val;
	}
	public void setR0210_res_morethan_3_years_mkt_val(BigDecimal r0210_res_morethan_3_years_mkt_val) {
		this.r0210_res_morethan_3_years_mkt_val = r0210_res_morethan_3_years_mkt_val;
	}
	public BigDecimal getR0210_res_nat_amt() {
		return r0210_res_nat_amt;
	}
	public void setR0210_res_nat_amt(BigDecimal r0210_res_nat_amt) {
		this.r0210_res_nat_amt = r0210_res_nat_amt;
	}
	public BigDecimal getR0210_sold_hedg_net_delta_pos() {
		return r0210_sold_hedg_net_delta_pos;
	}
	public void setR0210_sold_hedg_net_delta_pos(BigDecimal r0210_sold_hedg_net_delta_pos) {
		this.r0210_sold_hedg_net_delta_pos = r0210_sold_hedg_net_delta_pos;
	}
	public BigDecimal getR0210_sold_trad_net_delta_pos() {
		return r0210_sold_trad_net_delta_pos;
	}
	public void setR0210_sold_trad_net_delta_pos(BigDecimal r0210_sold_trad_net_delta_pos) {
		this.r0210_sold_trad_net_delta_pos = r0210_sold_trad_net_delta_pos;
	}
	public BigDecimal getR0210_trad_nat_amt() {
		return r0210_trad_nat_amt;
	}
	public void setR0210_trad_nat_amt(BigDecimal r0210_trad_nat_amt) {
		this.r0210_trad_nat_amt = r0210_trad_nat_amt;
	}
	public BigDecimal getR0210_within_1_year_nat_amt() {
		return r0210_within_1_year_nat_amt;
	}
	public void setR0210_within_1_year_nat_amt(BigDecimal r0210_within_1_year_nat_amt) {
		this.r0210_within_1_year_nat_amt = r0210_within_1_year_nat_amt;
	}
	public BigDecimal getR0220_1_to_3_years_nat_amt() {
		return r0220_1_to_3_years_nat_amt;
	}
	public void setR0220_1_to_3_years_nat_amt(BigDecimal r0220_1_to_3_years_nat_amt) {
		this.r0220_1_to_3_years_nat_amt = r0220_1_to_3_years_nat_amt;
	}
	public BigDecimal getR0220_bought_hedg_net_delta_pos() {
		return r0220_bought_hedg_net_delta_pos;
	}
	public void setR0220_bought_hedg_net_delta_pos(BigDecimal r0220_bought_hedg_net_delta_pos) {
		this.r0220_bought_hedg_net_delta_pos = r0220_bought_hedg_net_delta_pos;
	}
	public BigDecimal getR0220_bought_trad_net_delta_pos() {
		return r0220_bought_trad_net_delta_pos;
	}
	public void setR0220_bought_trad_net_delta_pos(BigDecimal r0220_bought_trad_net_delta_pos) {
		this.r0220_bought_trad_net_delta_pos = r0220_bought_trad_net_delta_pos;
	}
	public BigDecimal getR0220_gross_mkt_val() {
		return r0220_gross_mkt_val;
	}
	public void setR0220_gross_mkt_val(BigDecimal r0220_gross_mkt_val) {
		this.r0220_gross_mkt_val = r0220_gross_mkt_val;
	}
	public BigDecimal getR0220_hedg_nat_amt() {
		return r0220_hedg_nat_amt;
	}
	public void setR0220_hedg_nat_amt(BigDecimal r0220_hedg_nat_amt) {
		this.r0220_hedg_nat_amt = r0220_hedg_nat_amt;
	}
	public BigDecimal getR0220_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0220_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0220_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0220_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0220_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0220_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0220_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0220_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0220_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0220_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0220_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0220_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0220_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0220_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0220_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0220_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0220_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0220_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0220_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0220_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0220_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0220_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0220_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0220_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0220_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0220_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0220_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0220_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0220_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0220_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0220_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0220_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0220_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0220_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0220_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0220_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0220_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0220_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0220_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0220_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0220_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0220_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0220_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0220_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0220_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0220_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0220_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0220_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0220_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0220_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0220_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0220_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0220_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0220_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0220_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0220_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0220_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0220_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0220_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0220_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0220_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0220_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0220_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0220_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0220_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0220_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0220_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0220_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0220_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0220_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0220_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0220_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public BigDecimal getR0220_nat_amt() {
		return r0220_nat_amt;
	}
	public void setR0220_nat_amt(BigDecimal r0220_nat_amt) {
		this.r0220_nat_amt = r0220_nat_amt;
	}
	public BigDecimal getR0220_non_res_nat_amt() {
		return r0220_non_res_nat_amt;
	}
	public void setR0220_non_res_nat_amt(BigDecimal r0220_non_res_nat_amt) {
		this.r0220_non_res_nat_amt = r0220_non_res_nat_amt;
	}
	public BigDecimal getR0220_over_3_years_nat_amt() {
		return r0220_over_3_years_nat_amt;
	}
	public void setR0220_over_3_years_nat_amt(BigDecimal r0220_over_3_years_nat_amt) {
		this.r0220_over_3_years_nat_amt = r0220_over_3_years_nat_amt;
	}
	public BigDecimal getR0220_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0220_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0220_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0220_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0220_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0220_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0220_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0220_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0220_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0220_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0220_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0220_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0220_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0220_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0220_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0220_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0220_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0220_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0220_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0220_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0220_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0220_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0220_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0220_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0220_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0220_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0220_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0220_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0220_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0220_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0220_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0220_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0220_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0220_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0220_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0220_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0220_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0220_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0220_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0220_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0220_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0220_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0220_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0220_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0220_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0220_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0220_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0220_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0220_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0220_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0220_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0220_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0220_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0220_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0220_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0220_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0220_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0220_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0220_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0220_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0220_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0220_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0220_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0220_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0220_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0220_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0220_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0220_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0220_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0220_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0220_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0220_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public String getR0220_product() {
		return r0220_product;
	}
	public void setR0220_product(String r0220_product) {
		this.r0220_product = r0220_product;
	}
	public BigDecimal getR0220_pro_bought_net_gain_loss() {
		return r0220_pro_bought_net_gain_loss;
	}
	public void setR0220_pro_bought_net_gain_loss(BigDecimal r0220_pro_bought_net_gain_loss) {
		this.r0220_pro_bought_net_gain_loss = r0220_pro_bought_net_gain_loss;
	}
	public BigDecimal getR0220_pro_sold_net_gain_loss() {
		return r0220_pro_sold_net_gain_loss;
	}
	public void setR0220_pro_sold_net_gain_loss(BigDecimal r0220_pro_sold_net_gain_loss) {
		this.r0220_pro_sold_net_gain_loss = r0220_pro_sold_net_gain_loss;
	}
	public BigDecimal getR0220_res_1_to_3_years_mkt_val() {
		return r0220_res_1_to_3_years_mkt_val;
	}
	public void setR0220_res_1_to_3_years_mkt_val(BigDecimal r0220_res_1_to_3_years_mkt_val) {
		this.r0220_res_1_to_3_years_mkt_val = r0220_res_1_to_3_years_mkt_val;
	}
	public BigDecimal getR0220_res_lessthan_1_year_mkt_val() {
		return r0220_res_lessthan_1_year_mkt_val;
	}
	public void setR0220_res_lessthan_1_year_mkt_val(BigDecimal r0220_res_lessthan_1_year_mkt_val) {
		this.r0220_res_lessthan_1_year_mkt_val = r0220_res_lessthan_1_year_mkt_val;
	}
	public BigDecimal getR0220_res_morethan_3_years_mkt_val() {
		return r0220_res_morethan_3_years_mkt_val;
	}
	public void setR0220_res_morethan_3_years_mkt_val(BigDecimal r0220_res_morethan_3_years_mkt_val) {
		this.r0220_res_morethan_3_years_mkt_val = r0220_res_morethan_3_years_mkt_val;
	}
	public BigDecimal getR0220_res_nat_amt() {
		return r0220_res_nat_amt;
	}
	public void setR0220_res_nat_amt(BigDecimal r0220_res_nat_amt) {
		this.r0220_res_nat_amt = r0220_res_nat_amt;
	}
	public BigDecimal getR0220_sold_hedg_net_delta_pos() {
		return r0220_sold_hedg_net_delta_pos;
	}
	public void setR0220_sold_hedg_net_delta_pos(BigDecimal r0220_sold_hedg_net_delta_pos) {
		this.r0220_sold_hedg_net_delta_pos = r0220_sold_hedg_net_delta_pos;
	}
	public BigDecimal getR0220_sold_trad_net_delta_pos() {
		return r0220_sold_trad_net_delta_pos;
	}
	public void setR0220_sold_trad_net_delta_pos(BigDecimal r0220_sold_trad_net_delta_pos) {
		this.r0220_sold_trad_net_delta_pos = r0220_sold_trad_net_delta_pos;
	}
	public BigDecimal getR0220_trad_nat_amt() {
		return r0220_trad_nat_amt;
	}
	public void setR0220_trad_nat_amt(BigDecimal r0220_trad_nat_amt) {
		this.r0220_trad_nat_amt = r0220_trad_nat_amt;
	}
	public BigDecimal getR0220_within_1_year_nat_amt() {
		return r0220_within_1_year_nat_amt;
	}
	public void setR0220_within_1_year_nat_amt(BigDecimal r0220_within_1_year_nat_amt) {
		this.r0220_within_1_year_nat_amt = r0220_within_1_year_nat_amt;
	}
	public BigDecimal getR0230_1_to_3_years_nat_amt() {
		return r0230_1_to_3_years_nat_amt;
	}
	public void setR0230_1_to_3_years_nat_amt(BigDecimal r0230_1_to_3_years_nat_amt) {
		this.r0230_1_to_3_years_nat_amt = r0230_1_to_3_years_nat_amt;
	}
	public BigDecimal getR0230_bought_hedg_net_delta_pos() {
		return r0230_bought_hedg_net_delta_pos;
	}
	public void setR0230_bought_hedg_net_delta_pos(BigDecimal r0230_bought_hedg_net_delta_pos) {
		this.r0230_bought_hedg_net_delta_pos = r0230_bought_hedg_net_delta_pos;
	}
	public BigDecimal getR0230_bought_trad_net_delta_pos() {
		return r0230_bought_trad_net_delta_pos;
	}
	public void setR0230_bought_trad_net_delta_pos(BigDecimal r0230_bought_trad_net_delta_pos) {
		this.r0230_bought_trad_net_delta_pos = r0230_bought_trad_net_delta_pos;
	}
	public BigDecimal getR0230_gross_mkt_val() {
		return r0230_gross_mkt_val;
	}
	public void setR0230_gross_mkt_val(BigDecimal r0230_gross_mkt_val) {
		this.r0230_gross_mkt_val = r0230_gross_mkt_val;
	}
	public BigDecimal getR0230_hedg_nat_amt() {
		return r0230_hedg_nat_amt;
	}
	public void setR0230_hedg_nat_amt(BigDecimal r0230_hedg_nat_amt) {
		this.r0230_hedg_nat_amt = r0230_hedg_nat_amt;
	}
	public BigDecimal getR0230_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0230_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0230_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0230_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0230_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0230_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0230_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0230_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0230_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0230_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0230_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0230_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0230_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0230_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0230_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0230_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0230_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0230_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0230_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0230_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0230_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0230_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0230_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0230_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0230_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0230_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0230_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0230_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0230_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0230_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0230_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0230_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0230_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0230_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0230_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0230_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0230_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0230_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0230_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0230_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0230_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0230_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0230_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0230_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0230_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0230_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0230_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0230_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0230_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0230_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0230_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0230_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0230_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0230_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0230_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0230_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0230_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0230_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0230_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0230_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0230_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0230_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0230_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0230_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0230_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0230_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0230_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0230_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0230_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0230_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0230_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0230_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public BigDecimal getR0230_nat_amt() {
		return r0230_nat_amt;
	}
	public void setR0230_nat_amt(BigDecimal r0230_nat_amt) {
		this.r0230_nat_amt = r0230_nat_amt;
	}
	public BigDecimal getR0230_non_res_nat_amt() {
		return r0230_non_res_nat_amt;
	}
	public void setR0230_non_res_nat_amt(BigDecimal r0230_non_res_nat_amt) {
		this.r0230_non_res_nat_amt = r0230_non_res_nat_amt;
	}
	public BigDecimal getR0230_over_3_years_nat_amt() {
		return r0230_over_3_years_nat_amt;
	}
	public void setR0230_over_3_years_nat_amt(BigDecimal r0230_over_3_years_nat_amt) {
		this.r0230_over_3_years_nat_amt = r0230_over_3_years_nat_amt;
	}
	public BigDecimal getR0230_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0230_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0230_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0230_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0230_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0230_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0230_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0230_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0230_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0230_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0230_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0230_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0230_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0230_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0230_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0230_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0230_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0230_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0230_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0230_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0230_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0230_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0230_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0230_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0230_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0230_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0230_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0230_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0230_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0230_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0230_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0230_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0230_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0230_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0230_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0230_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0230_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0230_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0230_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0230_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0230_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0230_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0230_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0230_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0230_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0230_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0230_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0230_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0230_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0230_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0230_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0230_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0230_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0230_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0230_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0230_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0230_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0230_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0230_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0230_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0230_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0230_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0230_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0230_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0230_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0230_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0230_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0230_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0230_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0230_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0230_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0230_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public String getR0230_product() {
		return r0230_product;
	}
	public void setR0230_product(String r0230_product) {
		this.r0230_product = r0230_product;
	}
	public BigDecimal getR0230_pro_bought_net_gain_loss() {
		return r0230_pro_bought_net_gain_loss;
	}
	public void setR0230_pro_bought_net_gain_loss(BigDecimal r0230_pro_bought_net_gain_loss) {
		this.r0230_pro_bought_net_gain_loss = r0230_pro_bought_net_gain_loss;
	}
	public BigDecimal getR0230_pro_sold_net_gain_loss() {
		return r0230_pro_sold_net_gain_loss;
	}
	public void setR0230_pro_sold_net_gain_loss(BigDecimal r0230_pro_sold_net_gain_loss) {
		this.r0230_pro_sold_net_gain_loss = r0230_pro_sold_net_gain_loss;
	}
	public BigDecimal getR0230_res_1_to_3_years_mkt_val() {
		return r0230_res_1_to_3_years_mkt_val;
	}
	public void setR0230_res_1_to_3_years_mkt_val(BigDecimal r0230_res_1_to_3_years_mkt_val) {
		this.r0230_res_1_to_3_years_mkt_val = r0230_res_1_to_3_years_mkt_val;
	}
	public BigDecimal getR0230_res_lessthan_1_year_mkt_val() {
		return r0230_res_lessthan_1_year_mkt_val;
	}
	public void setR0230_res_lessthan_1_year_mkt_val(BigDecimal r0230_res_lessthan_1_year_mkt_val) {
		this.r0230_res_lessthan_1_year_mkt_val = r0230_res_lessthan_1_year_mkt_val;
	}
	public BigDecimal getR0230_res_morethan_3_years_mkt_val() {
		return r0230_res_morethan_3_years_mkt_val;
	}
	public void setR0230_res_morethan_3_years_mkt_val(BigDecimal r0230_res_morethan_3_years_mkt_val) {
		this.r0230_res_morethan_3_years_mkt_val = r0230_res_morethan_3_years_mkt_val;
	}
	public BigDecimal getR0230_res_nat_amt() {
		return r0230_res_nat_amt;
	}
	public void setR0230_res_nat_amt(BigDecimal r0230_res_nat_amt) {
		this.r0230_res_nat_amt = r0230_res_nat_amt;
	}
	public BigDecimal getR0230_sold_hedg_net_delta_pos() {
		return r0230_sold_hedg_net_delta_pos;
	}
	public void setR0230_sold_hedg_net_delta_pos(BigDecimal r0230_sold_hedg_net_delta_pos) {
		this.r0230_sold_hedg_net_delta_pos = r0230_sold_hedg_net_delta_pos;
	}
	public BigDecimal getR0230_sold_trad_net_delta_pos() {
		return r0230_sold_trad_net_delta_pos;
	}
	public void setR0230_sold_trad_net_delta_pos(BigDecimal r0230_sold_trad_net_delta_pos) {
		this.r0230_sold_trad_net_delta_pos = r0230_sold_trad_net_delta_pos;
	}
	public BigDecimal getR0230_trad_nat_amt() {
		return r0230_trad_nat_amt;
	}
	public void setR0230_trad_nat_amt(BigDecimal r0230_trad_nat_amt) {
		this.r0230_trad_nat_amt = r0230_trad_nat_amt;
	}
	public BigDecimal getR0230_within_1_year_nat_amt() {
		return r0230_within_1_year_nat_amt;
	}
	public void setR0230_within_1_year_nat_amt(BigDecimal r0230_within_1_year_nat_amt) {
		this.r0230_within_1_year_nat_amt = r0230_within_1_year_nat_amt;
	}
	public BigDecimal getR0240_1_to_3_years_nat_amt() {
		return r0240_1_to_3_years_nat_amt;
	}
	public void setR0240_1_to_3_years_nat_amt(BigDecimal r0240_1_to_3_years_nat_amt) {
		this.r0240_1_to_3_years_nat_amt = r0240_1_to_3_years_nat_amt;
	}
	public BigDecimal getR0240_bought_hedg_net_delta_pos() {
		return r0240_bought_hedg_net_delta_pos;
	}
	public void setR0240_bought_hedg_net_delta_pos(BigDecimal r0240_bought_hedg_net_delta_pos) {
		this.r0240_bought_hedg_net_delta_pos = r0240_bought_hedg_net_delta_pos;
	}
	public BigDecimal getR0240_bought_trad_net_delta_pos() {
		return r0240_bought_trad_net_delta_pos;
	}
	public void setR0240_bought_trad_net_delta_pos(BigDecimal r0240_bought_trad_net_delta_pos) {
		this.r0240_bought_trad_net_delta_pos = r0240_bought_trad_net_delta_pos;
	}
	public BigDecimal getR0240_gross_mkt_val() {
		return r0240_gross_mkt_val;
	}
	public void setR0240_gross_mkt_val(BigDecimal r0240_gross_mkt_val) {
		this.r0240_gross_mkt_val = r0240_gross_mkt_val;
	}
	public BigDecimal getR0240_hedg_nat_amt() {
		return r0240_hedg_nat_amt;
	}
	public void setR0240_hedg_nat_amt(BigDecimal r0240_hedg_nat_amt) {
		this.r0240_hedg_nat_amt = r0240_hedg_nat_amt;
	}
	public BigDecimal getR0240_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0240_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0240_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0240_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0240_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0240_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0240_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0240_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0240_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0240_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0240_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0240_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0240_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0240_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0240_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0240_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0240_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0240_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0240_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0240_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0240_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0240_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0240_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0240_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0240_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0240_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0240_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0240_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0240_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0240_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0240_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0240_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0240_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0240_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0240_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0240_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0240_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0240_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0240_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0240_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0240_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0240_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0240_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0240_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0240_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0240_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0240_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0240_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0240_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0240_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0240_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0240_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0240_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0240_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0240_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0240_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0240_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0240_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0240_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0240_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0240_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0240_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0240_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0240_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0240_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0240_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0240_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0240_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0240_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0240_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0240_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0240_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public BigDecimal getR0240_nat_amt() {
		return r0240_nat_amt;
	}
	public void setR0240_nat_amt(BigDecimal r0240_nat_amt) {
		this.r0240_nat_amt = r0240_nat_amt;
	}
	public BigDecimal getR0240_non_res_nat_amt() {
		return r0240_non_res_nat_amt;
	}
	public void setR0240_non_res_nat_amt(BigDecimal r0240_non_res_nat_amt) {
		this.r0240_non_res_nat_amt = r0240_non_res_nat_amt;
	}
	public BigDecimal getR0240_over_3_years_nat_amt() {
		return r0240_over_3_years_nat_amt;
	}
	public void setR0240_over_3_years_nat_amt(BigDecimal r0240_over_3_years_nat_amt) {
		this.r0240_over_3_years_nat_amt = r0240_over_3_years_nat_amt;
	}
	public BigDecimal getR0240_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0240_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0240_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0240_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0240_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0240_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0240_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0240_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0240_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0240_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0240_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0240_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0240_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0240_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0240_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0240_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0240_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0240_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0240_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0240_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0240_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0240_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0240_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0240_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0240_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0240_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0240_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0240_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0240_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0240_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0240_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0240_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0240_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0240_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0240_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0240_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0240_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0240_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0240_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0240_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0240_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0240_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0240_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0240_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0240_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0240_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0240_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0240_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0240_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0240_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0240_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0240_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0240_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0240_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0240_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0240_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0240_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0240_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0240_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0240_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0240_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0240_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0240_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0240_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0240_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0240_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0240_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0240_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0240_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0240_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0240_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0240_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public String getR0240_product() {
		return r0240_product;
	}
	public void setR0240_product(String r0240_product) {
		this.r0240_product = r0240_product;
	}
	public BigDecimal getR0240_pro_bought_net_gain_loss() {
		return r0240_pro_bought_net_gain_loss;
	}
	public void setR0240_pro_bought_net_gain_loss(BigDecimal r0240_pro_bought_net_gain_loss) {
		this.r0240_pro_bought_net_gain_loss = r0240_pro_bought_net_gain_loss;
	}
	public BigDecimal getR0240_pro_sold_net_gain_loss() {
		return r0240_pro_sold_net_gain_loss;
	}
	public void setR0240_pro_sold_net_gain_loss(BigDecimal r0240_pro_sold_net_gain_loss) {
		this.r0240_pro_sold_net_gain_loss = r0240_pro_sold_net_gain_loss;
	}
	public BigDecimal getR0240_res_1_to_3_years_mkt_val() {
		return r0240_res_1_to_3_years_mkt_val;
	}
	public void setR0240_res_1_to_3_years_mkt_val(BigDecimal r0240_res_1_to_3_years_mkt_val) {
		this.r0240_res_1_to_3_years_mkt_val = r0240_res_1_to_3_years_mkt_val;
	}
	public BigDecimal getR0240_res_lessthan_1_year_mkt_val() {
		return r0240_res_lessthan_1_year_mkt_val;
	}
	public void setR0240_res_lessthan_1_year_mkt_val(BigDecimal r0240_res_lessthan_1_year_mkt_val) {
		this.r0240_res_lessthan_1_year_mkt_val = r0240_res_lessthan_1_year_mkt_val;
	}
	public BigDecimal getR0240_res_morethan_3_years_mkt_val() {
		return r0240_res_morethan_3_years_mkt_val;
	}
	public void setR0240_res_morethan_3_years_mkt_val(BigDecimal r0240_res_morethan_3_years_mkt_val) {
		this.r0240_res_morethan_3_years_mkt_val = r0240_res_morethan_3_years_mkt_val;
	}
	public BigDecimal getR0240_res_nat_amt() {
		return r0240_res_nat_amt;
	}
	public void setR0240_res_nat_amt(BigDecimal r0240_res_nat_amt) {
		this.r0240_res_nat_amt = r0240_res_nat_amt;
	}
	public BigDecimal getR0240_sold_hedg_net_delta_pos() {
		return r0240_sold_hedg_net_delta_pos;
	}
	public void setR0240_sold_hedg_net_delta_pos(BigDecimal r0240_sold_hedg_net_delta_pos) {
		this.r0240_sold_hedg_net_delta_pos = r0240_sold_hedg_net_delta_pos;
	}
	public BigDecimal getR0240_sold_trad_net_delta_pos() {
		return r0240_sold_trad_net_delta_pos;
	}
	public void setR0240_sold_trad_net_delta_pos(BigDecimal r0240_sold_trad_net_delta_pos) {
		this.r0240_sold_trad_net_delta_pos = r0240_sold_trad_net_delta_pos;
	}
	public BigDecimal getR0240_trad_nat_amt() {
		return r0240_trad_nat_amt;
	}
	public void setR0240_trad_nat_amt(BigDecimal r0240_trad_nat_amt) {
		this.r0240_trad_nat_amt = r0240_trad_nat_amt;
	}
	public BigDecimal getR0240_within_1_year_nat_amt() {
		return r0240_within_1_year_nat_amt;
	}
	public void setR0240_within_1_year_nat_amt(BigDecimal r0240_within_1_year_nat_amt) {
		this.r0240_within_1_year_nat_amt = r0240_within_1_year_nat_amt;
	}
	public BigDecimal getR0250_1_to_3_years_nat_amt() {
		return r0250_1_to_3_years_nat_amt;
	}
	public void setR0250_1_to_3_years_nat_amt(BigDecimal r0250_1_to_3_years_nat_amt) {
		this.r0250_1_to_3_years_nat_amt = r0250_1_to_3_years_nat_amt;
	}
	public BigDecimal getR0250_bought_hedg_net_delta_pos() {
		return r0250_bought_hedg_net_delta_pos;
	}
	public void setR0250_bought_hedg_net_delta_pos(BigDecimal r0250_bought_hedg_net_delta_pos) {
		this.r0250_bought_hedg_net_delta_pos = r0250_bought_hedg_net_delta_pos;
	}
	public BigDecimal getR0250_bought_trad_net_delta_pos() {
		return r0250_bought_trad_net_delta_pos;
	}
	public void setR0250_bought_trad_net_delta_pos(BigDecimal r0250_bought_trad_net_delta_pos) {
		this.r0250_bought_trad_net_delta_pos = r0250_bought_trad_net_delta_pos;
	}
	public BigDecimal getR0250_gross_mkt_val() {
		return r0250_gross_mkt_val;
	}
	public void setR0250_gross_mkt_val(BigDecimal r0250_gross_mkt_val) {
		this.r0250_gross_mkt_val = r0250_gross_mkt_val;
	}
	public BigDecimal getR0250_hedg_nat_amt() {
		return r0250_hedg_nat_amt;
	}
	public void setR0250_hedg_nat_amt(BigDecimal r0250_hedg_nat_amt) {
		this.r0250_hedg_nat_amt = r0250_hedg_nat_amt;
	}
	public BigDecimal getR0250_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0250_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0250_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0250_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0250_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0250_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0250_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0250_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0250_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0250_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0250_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0250_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0250_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0250_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0250_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0250_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0250_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0250_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0250_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0250_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0250_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0250_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0250_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0250_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0250_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0250_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0250_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0250_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0250_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0250_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0250_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0250_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0250_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0250_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0250_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0250_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0250_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0250_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0250_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0250_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0250_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0250_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0250_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0250_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0250_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0250_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0250_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0250_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0250_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0250_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0250_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0250_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0250_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0250_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0250_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0250_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0250_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0250_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0250_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0250_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0250_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0250_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0250_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0250_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0250_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0250_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0250_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0250_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0250_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0250_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0250_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0250_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public BigDecimal getR0250_nat_amt() {
		return r0250_nat_amt;
	}
	public void setR0250_nat_amt(BigDecimal r0250_nat_amt) {
		this.r0250_nat_amt = r0250_nat_amt;
	}
	public BigDecimal getR0250_non_res_nat_amt() {
		return r0250_non_res_nat_amt;
	}
	public void setR0250_non_res_nat_amt(BigDecimal r0250_non_res_nat_amt) {
		this.r0250_non_res_nat_amt = r0250_non_res_nat_amt;
	}
	public BigDecimal getR0250_over_3_years_nat_amt() {
		return r0250_over_3_years_nat_amt;
	}
	public void setR0250_over_3_years_nat_amt(BigDecimal r0250_over_3_years_nat_amt) {
		this.r0250_over_3_years_nat_amt = r0250_over_3_years_nat_amt;
	}
	public BigDecimal getR0250_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0250_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0250_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0250_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0250_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0250_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0250_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0250_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0250_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0250_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0250_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0250_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0250_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0250_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0250_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0250_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0250_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0250_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0250_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0250_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0250_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0250_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0250_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0250_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0250_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0250_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0250_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0250_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0250_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0250_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0250_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0250_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0250_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0250_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0250_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0250_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0250_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0250_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0250_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0250_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0250_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0250_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0250_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0250_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0250_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0250_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0250_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0250_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0250_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0250_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0250_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0250_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0250_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0250_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0250_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0250_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0250_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0250_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0250_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0250_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0250_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0250_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0250_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0250_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0250_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0250_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0250_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0250_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0250_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0250_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0250_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0250_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public String getR0250_product() {
		return r0250_product;
	}
	public void setR0250_product(String r0250_product) {
		this.r0250_product = r0250_product;
	}
	public BigDecimal getR0250_pro_bought_net_gain_loss() {
		return r0250_pro_bought_net_gain_loss;
	}
	public void setR0250_pro_bought_net_gain_loss(BigDecimal r0250_pro_bought_net_gain_loss) {
		this.r0250_pro_bought_net_gain_loss = r0250_pro_bought_net_gain_loss;
	}
	public BigDecimal getR0250_pro_sold_net_gain_loss() {
		return r0250_pro_sold_net_gain_loss;
	}
	public void setR0250_pro_sold_net_gain_loss(BigDecimal r0250_pro_sold_net_gain_loss) {
		this.r0250_pro_sold_net_gain_loss = r0250_pro_sold_net_gain_loss;
	}
	public BigDecimal getR0250_res_1_to_3_years_mkt_val() {
		return r0250_res_1_to_3_years_mkt_val;
	}
	public void setR0250_res_1_to_3_years_mkt_val(BigDecimal r0250_res_1_to_3_years_mkt_val) {
		this.r0250_res_1_to_3_years_mkt_val = r0250_res_1_to_3_years_mkt_val;
	}
	public BigDecimal getR0250_res_lessthan_1_year_mkt_val() {
		return r0250_res_lessthan_1_year_mkt_val;
	}
	public void setR0250_res_lessthan_1_year_mkt_val(BigDecimal r0250_res_lessthan_1_year_mkt_val) {
		this.r0250_res_lessthan_1_year_mkt_val = r0250_res_lessthan_1_year_mkt_val;
	}
	public BigDecimal getR0250_res_morethan_3_years_mkt_val() {
		return r0250_res_morethan_3_years_mkt_val;
	}
	public void setR0250_res_morethan_3_years_mkt_val(BigDecimal r0250_res_morethan_3_years_mkt_val) {
		this.r0250_res_morethan_3_years_mkt_val = r0250_res_morethan_3_years_mkt_val;
	}
	public BigDecimal getR0250_res_nat_amt() {
		return r0250_res_nat_amt;
	}
	public void setR0250_res_nat_amt(BigDecimal r0250_res_nat_amt) {
		this.r0250_res_nat_amt = r0250_res_nat_amt;
	}
	public BigDecimal getR0250_sold_hedg_net_delta_pos() {
		return r0250_sold_hedg_net_delta_pos;
	}
	public void setR0250_sold_hedg_net_delta_pos(BigDecimal r0250_sold_hedg_net_delta_pos) {
		this.r0250_sold_hedg_net_delta_pos = r0250_sold_hedg_net_delta_pos;
	}
	public BigDecimal getR0250_sold_trad_net_delta_pos() {
		return r0250_sold_trad_net_delta_pos;
	}
	public void setR0250_sold_trad_net_delta_pos(BigDecimal r0250_sold_trad_net_delta_pos) {
		this.r0250_sold_trad_net_delta_pos = r0250_sold_trad_net_delta_pos;
	}
	public BigDecimal getR0250_trad_nat_amt() {
		return r0250_trad_nat_amt;
	}
	public void setR0250_trad_nat_amt(BigDecimal r0250_trad_nat_amt) {
		this.r0250_trad_nat_amt = r0250_trad_nat_amt;
	}
	public BigDecimal getR0250_within_1_year_nat_amt() {
		return r0250_within_1_year_nat_amt;
	}
	public void setR0250_within_1_year_nat_amt(BigDecimal r0250_within_1_year_nat_amt) {
		this.r0250_within_1_year_nat_amt = r0250_within_1_year_nat_amt;
	}
	public BigDecimal getR0260_1_to_3_years_nat_amt() {
		return r0260_1_to_3_years_nat_amt;
	}
	public void setR0260_1_to_3_years_nat_amt(BigDecimal r0260_1_to_3_years_nat_amt) {
		this.r0260_1_to_3_years_nat_amt = r0260_1_to_3_years_nat_amt;
	}
	public BigDecimal getR0260_bought_hedg_net_delta_pos() {
		return r0260_bought_hedg_net_delta_pos;
	}
	public void setR0260_bought_hedg_net_delta_pos(BigDecimal r0260_bought_hedg_net_delta_pos) {
		this.r0260_bought_hedg_net_delta_pos = r0260_bought_hedg_net_delta_pos;
	}
	public BigDecimal getR0260_bought_trad_net_delta_pos() {
		return r0260_bought_trad_net_delta_pos;
	}
	public void setR0260_bought_trad_net_delta_pos(BigDecimal r0260_bought_trad_net_delta_pos) {
		this.r0260_bought_trad_net_delta_pos = r0260_bought_trad_net_delta_pos;
	}
	public BigDecimal getR0260_gross_mkt_val() {
		return r0260_gross_mkt_val;
	}
	public void setR0260_gross_mkt_val(BigDecimal r0260_gross_mkt_val) {
		this.r0260_gross_mkt_val = r0260_gross_mkt_val;
	}
	public BigDecimal getR0260_hedg_nat_amt() {
		return r0260_hedg_nat_amt;
	}
	public void setR0260_hedg_nat_amt(BigDecimal r0260_hedg_nat_amt) {
		this.r0260_hedg_nat_amt = r0260_hedg_nat_amt;
	}
	public BigDecimal getR0260_minusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0260_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0260_minusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0260_minusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0260_minusten_1_to_3_years_hedg_net_loss_gain_underlying = r0260_minusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0260_minusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0260_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0260_minusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0260_minusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0260_minusten_1_to_3_years_trad_net_loss_gain_underlying = r0260_minusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0260_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0260_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0260_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0260_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0260_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0260_minusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0260_minusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0260_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0260_minusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0260_minusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0260_minusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0260_minusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0260_minusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0260_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0260_minusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0260_minusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0260_minusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0260_minusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0260_minusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0260_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0260_minusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0260_minusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0260_minusten_lessthan_1_year_trad_net_loss_gain_underlying = r0260_minusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0260_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0260_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0260_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0260_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0260_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0260_minus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0260_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0260_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0260_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0260_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0260_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0260_minus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0260_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0260_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0260_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0260_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0260_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0260_minus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0260_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0260_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0260_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0260_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0260_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0260_minus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0260_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0260_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0260_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0260_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0260_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0260_minus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0260_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0260_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0260_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0260_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0260_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0260_minus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public BigDecimal getR0260_nat_amt() {
		return r0260_nat_amt;
	}
	public void setR0260_nat_amt(BigDecimal r0260_nat_amt) {
		this.r0260_nat_amt = r0260_nat_amt;
	}
	public BigDecimal getR0260_non_res_nat_amt() {
		return r0260_non_res_nat_amt;
	}
	public void setR0260_non_res_nat_amt(BigDecimal r0260_non_res_nat_amt) {
		this.r0260_non_res_nat_amt = r0260_non_res_nat_amt;
	}
	public BigDecimal getR0260_over_3_years_nat_amt() {
		return r0260_over_3_years_nat_amt;
	}
	public void setR0260_over_3_years_nat_amt(BigDecimal r0260_over_3_years_nat_amt) {
		this.r0260_over_3_years_nat_amt = r0260_over_3_years_nat_amt;
	}
	public BigDecimal getR0260_plusten_1_to_3_years_hedg_net_loss_gain_underlying() {
		return r0260_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0260_plusten_1_to_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0260_plusten_1_to_3_years_hedg_net_loss_gain_underlying) {
		this.r0260_plusten_1_to_3_years_hedg_net_loss_gain_underlying = r0260_plusten_1_to_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0260_plusten_1_to_3_years_trad_net_loss_gain_underlying() {
		return r0260_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0260_plusten_1_to_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0260_plusten_1_to_3_years_trad_net_loss_gain_underlying) {
		this.r0260_plusten_1_to_3_years_trad_net_loss_gain_underlying = r0260_plusten_1_to_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0260_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying() {
		return r0260_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public void setR0260_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying(
			BigDecimal r0260_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying) {
		this.r0260_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying = r0260_plusten_greaterthan_3_years_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0260_plusten_greaterthan_3_years_trad_net_loss_gain_underlying() {
		return r0260_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public void setR0260_plusten_greaterthan_3_years_trad_net_loss_gain_underlying(
			BigDecimal r0260_plusten_greaterthan_3_years_trad_net_loss_gain_underlying) {
		this.r0260_plusten_greaterthan_3_years_trad_net_loss_gain_underlying = r0260_plusten_greaterthan_3_years_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0260_plusten_lessthan_1_year_hedg_net_loss_gain_underlying() {
		return r0260_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public void setR0260_plusten_lessthan_1_year_hedg_net_loss_gain_underlying(
			BigDecimal r0260_plusten_lessthan_1_year_hedg_net_loss_gain_underlying) {
		this.r0260_plusten_lessthan_1_year_hedg_net_loss_gain_underlying = r0260_plusten_lessthan_1_year_hedg_net_loss_gain_underlying;
	}
	public BigDecimal getR0260_plusten_lessthan_1_year_trad_net_loss_gain_underlying() {
		return r0260_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public void setR0260_plusten_lessthan_1_year_trad_net_loss_gain_underlying(
			BigDecimal r0260_plusten_lessthan_1_year_trad_net_loss_gain_underlying) {
		this.r0260_plusten_lessthan_1_year_trad_net_loss_gain_underlying = r0260_plusten_lessthan_1_year_trad_net_loss_gain_underlying;
	}
	public BigDecimal getR0260_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift() {
		return r0260_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public void setR0260_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift(
			BigDecimal r0260_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift) {
		this.r0260_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift = r0260_plus_2bp_1_to_3_years_hedg_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0260_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift() {
		return r0260_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public void setR0260_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift(
			BigDecimal r0260_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift) {
		this.r0260_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift = r0260_plus_2bp_1_to_3_years_trad_net_loss_gain_parallelshift;
	}
	public BigDecimal getR0260_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift() {
		return r0260_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public void setR0260_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift(
			BigDecimal r0260_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift) {
		this.r0260_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift = r0260_plus_2bp_greaterthan_3_years_hedg_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0260_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift() {
		return r0260_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public void setR0260_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift(
			BigDecimal r0260_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift) {
		this.r0260_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift = r0260_plus_2bp_greaterthan_3_years_trad_net_loss_gain_parallel_shift;
	}
	public BigDecimal getR0260_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift() {
		return r0260_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public void setR0260_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift(
			BigDecimal r0260_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift) {
		this.r0260_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift = r0260_plus_2bp_lessthan_1_year_hedg_net_loss_parallelshift;
	}
	public BigDecimal getR0260_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift() {
		return r0260_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public void setR0260_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift(
			BigDecimal r0260_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift) {
		this.r0260_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift = r0260_plus_2bp_lessthan_1_year_trad_net_loss_parallelshift;
	}
	public String getR0260_product() {
		return r0260_product;
	}
	public void setR0260_product(String r0260_product) {
		this.r0260_product = r0260_product;
	}
	public BigDecimal getR0260_pro_bought_net_gain_loss() {
		return r0260_pro_bought_net_gain_loss;
	}
	public void setR0260_pro_bought_net_gain_loss(BigDecimal r0260_pro_bought_net_gain_loss) {
		this.r0260_pro_bought_net_gain_loss = r0260_pro_bought_net_gain_loss;
	}
	public BigDecimal getR0260_pro_sold_net_gain_loss() {
		return r0260_pro_sold_net_gain_loss;
	}
	public void setR0260_pro_sold_net_gain_loss(BigDecimal r0260_pro_sold_net_gain_loss) {
		this.r0260_pro_sold_net_gain_loss = r0260_pro_sold_net_gain_loss;
	}
	public BigDecimal getR0260_res_1_to_3_years_mkt_val() {
		return r0260_res_1_to_3_years_mkt_val;
	}
	public void setR0260_res_1_to_3_years_mkt_val(BigDecimal r0260_res_1_to_3_years_mkt_val) {
		this.r0260_res_1_to_3_years_mkt_val = r0260_res_1_to_3_years_mkt_val;
	}
	public BigDecimal getR0260_res_lessthan_1_year_mkt_val() {
		return r0260_res_lessthan_1_year_mkt_val;
	}
	public void setR0260_res_lessthan_1_year_mkt_val(BigDecimal r0260_res_lessthan_1_year_mkt_val) {
		this.r0260_res_lessthan_1_year_mkt_val = r0260_res_lessthan_1_year_mkt_val;
	}
	public BigDecimal getR0260_res_morethan_3_years_mkt_val() {
		return r0260_res_morethan_3_years_mkt_val;
	}
	public void setR0260_res_morethan_3_years_mkt_val(BigDecimal r0260_res_morethan_3_years_mkt_val) {
		this.r0260_res_morethan_3_years_mkt_val = r0260_res_morethan_3_years_mkt_val;
	}
	public BigDecimal getR0260_res_nat_amt() {
		return r0260_res_nat_amt;
	}
	public void setR0260_res_nat_amt(BigDecimal r0260_res_nat_amt) {
		this.r0260_res_nat_amt = r0260_res_nat_amt;
	}
	public BigDecimal getR0260_sold_hedg_net_delta_pos() {
		return r0260_sold_hedg_net_delta_pos;
	}
	public void setR0260_sold_hedg_net_delta_pos(BigDecimal r0260_sold_hedg_net_delta_pos) {
		this.r0260_sold_hedg_net_delta_pos = r0260_sold_hedg_net_delta_pos;
	}
	public BigDecimal getR0260_sold_trad_net_delta_pos() {
		return r0260_sold_trad_net_delta_pos;
	}
	public void setR0260_sold_trad_net_delta_pos(BigDecimal r0260_sold_trad_net_delta_pos) {
		this.r0260_sold_trad_net_delta_pos = r0260_sold_trad_net_delta_pos;
	}
	public BigDecimal getR0260_trad_nat_amt() {
		return r0260_trad_nat_amt;
	}
	public void setR0260_trad_nat_amt(BigDecimal r0260_trad_nat_amt) {
		this.r0260_trad_nat_amt = r0260_trad_nat_amt;
	}
	public BigDecimal getR0260_within_1_year_nat_amt() {
		return r0260_within_1_year_nat_amt;
	}
	public void setR0260_within_1_year_nat_amt(BigDecimal r0260_within_1_year_nat_amt) {
		this.r0260_within_1_year_nat_amt = r0260_within_1_year_nat_amt;
	}
	public BigDecimal getReport_code() {
		return report_code;
	}
	public void setReport_code(BigDecimal report_code) {
		this.report_code = report_code;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public BigDecimal getReport_desc() {
		return report_desc;
	}
	public void setReport_desc(BigDecimal report_desc) {
		this.report_desc = report_desc;
	}
	public BigDecimal getReport_frequency() {
		return report_frequency;
	}
	public void setReport_frequency(BigDecimal report_frequency) {
		this.report_frequency = report_frequency;
	}
	public BigDecimal getReport_version() {
		return report_version;
	}
	public void setReport_version(BigDecimal report_version) {
		this.report_version = report_version;
	}
	public CBUAE_BRF7_3_Summary_Entity1() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}

