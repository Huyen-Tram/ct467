create database IF NOT EXISTS  shopping;
use shopping;
-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 10, 2022 lúc 11:49 AM
-- Phiên bản máy phục vụ: 10.4.22-MariaDB
-- Phiên bản PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `shopping`
--

DELIMITER $$
--
-- Thủ tục
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `addchitiethoadon` (`id_sp` INT(11), `id_hd` INT(11), `sl` INT(2), `tongtien` INT(16))  begin 
	INSERT INTO `chitiethoadon` (`ID_SP`, `ID_GIOHANG`, `SO_LUONG`, `TONGTIENCHITIET`) VALUES (id_sp, id_hd, sl, tongtien);
    UPDATE SanPham SET SO_LUONG_TON_KHO = SO_LUONG_TON_KHO - sl where ID_SP= id_sp;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `addhoadon` (`tongtien` INT(11))  begin
	INSERT INTO `giohanng` (`ID_NGUOIDUNG`, `NGAY_LAP`, `TONGTIENHOADON`) VALUES ( '2', now(), tongtien);
	select max(id_giohang) id from giohanng;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getchitiethd` (`id_hd` INT(11))  begin
	select 	ct.id_sp,
			sp.tensp,
            ct.so_luong,
            sp.don_gia,
            ct.tongtienchitiet
    from chitiethoadon ct join sanpham sp on ct.id_sp = sp.id_sp
    where ct.id_giohang = id_hd;
end$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `ID_SP` int(11) NOT NULL,
  `ID_GIOHANG` int(11) NOT NULL,
  `SO_LUONG` int(2) DEFAULT NULL,
  `TONGTIENCHITIET` int(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `chitiethoadon`
--

INSERT INTO `chitiethoadon` (`ID_SP`, `ID_GIOHANG`, `SO_LUONG`, `TONGTIENCHITIET`) VALUES
(1, 1, 3, 178000),
(2, 1, 3, 178000),
(2, 3, 3, 300000),
(3, 1, 3, 178000),
(4, 2, 1, 100000),
(6, 3, 2, 600000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giohanng`
--

