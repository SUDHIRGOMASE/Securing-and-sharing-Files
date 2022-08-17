///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.fileutility.util;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.FileWriter;
//
///**
// *
// * @author Sudhir Gomase
// */
//public class FileUtil {
//
//    public int split(String source, String dest, String cmt, int no, int size, int lsize, boolean del,
//            boolean batch) {
//        String name, entry;
//        long fsize, mtime;
//        boolean ronly;
//        File fl = new File(source);
//        if (fl.exists()) {
//            name = fl.getName();
//            fsize = fl.length();
//            mtime = fl.lastModified();
//            ronly = fl.canWrite();
//            if (ronly) {
//                ronly = false;
//            } else {
//                ronly = true;
//            }
//        } else {
//            //JOptionPane.showMessageDialog((Container)null,"File not found","FileManipulation System",JOptionPane.OK_OPTION);
//            return 0;
//        }
//        try {
//
//            FileInputStream fis = new FileInputStream(fl);
//            FileWriter fw = new FileWriter(dest);
//            BufferedWriter bw = new BufferedWriter(fw);
//
//            String l1 = new String("jfs" + "," + name + "," + String.valueOf(fsize) + "," + String.valueOf(mtime) + "," + String.valueOf(ronly));
//
//            bw.write(l1, 0, l1.length());
//            bw.newLine();
//            String cfile;
//            if (cmt != null) {
//                cfile = getName(name, -1);
//                File bfc = new File((new File(dest)).getParent() + "/" + cfile);
//                if (!bfc.exists()) {
//                    FileWriter fwc = new FileWriter(bfc);
//                    BufferedWriter bwc = new BufferedWriter(fwc);
//                    bwc.write(cmt, 0, cmt.length());
//                    bwc.close();
//                    fwc.close();
//                }
//            } else {
//                cfile = "null";
//            }
//            String bfile;
//            FileWriter fw2;
//            BufferedWriter bw2;
//            bfile = getName(name, -2);
//            File bf = new File(new File(dest).getParent() + "/" + bfile);
//            fw2 = new FileWriter(bf);
//            bw2 = new BufferedWriter(fw2);
//            if (batch) {
//                bfile = getName(name, -2);
//            } else {
//                bfile = "null";
//            }
//            String l2 = new String(cfile + "," + bfile + "," + String.valueOf(no) + "," + String.valueOf(size) + "," + String.valueOf(lsize));
//            bw.write(l2, 0, l2.length());
//            bw.newLine();
//            if (lsize != 0) {
//                no--;
//            }
//            for (int i = 1; i <= no; i++) {
//                String sname = getName(name, i);
//                FileOutputStream fos = new FileOutputStream(new File(dest).getParent() + "/" + sname);
//                byte[] data = new byte[size];
//                int count = fis.read(data);
//                fos.write(data);
//                fos.close();
//                String ln = new String(sname + "," + String.valueOf(size));
//                bw.write(ln, 0, ln.length());
//                bw.newLine();
//                if (batch) {
//                    String lb;
//                    if (i == 1) {
//                        lb = new String("copy /b \"" + sname + "\" \"" + name + "\"");
//                    } else {
//                        lb = new String("copy /b \"" + name + "\"+\"" + sname + "\" \"" + name + "\"");
//                    }
//                    bw2.write(lb, 0, lb.length());
//                    bw2.newLine();
//                }
//            }
//            if (lsize != 0) {
//                String sname = getName(name, ++no);
//                FileOutputStream fos = new FileOutputStream(new File(dest).getParent() + "/" + sname);
//                byte[] data = new byte[lsize];
//                int count = fis.read(data);
//                fos.write(data);
//                fos.close();
//                String ln = new String(sname + "," + String.valueOf(lsize));
//                bw.write(ln, 0, ln.length());
//                bw.newLine();
//                if (batch) {
//                    String lb;
//                    lb = new String("copy /b \"" + name + "\"+\"" + sname + "\" \"" + name + "\"");
//                    bw2.write(lb, 0, lb.length());
//                    bw2.newLine();
//                }
//
//            }
//            String eof = new String("eof");
//            bw.write(eof, 0, eof.length());
//            bw.close();
//            if (batch) {
//                String lb = new String("echo File " + name + " successfully merged");
//                bw2.write(lb, 0, lb.length());
//            }
//            bw2.close();
//            fis.close();
//
//            if (!batch) {
//                bf.delete();
//            }
//            if (del) {
//                fl.delete();
//            }
//        } catch (Exception e) {
//            //JOptionPane.showMessageDialog((Container) null, "Some internal error: Cannot split " + name + "\nReason: " + e.getMessage(), "FileManipulation System", JOptionPane.INFORMATION_MESSAGE);
//            return 0;
//        }
//
//        return 1;
//    }
//
//    public String getName(String name, int i) {
//        String lpart = name.substring(0, name.length() - 4);
//
//        String rpart;
//        if (i == 0) {
//            rpart = ".jfs";
//        } else if (i == -1) {
//            rpart = ".cmt";
//        } else if (i == -2) {
//            rpart = ".bat";
//        } else if (i < 10) {
//            rpart = ".00" + String.valueOf(i);
//        } else if (i < 100) {
//            rpart = ".0" + String.valueOf(i);
//        } else {
//            rpart = "." + String.valueOf(i);
//        }
//        return (new String(lpart + rpart));
//    }
//}
