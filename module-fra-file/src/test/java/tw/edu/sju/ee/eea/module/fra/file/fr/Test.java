/*
 * Copyright (C) 2014 Leo
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package tw.edu.sju.ee.eea.module.fra.file.fr;

import java.util.ArrayList;
import java.util.List;
import tw.edu.sju.ee.eea.jni.modinst.NIModinstUtils;

/**
 *
 * @author Leo
 */
public class Test {

    public static void main(String[] args) {
        String driver = "niScope";
        List<NIModinstUtils.Device> devices = NIModinstUtils.list(driver);
        for (int i = 0; i < devices.size(); i++) {
            NIModinstUtils.Device device = devices.get(i);
            System.out.println(device.getDeviceName());
            System.out.println(device.getDeviceModel());
            System.out.println(device.getSerialNumber());
            System.out.println(device.getSocketNumber());
            System.out.println(device.getSlotNumber());
            System.out.println(device.getBusNumber());
        }
    }
}