CREATE TABLE `giohanng` (
  `ID_GIOHANG` int(11) NOT NULL,
  `ID_NGUOIDUNG` int(11) NOT NULL,
  `NGAY_LAP` datetime DEFAULT NULL,
  `TONGTIENHOADON` int(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `giohanng`
--

INSERT INTO `giohanng` (`ID_GIOHANG`, `ID_NGUOIDUNG`, `NGAY_LAP`, `TONGTIENHOADON`) VALUES
(1, 2, '2022-04-26 17:12:43', 999999999),
(2, 2, '2022-05-10 15:48:37', 100000),
(3, 2, '2022-05-10 16:02:17', 900000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nguoidung`
--

CREATE TABLE `nguoidung` (
  `ID_NGUOIDUNG` int(11) NOT NULL,
  `ID_TAIKHOAN` int(2) NOT NULL,
  `HO_TEN_NV` varchar(64) DEFAULT NULL,
  `GIOI_TINH` char(1) DEFAULT NULL,
  `DIA_CHI` varchar(128) DEFAULT NULL,
  `SDT` char(16) DEFAULT NULL,
  `DA_XOA` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `nguoidung`
--

INSERT INTO `nguoidung` (`ID_NGUOIDUNG`, `ID_TAIKHOAN`, `HO_TEN_NV`, `GIOI_TINH`, `DIA_CHI`, `SDT`, `DA_XOA`) VALUES
(1, 1, 'an', 'm', ' cantho', '1234567890', NULL),
(2, 2, 'cham', 'f', ' cantho', '1234567890', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `ID_SP` int(11) NOT NULL,
  `TENSP` varchar(64) DEFAULT NULL,
  `SO_LUONG_TON_KHO` int(8) DEFAULT NULL,
  `DON_GIA` int(11) DEFAULT NULL,
  `DAXOA` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`ID_SP`, `TENSP`, `SO_LUONG_TON_KHO`, `DON_GIA`, `DAXOA`) VALUES
(1, 'vay', -4, 100000, NULL),
(2, 'dep', -1, 100000, NULL),
(3, 'ao', 24, 200000, NULL),
(4, 'non', 9, 100000, NULL),
(5, 'nhan', 14, 500000, NULL),
(6, 'ao khoac', 34, 300000, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `ID_TAIKHOAN` int(2) NOT NULL,
  `IDVAITRO` int(2) NOT NULL,
  `USERNAME` char(32) DEFAULT NULL,
  `PASSWORD` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`ID_TAIKHOAN`, `IDVAITRO`, `USERNAME`, `PASSWORD`) VALUES
(1, 1, 'TUI', '356a192b7913b04c54574d18c28d46e6395428ab'),
(2, 2, 'aido', '356a192b7913b04c54574d18c28d46e6395428ab');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `vaitro`
--

CREATE TABLE `vaitro` (
  `IDVAITRO` int(2) NOT NULL,
  `TENVAITRO` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `vaitro`
--

INSERT INTO `vaitro` (`IDVAITRO`, `TENVAITRO`) VALUES
(1, 'admin'),
(2, 'user');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD PRIMARY KEY (`ID_SP`,`ID_GIOHANG`),
  ADD KEY `I_FK_CHITIETHOADON_SANPHAM` (`ID_SP`),
  ADD KEY `I_FK_CHITIETHOADON_GIOHANNG` (`ID_GIOHANG`);

--
-- Chỉ mục cho bảng `giohanng`
--
ALTER TABLE `giohanng`
  ADD PRIMARY KEY (`ID_GIOHANG`),
  ADD KEY `I_FK_GIOHANNG_NGUOIDUNG` (`ID_NGUOIDUNG`);

--
-- Chỉ mục cho bảng `nguoidung`
--
ALTER TABLE `nguoidung`
  ADD PRIMARY KEY (`ID_NGUOIDUNG`),
  ADD UNIQUE KEY `I_FK_NGUOIDUNG_TAIKHOAN` (`ID_TAIKHOAN`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`ID_SP`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`ID_TAIKHOAN`),
  ADD KEY `I_FK_TAIKHOAN_VAITRO` (`IDVAITRO`);

--
-- Chỉ mục cho bảng `vaitro`
--
ALTER TABLE `vaitro`
  ADD PRIMARY KEY (`IDVAITRO`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  MODIFY `ID_SP` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `giohanng`
--
ALTER TABLE `giohanng`
  MODIFY `ID_GIOHANG` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `nguoidung`
--
ALTER TABLE `nguoidung`
  MODIFY `ID_NGUOIDUNG` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `ID_SP` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `ID_TAIKHOAN` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `vaitro`
--
ALTER TABLE `vaitro`
  MODIFY `IDVAITRO` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD CONSTRAINT `FK_CHITIETHOADON_GIOHANNG` FOREIGN KEY (`ID_GIOHANG`) REFERENCES `giohanng` (`ID_GIOHANG`),
  ADD CONSTRAINT `FK_CHITIETHOADON_SANPHAM` FOREIGN KEY (`ID_SP`) REFERENCES `sanpham` (`ID_SP`);

--
-- Các ràng buộc cho bảng `giohanng`
--
ALTER TABLE `giohanng`
  ADD CONSTRAINT `FK_GIOHANNG_NGUOIDUNG` FOREIGN KEY (`ID_NGUOIDUNG`) REFERENCES `nguoidung` (`ID_NGUOIDUNG`);

--
-- Các ràng buộc cho bảng `nguoidung`
--
ALTER TABLE `nguoidung`
  ADD CONSTRAINT `FK_NGUOIDUNG_TAIKHOAN` FOREIGN KEY (`ID_TAIKHOAN`) REFERENCES `taikhoan` (`ID_TAIKHOAN`);

--
-- Các ràng buộc cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `FK_TAIKHOAN_VAITRO` FOREIGN KEY (`IDVAITRO`) REFERENCES `vaitro` (`IDVAITRO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
