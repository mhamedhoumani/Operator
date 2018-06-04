/*==============================================================*/
/* Nom de SGBD :  MySQL 3.22                                    */
/* Date de création :  4/30/2009 12:20:24 AM                    */
/*==============================================================*/







/*==============================================================*/
/* Table : administration                                        */
/*==============================================================*/



CREATE TABLE `administration` (
  `login` varchar(100) NOT NULL default '',
  `pass` varchar(100) NOT NULL default '',
  PRIMARY KEY  (`login`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;



-- Contenu de la table `administration`



INSERT INTO `administration` VALUES ('admin', '*');





/*==============================================================*/
/* Table : DOCUMENTS                                            */
/*==============================================================*/
create table Documents
(
   NumeroduDocument                     int                            not null,
   NomduDocument              varchar(1024),
   FormatduDocument                 varchar(1024),
   Datedecreation                    Date,
   primary key (NumeroduDocument)
);

/*==============================================================*/
/* Table : MATERIELS                                            */
/*==============================================================*/
 create table Materiels
 (
     NumeroduMateriel      int    not null,
     NomduMateriel              varchar(1024),
     ReferenceduMateriel        varchar(1024),
     Constructeur                varchar(1024),
     DateDajout                  Date,
     Modele                     varchar(1024),
     primary key(NumeroduMateriel)
     );
     

/*==============================================================*/
/* Table : MATERIEL_POSSED_UN_DOCUMENT                          */
/*==============================================================*/
create table Materiel_Possede_Document
(
   NumeroDocument                     int                            not null,
   NumeroMateriel                      int                            not null,
   primary key (NumeroDocument, NumeroMateriel)
);

/*==============================================================*/
/* Index : MATERIEL_POSSED_UN_DOCUMENT_FK                       */
/*==============================================================*/
create index Materiel_Possede_Document_FK on Materiel_Possede_Document
(
   NumeroDocument
);

/*==============================================================*/
/* Index : MATERIEL_POSSED_UN_DOCUMENT2_FK                      */
/*==============================================================*/
create index Materiel_Possede_Document2_FK on Materiel_Possede_Document
(
   NumeroMateriel
);

