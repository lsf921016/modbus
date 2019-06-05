package com.lyfh.modbus.Model;

import lombok.Data;

/**
 * Created by LinShuifeng on 2019/6/5
 * E-Mail: shuifenglin216076@sohu-inc.com
 */

@Data
public class DataBean {
    public static final double factor_running_frequency=0.01;
    public static final double factor_assigned_frequency=0.01;
    public static final double factor_motherline_voltage=0.1;
    public static final int factor_output_voltage=1;
    public static final double factor_output_electricity=0.01;
    public static final double factor_output_power=0.01;
    public static final double factor_output_torque=0.1;
    public static final int factor_DI_status=1;
    public static final int factor_DO_status=1;
    public static final double factor_Al1_voltage=0.01;
    public static final double  factor_PID_assigned=0.1;
    public static final double factor_PID_feedback=0.1;
    public static final double factor_feedback_speed=0.01;
    public static final double factor_Al1_voltage_before_rectify=0.001;
    public static final int factor_current_power_supply_time=1;
    public static final double factor_current_running_time=0.1;
    public static final double factor_communication_assigned_value=0.01;
    public static final double factor_main_frequency_x=0.01;
    public static final double factor_second_frequency_y=0.01;
    public static final double factor_target_torque=0.1;
    public static final int factor_error_msg=1;
    public static final int factor_transducer_status=1;
    public static final int factor_current_error_msg=1;
    public static final double factor_max_torque=0.1;

    //运行频率
    double running_frequency;

    //设定频率
    double assigned_frequency;

    //母线电压
    double motherline_voltage;

    //输出电压
    int output_voltage;

    //输出电流
    double output_electricity;

    //输出功率
    double output_power;

    //输出转矩
    double output_torque;

    //DI输入状态
    int DI_status;

    //DO输出状态
    int DO_status;

    //AI1电压
    double Al1_voltage;

    //PID设定
    double PID_assigned;

    //PID设定
    double PID_feedback;

    //反馈速度
    double feedback_speed;

    //AI1校正前电压
    double Al1_voltage_before_rectify;

    //当前上电时间
    int current_power_supply_time;

    //当前运行时间
    double current_running_time;

    //通讯设定值
    double communication_assigned_value;

    //主频率X显示
    double main_frequency_x;

    //辅频率Y显示
    double second_frequency_y;

    //目标转矩
    double target_torque;

    //故障信息
    int error_msg;

    //变频器状态
    int transducer_status;

    //当前故障编码
    int current_error_msg;

    //转矩上限
    double max_torque;

}
