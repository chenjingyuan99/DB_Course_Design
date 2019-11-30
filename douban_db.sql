USE [douban_db]
GO
/****** Object:  User [barry]    Script Date: 11/24/2019 11:08:48 ******/
CREATE USER [barry] FOR LOGIN [barry] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[db_usr]    Script Date: 11/24/2019 11:08:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[db_usr](
	[usr_id] [int] IDENTITY(1,1) NOT NULL,
	[usr_account] [varchar](16) NOT NULL,
	[usr_nickname] [varchar](16) NOT NULL,
	[usr_passwd] [varchar](16) NOT NULL,
 CONSTRAINT [PK_db_usr] PRIMARY KEY CLUSTERED 
(
	[usr_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[db_type]    Script Date: 11/24/2019 11:08:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[db_type](
	[type_id] [int] IDENTITY(1,1) NOT NULL,
	[type_name] [varchar](32) NOT NULL,
 CONSTRAINT [PK_db_type] PRIMARY KEY CLUSTERED 
(
	[type_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[db_scriptwriter]    Script Date: 11/24/2019 11:08:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[db_scriptwriter](
	[scriptwriter_id] [int] IDENTITY(1,1) NOT NULL,
	[scriptwriter_name] [varchar](32) NOT NULL,
 CONSTRAINT [PK_db_scriptwriter] PRIMARY KEY CLUSTERED 
(
	[scriptwriter_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[db_script]    Script Date: 11/24/2019 11:08:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[db_script](
	[scriptwriter_id] [int] IDENTITY(1,1) NOT NULL,
	[movie_id] [int] NOT NULL,
 CONSTRAINT [PK_db_script] PRIMARY KEY CLUSTERED 
(
	[scriptwriter_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[db_responding]    Script Date: 11/24/2019 11:08:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[db_responding](
	[respond_id] [int] IDENTITY(1,1) NOT NULL,
	[promulgator] [varchar](32) NOT NULL,
	[release_time] [timestamp] NOT NULL,
	[respond_content] [varchar](400) NULL,
	[discuss_id] [int] NOT NULL,
 CONSTRAINT [PK_db_responding] PRIMARY KEY CLUSTERED 
(
	[respond_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[db_region]    Script Date: 11/24/2019 11:08:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[db_region](
	[region_id] [int] IDENTITY(1,1) NOT NULL,
	[region_name] [varchar](32) NOT NULL,
 CONSTRAINT [PK_db_region] PRIMARY KEY CLUSTERED 
(
	[region_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[db_movie_language]    Script Date: 11/24/2019 11:08:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[db_movie_language](
	[language_id] [int] IDENTITY(1,1) NOT NULL,
	[movie_id] [int] NOT NULL,
 CONSTRAINT [PK_db_movie_language] PRIMARY KEY CLUSTERED 
(
	[language_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[db_movie]    Script Date: 11/24/2019 11:08:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[db_movie](
	[movie_id] [int] IDENTITY(1,1) NOT NULL,
	[movie_name] [varchar](32) NOT NULL,
	[release_date] [date] NOT NULL,
	[movie_time] [timestamp] NOT NULL,
	[movie_introduction] [varchar](400) NOT NULL,
 CONSTRAINT [PK_db_movie] PRIMARY KEY CLUSTERED 
(
	[movie_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[db_location]    Script Date: 11/24/2019 11:08:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[db_location](
	[region_id] [int] IDENTITY(1,1) NOT NULL,
	[movie_id] [int] NOT NULL,
 CONSTRAINT [PK_db_location] PRIMARY KEY CLUSTERED 
(
	[region_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[db_language]    Script Date: 11/24/2019 11:08:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[db_language](
	[language_id] [int] IDENTITY(1,1) NOT NULL,
	[language_name] [varchar](32) NOT NULL,
 CONSTRAINT [PK_db_language] PRIMARY KEY CLUSTERED 
(
	[language_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[db_label]    Script Date: 11/24/2019 11:08:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[db_label](
	[lab_id] [int] IDENTITY(1,1) NOT NULL,
	[com_id] [int] NULL,
	[lab_comment] [varchar](16) NULL,
 CONSTRAINT [PK_db_label] PRIMARY KEY CLUSTERED 
(
	[lab_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[db_discussion]    Script Date: 11/24/2019 11:08:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[db_discussion](
	[discuss_id] [int] IDENTITY(1,1) NOT NULL,
	[discuss_topic] [varchar](32) NOT NULL,
	[promulgator] [varchar](32) NOT NULL,
	[release_time] [timestamp] NOT NULL,
	[discuss_content] [varchar](400) NULL,
 CONSTRAINT [PK_db_discussion] PRIMARY KEY CLUSTERED 
(
	[discuss_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[db_discuss]    Script Date: 11/24/2019 11:08:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[db_discuss](
	[discuss_id] [int] IDENTITY(1,1) NOT NULL,
	[movie_id] [int] NOT NULL,
 CONSTRAINT [PK_db_discuss] PRIMARY KEY CLUSTERED 
(
	[discuss_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[db_director]    Script Date: 11/24/2019 11:08:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[db_director](
	[director_id] [int] IDENTITY(1,1) NOT NULL,
	[director_name] [varchar](32) NOT NULL,
 CONSTRAINT [PK_db_director] PRIMARY KEY CLUSTERED 
(
	[director_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[db_direct]    Script Date: 11/24/2019 11:08:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[db_direct](
	[director_id] [int] IDENTITY(1,1) NOT NULL,
	[movie_id] [int] NOT NULL,
 CONSTRAINT [PK_db_direct] PRIMARY KEY CLUSTERED 
(
	[director_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[db_comment]    Script Date: 11/24/2019 11:08:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[db_comment](
	[com_id] [int] IDENTITY(1,1) NOT NULL,
	[mov_id] [int] NOT NULL,
	[usr_id] [int] NOT NULL,
	[com_seen] [tinyint] NOT NULL,
	[com_star] [tinyint] NULL,
	[com_content] [varchar](16) NULL,
	[com_time] [timestamp] NULL,
 CONSTRAINT [PK_db_comment] PRIMARY KEY CLUSTERED 
(
	[com_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[db_classify]    Script Date: 11/24/2019 11:08:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[db_classify](
	[type_id] [int] IDENTITY(1,1) NOT NULL,
	[movie_id] [int] NOT NULL,
 CONSTRAINT [PK_db_classify] PRIMARY KEY CLUSTERED 
(
	[type_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[db_awards]    Script Date: 11/24/2019 11:08:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[db_awards](
	[awards_id] [int] IDENTITY(1,1) NOT NULL,
	[movie_id] [int] NOT NULL,
 CONSTRAINT [PK_db_awards] PRIMARY KEY CLUSTERED 
(
	[awards_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[db_awarding]    Script Date: 11/24/2019 11:08:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[db_awarding](
	[awards_id] [int] IDENTITY(1,1) NOT NULL,
	[awards_name] [varchar](32) NOT NULL,
	[activities] [varchar](32) NULL,
	[award_object] [varchar](32) NULL,
 CONSTRAINT [PK_db_awarding] PRIMARY KEY CLUSTERED 
(
	[awards_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[db_actor]    Script Date: 11/24/2019 11:08:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[db_actor](
	[actor_id] [int] IDENTITY(1,1) NOT NULL,
	[actor_name] [varchar](32) NOT NULL,
	[is_star] [tinyint] NOT NULL,
 CONSTRAINT [PK_db_actor] PRIMARY KEY CLUSTERED 
(
	[actor_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[db_act]    Script Date: 11/24/2019 11:08:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[db_act](
	[actor_id] [int] IDENTITY(1,1) NOT NULL,
	[movie_id] [int] NOT NULL,
	[role_name] [varchar](32) NOT NULL,
 CONSTRAINT [PK_db_act] PRIMARY KEY CLUSTERED 
(
	[actor_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
