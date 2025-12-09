package com.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileUtil {

	public static String zipFolder(String sourceFolderPath, String zipFilePath) throws IOException {
		FileOutputStream fos = new FileOutputStream(zipFilePath);
		try (ZipOutputStream zos = new ZipOutputStream(fos)) {
			File folder = new File(sourceFolderPath);
			zipFile(folder, folder.getName(), zos);
		}
		return zipFilePath;
	}

	private static void zipFile(File fileToZip, String fileName, ZipOutputStream zos) throws IOException {
		if (fileToZip.isHidden()) return;

		if (fileToZip.isDirectory()) {
			if (fileName.endsWith("/")) {
				zos.putNextEntry(new ZipEntry(fileName));
				zos.closeEntry();
			} else {
				zos.putNextEntry(new ZipEntry(fileName + "/"));
				zos.closeEntry();
			}
			File[] children = fileToZip.listFiles();
			if (children != null) {
				for (File childFile : children) {
					zipFile(childFile, fileName + "/" + childFile.getName(), zos);
				}
			}
			return;
		}

		try (FileInputStream fis = new FileInputStream(fileToZip)) {
			ZipEntry zipEntry = new ZipEntry(fileName);
			zos.putNextEntry(zipEntry);

			byte[] bytes = new byte[1024];
			int length;
			while ((length = fis.read(bytes)) >= 0) {
				zos.write(bytes, 0, length);
			}
		}
	}
}
