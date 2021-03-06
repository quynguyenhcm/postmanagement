--USE [post]
--GO
--
--/****** Object:  Table [dbo].[post]    Script Date: 28/04/2020 12:08:15 AM ******/
--SET ANSI_NULLS ON
--GO
--
--SET QUOTED_IDENTIFIER ON
--GO
--
--CREATE TABLE [dbo].[post](
--	[id] [int] IDENTITY(1,1) NOT NULL,
--	[title] [varchar](255) NULL,
--	[body] [varchar](255) NULL,
-- CONSTRAINT [PK_post] PRIMARY KEY CLUSTERED
--(
--	[id] ASC
--)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
--) ON [PRIMARY]
--GO
--
--USE [post]
--GO
--
--/****** Object:  Table [dbo].[Comment]    Script Date: 28/04/2020 12:08:26 AM ******/
--SET ANSI_NULLS ON
--GO
--
--SET QUOTED_IDENTIFIER ON
--GO
--
--CREATE TABLE [dbo].[Comment](
--	[id] [int] IDENTITY(1,1) NOT NULL,
--	[name] [varchar](255) NULL,
--	[body] [varchar](255) NULL,
--	[email] [varchar](255) NULL,
--	[post_id] [int] NULL,
-- CONSTRAINT [PK_Comment] PRIMARY KEY CLUSTERED
--(
--	[id] ASC
--)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
--) ON [PRIMARY]
--GO
--
--ALTER TABLE [dbo].[Comment]  WITH CHECK ADD  CONSTRAINT [FK_Comment_post] FOREIGN KEY([post_id])
--REFERENCES [dbo].[post] ([id])
--GO
--
--ALTER TABLE [dbo].[Comment] CHECK CONSTRAINT [FK_Comment_post]
--GO
--
--delete  from post;
--delete from comment;

insert into post (body, title) values ('First user - The first great body', 'Great Post 1');
insert into post (body, title) values ('First user - The second great body', 'Great Post 2');
insert into post (body, title) values ('First user - The third great body', 'Great Post 3');

insert into comment (body, name, post_id, email) values ('Great Post 1 is so beautiful', 'Post 1 is Beautiful', 1, 'user1@wp.co.nz');
insert into comment (body, name, post_id, email) values ('Great Post 2 can be improved', 'Post 2 can be improved', 2, 'user1@wp.co.nz');
insert into comment (body, name, post_id, email) values ('Great Post 2 is too long', 'Post 2 should be shortened', 2, 'user1@wp.co.nz');
insert into comment (body, name, post_id, email) values ('Great Post 3 is not funny', 'Post 3 is funny', 2, 'user2@wp.co.nz');
