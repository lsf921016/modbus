package com.lyfh.modbus.util;

import com.serotonin.modbus4j.ModbusFactory;
import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.ip.IpParameters;
import com.serotonin.modbus4j.msg.ReadHoldingRegistersRequest;
import com.serotonin.modbus4j.msg.ReadHoldingRegistersResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by LinShuifeng on 2019/6/5
 * E-Mail: shuifenglin216076@sohu-inc.com
 */
public class HoldingRegisterUtil {

    public static  final Logger log=LoggerFactory.getLogger(HoldingRegisterUtil.class);

    //串口服务器的ip地址
    public static final String ip="10.168.1.10";

    //串口服务器的端口号（其中一个）
    public static final int port=1030;

    private static int tryTime = 0;
    public static short[] read(String ip, int port,int slaveId, int start,int len){
        IpParameters params=new IpParameters();
        params.setHost(ip);
        params.setPort(port);
        ModbusFactory factory=new ModbusFactory();
        ModbusMaster master=factory.createTcpMaster(params,true);

        // 初始化
        try {
            master.init();
            return readHoldingRegisters(master, ip,port,slaveId, start, len);
        } catch (ModbusInitException e) {
            e.printStackTrace();
            if (tryTime<3){
                tryTime++;
                read(ip,port,slaveId,start,len);
            }else {
                log.error("TAG","请检查设置后重新连接");
            }
        } finally {
            master.destroy();
        }
        return null;
    }

    private static short[] readHoldingRegisters(ModbusMaster master,String ip, int port, int slaveId, int start, int len) {
        try {
            ReadHoldingRegistersRequest request = new ReadHoldingRegistersRequest(
                    slaveId, start, len);
            ReadHoldingRegistersResponse response = (ReadHoldingRegistersResponse) master
                    .send(request);
            if (response.isException()) {
                log.error("TAG1", "Exception response: message=" + response.getExceptionMessage());
            } else {
                short[] list = response.getShortData();
                for(int i = 0; i < list.length; i++){
                    log.info("TAG4", list[i]+"");
                }
                return list;
            }
        } catch (ModbusTransportException e) {
            e.printStackTrace();
            if (tryTime<3){
                tryTime++;
                readHoldingRegisters(master, ip, port, slaveId, start, len);
            } else {
                log.error("TAG","请检查设置后重新连接");
            }
        }
        return null;
    }
}
