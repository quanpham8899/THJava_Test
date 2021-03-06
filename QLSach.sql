USE [QLSach]
GO
/****** Object:  Table [dbo].[LoaiSach]    Script Date: 14-04-2021 7:55:49 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiSach](
	[MaLoai] [int] NOT NULL,
	[TenLoai] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_LoaiSach] PRIMARY KEY CLUSTERED 
(
	[MaLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Sach]    Script Date: 14-04-2021 7:55:49 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Sach](
	[MaSach] [char](6) NOT NULL,
	[TenSach] [nvarchar](150) NOT NULL,
	[GiaSach] [int] NOT NULL,
	[MaLoai] [int] NOT NULL,
	[NamXB] [int] NOT NULL,
 CONSTRAINT [PK_Sach] PRIMARY KEY CLUSTERED 
(
	[MaSach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[LoaiSach] ([MaLoai], [TenLoai]) VALUES (1, N'Khoa học')
INSERT [dbo].[LoaiSach] ([MaLoai], [TenLoai]) VALUES (2, N'Đời sống')
INSERT [dbo].[LoaiSach] ([MaLoai], [TenLoai]) VALUES (3, N'Y học')
INSERT [dbo].[Sach] ([MaSach], [TenSach], [GiaSach], [MaLoai], [NamXB]) VALUES (N'DS0001', N'Quà tặng cuộc sống', 45000, 2, 2005)
INSERT [dbo].[Sach] ([MaSach], [TenSach], [GiaSach], [MaLoai], [NamXB]) VALUES (N'DS0002', N'Món quà đến từ cuộc sống', 56000, 2, 2020)
INSERT [dbo].[Sach] ([MaSach], [TenSach], [GiaSach], [MaLoai], [NamXB]) VALUES (N'KH0001', N'Em yêu khoa học', 55000, 1, 2005)
INSERT [dbo].[Sach] ([MaSach], [TenSach], [GiaSach], [MaLoai], [NamXB]) VALUES (N'KH0002', N'Hải dương học', 120000, 1, 2015)
INSERT [dbo].[Sach] ([MaSach], [TenSach], [GiaSach], [MaLoai], [NamXB]) VALUES (N'YH0001', N'Nhà tôi 3 đời chữa xương khớp', 450000, 3, 2021)
ALTER TABLE [dbo].[Sach]  WITH CHECK ADD  CONSTRAINT [FK_Sach_LoaiSach] FOREIGN KEY([MaLoai])
REFERENCES [dbo].[LoaiSach] ([MaLoai])
GO
ALTER TABLE [dbo].[Sach] CHECK CONSTRAINT [FK_Sach_LoaiSach]
GO
