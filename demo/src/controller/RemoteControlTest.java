package controller;

import invoker.RemoteControl;
import model.Fan;
import model.Light;
import service.Command;
import service.impl.FanOffCommand;
import service.impl.FanOnCommand;
import service.impl.LightOffCommand;
import service.impl.LightOnCommand;

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
        Thread.sleep(3000);
        remote.setCommand(fanOff);

    }
}
