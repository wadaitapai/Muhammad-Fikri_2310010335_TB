-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 04, 2026 at 04:28 PM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inventaris`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_aset`
--

CREATE TABLE `tbl_aset` (
  `id_aset` int(11) NOT NULL,
  `nama_aset` varchar(100) NOT NULL,
  `kategori` varchar(50) DEFAULT NULL,
  `jumlah` int(11) NOT NULL,
  `harga` decimal(15,2) DEFAULT NULL,
  `tgl_register` date DEFAULT NULL,
  `status` varchar(20) NOT NULL DEFAULT 'Tersedia'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_aset`
--

INSERT INTO `tbl_aset` (`id_aset`, `nama_aset`, `kategori`, `jumlah`, `harga`, `tgl_register`, `status`) VALUES
(1, 'Laptop ASUS ROG', 'Elektronik', 5, '15000000.00', '2026-01-03', 'Tersedia'),
(2, 'Meja Kantor Kayu', 'Furniture', 10, '750000.00', '2026-01-03', 'Tersedia'),
(3, 'Kursi Gaming Secretlab', 'elektronik furnitur', 8, '2400000.00', '2026-01-03', 'Tersedia'),
(5, 'Proyektor BenQ', 'Elektronik', 2, '6000000.00', '2026-01-03', 'Tersedia'),
(6, 'AC Split Samsung 1PK', 'Elektronik', 4, '3800000.00', '2026-01-03', 'Tersedia'),
(9, 'mouse', 'elektornik', 2, '145000.00', '2026-01-04', 'Tersedia');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_pegawai`
--

CREATE TABLE `tbl_pegawai` (
  `id_pegawai` int(11) NOT NULL,
  `nama_pegawai` varchar(100) NOT NULL,
  `jabatan` varchar(50) DEFAULT NULL,
  `unit_kerja` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_pegawai`
--

INSERT INTO `tbl_pegawai` (`id_pegawai`, `nama_pegawai`, `jabatan`, `unit_kerja`) VALUES
(1, 'Andi Wijaya', 'Kepala Gudang', 'Logistik'),
(2, 'Rina Pratama', 'Staff Admin', 'Umum'),
(3, 'Budi Cahyono', 'Teknisi', 'Maintenance'),
(5, 'Eko Saputra', 'Driver', 'operasional'),
(7, 'muhammad fikri', 'teknisi', 'maintenance');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_peminjaman`
--

CREATE TABLE `tbl_peminjaman` (
  `id_peminjaman` int(11) NOT NULL,
  `id_aset` int(11) NOT NULL,
  `id_pegawai` int(11) NOT NULL,
  `tgl_pinjam` date NOT NULL,
  `tgl_kembali` date DEFAULT NULL,
  `status` enum('Dipinjam','Kembali') DEFAULT 'Dipinjam'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_peminjaman`
--

INSERT INTO `tbl_peminjaman` (`id_peminjaman`, `id_aset`, `id_pegawai`, `tgl_pinjam`, `tgl_kembali`, `status`) VALUES
(1, 1, 1, '2026-01-04', '2026-01-04', 'Kembali');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_aset`
--
ALTER TABLE `tbl_aset`
  ADD PRIMARY KEY (`id_aset`);

--
-- Indexes for table `tbl_pegawai`
--
ALTER TABLE `tbl_pegawai`
  ADD PRIMARY KEY (`id_pegawai`);

--
-- Indexes for table `tbl_peminjaman`
--
ALTER TABLE `tbl_peminjaman`
  ADD PRIMARY KEY (`id_peminjaman`),
  ADD KEY `fk_aset` (`id_aset`),
  ADD KEY `fk_pegawai` (`id_pegawai`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_aset`
--
ALTER TABLE `tbl_aset`
  MODIFY `id_aset` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `tbl_pegawai`
--
ALTER TABLE `tbl_pegawai`
  MODIFY `id_pegawai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tbl_peminjaman`
--
ALTER TABLE `tbl_peminjaman`
  MODIFY `id_peminjaman` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_peminjaman`
--
ALTER TABLE `tbl_peminjaman`
  ADD CONSTRAINT `fk_aset` FOREIGN KEY (`id_aset`) REFERENCES `tbl_aset` (`id_aset`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_pegawai` FOREIGN KEY (`id_pegawai`) REFERENCES `tbl_pegawai` (`id_pegawai`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tbl_peminjaman_ibfk_1` FOREIGN KEY (`id_aset`) REFERENCES `tbl_aset` (`id_aset`),
  ADD CONSTRAINT `tbl_peminjaman_ibfk_2` FOREIGN KEY (`id_pegawai`) REFERENCES `tbl_pegawai` (`id_pegawai`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
