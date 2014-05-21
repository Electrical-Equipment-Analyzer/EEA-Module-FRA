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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openide.util.Exceptions;
import tw.edu.sju.ee.eea.core.frequency.response.FrequencyResponseFile;

/**
 *
 * @author Leo
 */
public class FileTest {

    public FileTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void hello() {
        FrequencyResponseFile frequencyResponseFile = new FrequencyResponseFile(null, null, null);
        File file = new File("src\\main\\resources\\tw\\edu\\sju\\ee\\eea\\module\\fra\\file\\fr\\FrTemplate.fr");
        try {
            frequencyResponseFile.write(new ObjectOutputStream(new FileOutputStream(file)));
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}
