USE [QLBH]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 9/6/2022 8:57:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[uID] [int] IDENTITY(1,1) NOT NULL,
	[user] [varchar](255) NULL,
	[pass] [varchar](255) NULL,
	[isSell] [int] NULL,
	[isAdmin] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[uID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cart]    Script Date: 9/6/2022 8:57:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cart](
	[AccountID] [int] NULL,
	[ProductID] [int] NULL,
	[Amount] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 9/6/2022 8:57:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[cid] [int] NOT NULL,
	[cname] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[cid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[product]    Script Date: 9/6/2022 8:57:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[product](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](max) NULL,
	[image] [nvarchar](max) NULL,
	[price] [money] NULL,
	[title] [nvarchar](max) NULL,
	[description] [nvarchar](max) NULL,
	[cateID] [int] NULL,
	[sell_ID] [int] NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 9/6/2022 8:57:39 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[UserID] [nchar](10) NULL,
	[Password] [nchar](10) NULL
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Account] ON 

INSERT [dbo].[Account] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (1, N'GIANG', N'123', 1, 1)
INSERT [dbo].[Account] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (2, N'Chien', N'123', 1, 1)
INSERT [dbo].[Account] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (3, N'Vanh', N'123', 1, 0)
SET IDENTITY_INSERT [dbo].[Account] OFF
GO
INSERT [dbo].[Category] ([cid], [cname]) VALUES (1, N'GIÀY ADIDAS')
INSERT [dbo].[Category] ([cid], [cname]) VALUES (2, N'GIÀY NIKE')
INSERT [dbo].[Category] ([cid], [cname]) VALUES (3, N'GIÀY BITI''S')
INSERT [dbo].[Category] ([cid], [cname]) VALUES (4, N'GIÀY CONVERSE')
GO
SET IDENTITY_INSERT [dbo].[product] ON 

INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID]) VALUES (19, N'GiÃ y adidas kiá»u dÃ¡ng thá» thao', N'https://th.bing.com/th/id/R.0ff42530fae7eef13b7a7c5b44f1f595?rik=qYytSHU%2b9gu24Q&riu=http%3a%2f%2f1.bp.blogspot.com%2f-IQU-IamVjxo%2fUd2VLjJCeQI%2fAAAAAAAAABo%2fH7VpJ5mX898%2fs1600%2fgiay-adidas-the-thao.jpg&ehk=w6jr7aFfWbzWClJE89OpGA8rqHOgb%2bWzYq4OE%2bpQUxo%3d&risl=&pid=ImgRaw&r=0', 500.0000, N'sdfsfdsfsfds', N'fdsfsf', 1, 1)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID]) VALUES (8, N'New Men''s Running Shoes', N'https://canary.contestimg.wish.com/api/webimage/5c4a05a08b26e56dcf17a643-normal.jpg?cache_buster=6d01b751858e14e68932bb234cdc44c1', 150.0000, N'Comfortable Sports Shoes Men Athletic Outdoor Cushioning Sneakers for Walking&Jogging (EUR Size 39-48)', N'New Men''s Running Shoes Comfortable Sports Shoes Men Athletic Outdoor Cushioning Sneakers for Walking&Jogging (EUR Size 39-48)', 4, 1)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID]) VALUES (9, N'Men Hiking Shoes Waterproof Non', N'https://canary.contestimg.wish.com/api/webimage/5dc3c309d8b69d0de8949a21-large.jpg?cache_buster=68ad269a9f7b07d0effa9e48c1dc5c0f', 180.0000, N'Men Hiking Shoes Waterproof Non-slip Sport Shoes Casual Running Camping Shoes Outdoor Sneakers for Men Size 39-47 3 Colors
', N'Men Hiking Shoes Waterproof Non-slip Sport Shoes Casual Running Camping Shoes Outdoor Sneakers for Men Size 39-47 3 Colors
', 3, 1)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID]) VALUES (22, N'Giày adidas kiểu dáng thể thao', N'https://giaythainguyen.com/wp-content/uploads/2020/04/giay-micky-2.jpg', 120.0000, N'Giay theo thao', N'Dep va Ben', 1, 2)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID]) VALUES (11, N'New Trend Men Hiking Shoes', N'https://canary.contestimg.wish.com/api/webimage/5df1f07d1fc34e0c50f78eb7-large.jpg?cache_buster=36188c130400df0faa4256aad8e90109', 150.0000, N'New Trend Men Hiking Shoes Waterproof Non-slip Sport Shoes Casual Running Camping Shoes Outdoor Sneakers for Men Size 39-48
', N'New Trend Men Hiking Shoes Waterproof Non-slip Sport Shoes Casual Running Camping Shoes Outdoor Sneakers for Men Size 39-48
', 3, 1)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID]) VALUES (12, N'Mens Skid Resistant Hiking Shoes', N'https://canary.contestimg.wish.com/api/webimage/5f3fb6d1b2a7ef003f6bd8a4-large.jpg?cache_buster=c9295f971ce194c1e68f6144f11314c6', 165.0000, N'Mens Skid Resistant Hiking Shoes Waterproof Mountain Boots Climbing Shoes Outdoor Sport Shoes Fashion Sneakers
', N'Mens Skid Resistant Hiking Shoes Waterproof Mountain Boots Climbing Shoes Outdoor Sport Shoes Fashion Sneakers
', 3, 1)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID]) VALUES (13, N'NEW Spring White Shoes Men', N'https://canary.contestimg.wish.com/api/webimage/5d0235c9ae115f0be32755ef-large.jpg?cache_buster=fd2c105001ca1cbb03795818542906cc', 185.0000, N'NEW Spring White Shoes Men Shoes Men''s Casual Shoes Fashion Sneakers Street Cool Man Footwear
', N'NEW Spring White Shoes Men Shoes Men''s Casual Shoes Fashion Sneakers Street Cool Man Footwear
', 3, 1)
INSERT [dbo].[product] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID]) VALUES (16, N'Mens Skid Resistant Hiking Shoes', N'https://canary.contestimg.wish.com/api/webimage/5c4a02d1344e882b1a41bca4-large.jpg?cache_buster=bc4ce4d229ed4e42dbba614acb622899', 150.0000, N'Mens Skid Resistant Hiking Shoes Waterproof Mountain Boots Climbing Shoes Outdoors
', N'Mens Skid Resistant Hiking Shoes Waterproof Mountain Boots Climbing Shoes Outdoors
', 1, 2)
SET IDENTITY_INSERT [dbo].[product] OFF
GO
