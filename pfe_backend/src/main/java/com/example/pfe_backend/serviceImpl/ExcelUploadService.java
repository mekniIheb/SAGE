package com.example.pfe_backend.serviceImpl;

import com.example.pfe_backend.model.Presence;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ExcelUploadService {
    public static boolean isValidExcelFile(MultipartFile file){
        return Objects.equals(file.getContentType(), "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" );
    }
    public static List<Presence> getPresencesDataFromExcel(InputStream inputStream) {
        List<Presence> presences = new ArrayList<>();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            ZipSecureFile.setMinInflateRatio(0.001); // To handle secure large files

            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("presences"); // Ensure correct sheet name

            if (sheet == null) {
                throw new IllegalArgumentException("Sheet 'presences' not found in the Excel file.");
            }

            System.out.println("First row number: " + sheet.getFirstRowNum());

            int rowIndex = 0; // Initialize rowIndex properly

            for (Row row : sheet) {
                if (rowIndex == 0) { // Skip header row
                    rowIndex++;
                    continue;
                }

                Presence presence = new Presence();
                Iterator<Cell> cellIterator = row.iterator();
                int cellIndex = 0;

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    switch (cellIndex) {
                        case 0 -> {
                            // Handle both STRING and NUMERIC cell types for Matricule
                            if (cell.getCellType() == CellType.NUMERIC) {
                                presence.setMatricule((int) cell.getNumericCellValue());
                            } else if (cell.getCellType() == CellType.STRING) {
                                presence.setMatricule(Integer.parseInt(cell.getStringCellValue().trim()));
                            }
                        }
                        case 1 -> {
                            // Handle STRING type for Nom
                            if (cell.getCellType() == CellType.STRING) {
                                presence.setNom(cell.getStringCellValue());
                            } else if (cell.getCellType() == CellType.NUMERIC) {
                                presence.setNom(String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                        case 2 -> {
                            // Handle Date (can be either STRING or NUMERIC)
                            if (cell.getCellType() == CellType.NUMERIC) {
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    presence.setDate(cell.getLocalDateTimeCellValue().toLocalDate());
                                }
                            } else if (cell.getCellType() == CellType.STRING) {
                                try {
                                    presence.setDate(LocalDate.parse(cell.getStringCellValue().trim(), dateFormatter));
                                } catch (DateTimeParseException e) {
                                    System.out.println("Error parsing date: " + cell.getStringCellValue());
                                    e.printStackTrace();
                                }
                            }
                        }
                        case 3 -> {
                            // Handle Horaire as STRING
                            if (cell.getCellType() == CellType.STRING) {
                                presence.setHoraire(cell.getStringCellValue());
                            } else if (cell.getCellType() == CellType.NUMERIC) {
                                presence.setHoraire(String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                        case 4 -> {
                            // Handle Debut as STRING
                            if (cell.getCellType() == CellType.STRING) {
                                presence.setDebut(cell.getStringCellValue());
                            } else if (cell.getCellType() == CellType.NUMERIC) {
                                presence.setDebut(String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                        case 5 -> {
                            // Handle Fin as STRING
                            if (cell.getCellType() == CellType.STRING) {
                                presence.setFin(cell.getStringCellValue());
                            } else if (cell.getCellType() == CellType.NUMERIC) {
                                presence.setFin(String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                        case 6 -> {
                            // Handle Entree as STRING
                            if (cell.getCellType() == CellType.STRING) {
                                presence.setEntree(cell.getStringCellValue());
                            } else if (cell.getCellType() == CellType.NUMERIC) {
                                presence.setEntree(String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                        case 7 -> {
                            // Handle Sortie as STRING
                            if (cell.getCellType() == CellType.STRING) {
                                presence.setSortie(cell.getStringCellValue());
                            } else if (cell.getCellType() == CellType.NUMERIC) {
                                presence.setSortie(String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                        case 8 -> {
                            // Handle PresencePlaning as STRING
                            if (cell.getCellType() == CellType.STRING) {
                                presence.setPresencePlaning(cell.getStringCellValue());
                            } else if (cell.getCellType() == CellType.NUMERIC) {
                                presence.setPresencePlaning(String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                        case 9 -> {
                            // Handle Motif as STRING
                            if (cell.getCellType() == CellType.STRING) {
                                presence.setMotif(cell.getStringCellValue());
                            } else if (cell.getCellType() == CellType.NUMERIC) {
                                presence.setMotif(String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                        case 10 -> {
                            // Handle Departement as STRING
                            if (cell.getCellType() == CellType.STRING) {
                                presence.setDepartement(cell.getStringCellValue());
                            } else if (cell.getCellType() == CellType.NUMERIC) {
                                presence.setDepartement(String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                        default -> {
                            // Ignore extra cells
                        }
                    }
                    cellIndex++;
                }
                presences.add(presence); // Add to the list after reading the row
                rowIndex++; // Increment row index properly
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return presences;
    }

}
