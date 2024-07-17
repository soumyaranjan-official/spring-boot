package com.dp;


import com.dp.entity.Fan;
import com.dp.entity.Light;
import com.dp.invoker.RemoteControl;
import com.dp.service.Command;
import com.dp.service.impl.FanOffCommand;
import com.dp.service.impl.FanOnCommand;
import com.dp.service.impl.LightOffCommand;
import com.dp.service.impl.LightOnCommand;

public class RemoteControlTest {
    public static void main(String[] args) throws InterruptedException {
        RemoteControl remote = new RemoteControl();

        Light livingRoomLight = new Light();
        Fan ceilingFan = new Fan();

        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);
        Command fanOn = new FanOnCommand(ceilingFan);
        Command fanOff = new FanOffCommand(ceilingFan);


        remote.setCommand(lightOn);

        Thread.sleep(3000);

        remote.pressButton();

        remote.setCommand(lightOff);

        Thread.sleep(3000);

        remote.pressButton();

        remote.setCommand(fanOn);
        Thread.sleep(3000);
        remote.pressButton();

        remote.setCommand(fanOff);
        remote.pressButton();
    }
}
