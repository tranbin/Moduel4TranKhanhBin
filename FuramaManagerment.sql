create database FuramaManagerment ; 
use FuramaManagerment ;
create table vi_tri(
ma_vi_tri int primary key auto_increment,
ten_vi_tri varchar(45));

create table trinh_do(
ma_trinh_do int primary key auto_increment, 
ten_trinh_do varchar(45));

create table bo_phan(
ma_bo_phan int primary key auto_increment, 
ten_bo_phan varchar(45));

create table nhan_vien(
ma_nhan_vien int primary key auto_increment,
ho_ten varchar(45) not null , 
ngay_sinh date not null,
so_cmnd varchar(45) not null, 
luong double not null ,
so_dien_thoai varchar(45),
email varchar(45),
dia_chi varchar(45),
ma_vi_tri int,
ma_trinh_do int,
ma_bo_phan int,
foreign key(ma_vi_tri) references vi_tri(ma_vi_tri),
foreign key(ma_trinh_do) references trinh_do(ma_trinh_do),
foreign key(ma_bo_phan) references bo_phan(ma_bo_phan)
);

create table dich_vu_di_kem(
ma_dich_vu_di_kem int primary key auto_increment, 
ten_dich_vu_di_kem varchar(45) not null,
gia double not null,
don_vi varchar(10) not null , 
trang_thai varchar(45));

create table loai_khach(
ma_loai_khach int primary key auto_increment,
ten_loai_khach varchar(45));

create table khach_hang(
ma_khach_hang int primary key auto_increment,
ho_ten varchar(45) not null,
ngay_sinh date not null,
gioi_tinh bit default 1 not null,
so_cmnd varchar(45) not null,
so_dien_thoai varchar(45) not null,
email varchar(45),
dia_chi varchar(45),
ma_loai_khach int,
foreign key(ma_loai_khach) references loai_khach(ma_loai_khach));

select*from khach_hang inner join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach;
select*from khach_hang;

create table kieu_thue(
ma_kieu_thue int primary key auto_increment,
ten_kieu_thue varchar(45));

create table loai_dich_vu(
ma_loai_dich_vu int primary key auto_increment,
ten_loai_dich_vu varchar(45));

create table dich_vu(
ma_dich_vu int primary key auto_increment,
ten_dich_vu varchar(45) not null,
chi_phi_thue double not null,
dien_tich int,
so_nguoi_toi_da int , 
tieu_chuan_phong varchar(45),
mo_ta_tien_nghi_khac varchar(45),
dien_tich_ho_boi double ,
so_tang int, 
ma_kieu_thue int,
ma_loai_dich_vu int,
foreign key(ma_kieu_thue) references kieu_thue(ma_kieu_thue),
foreign key(ma_loai_dich_vu) references loai_dich_vu(ma_loai_dich_vu)
);

create table hop_dong(
ma_hop_dong int primary key auto_increment,
ngay_lam_hop_dong datetime not null,
ngay_ket_thuc datetime not null,
tien_dat_coc double not null,
ma_nhan_vien int,
ma_khach_hang int,
ma_dich_vu int,
foreign key(ma_nhan_vien) references nhan_vien(ma_nhan_vien),
foreign key(ma_khach_hang) references khach_hang(ma_khach_hang),
foreign key(ma_dich_vu) references dich_vu(ma_dich_vu));

create table hop_dong_chi_tiet (
ma_hop_dong_chi_tiet int primary key auto_increment,
so_luong int not null,
ma_hop_dong int,
ma_dich_vu_di_kem int,
foreign key(ma_hop_dong) references hop_dong(ma_hop_dong),
foreign key(ma_dich_vu_di_kem) references dich_vu_di_kem(ma_dich_vu_di_kem)
);
select * from hop_dong;
select * from dich_vu_di_kem;

-- TH??M D??? LI???U
insert into vi_tri values(1,"Qu???n L??"),(2,"Nh??n Vi??n");

insert into trinh_do values 
(1,"Trung C???p"),
(2,"Cao ?????ng"),
(3,"?????i H???c"),
(4,"Sau ?????i H???c");

insert into bo_phan values 
(1,"Sales-Marketing"),
(2,"H??nh Ch??nh"),
(3,"Ph???c V???"),
(4,"Qu???n L??");

insert into nhan_vien values
(1,"Nguy???n V??n An","1970-11-07","456231786",10000000,"0901234121","annguyen@gmail.com","295 Nguy???n T???t Th??nh, ???? N???ng",1,3,1),
(2,"L?? V??n B??nh","1997-04-09","654231234",7000000,"0934212314","binhlv@gmail.com","22 Y??n B??i, ???? N???ng",1,2,2),
(3,"H??? Th??? Y???n","1995-12-12","999231723",14000000,"0412352315","thiyen@gmail.com","K234/11 ??i???n Bi??n Ph???, Gia Lai",1,3,2),
(4,"V?? C??ng To???n","1980-04-04","123231365",17000000,"0374443232","toan0404@gmail.com","77 Ho??ng Di???u, Qu???ng Tr???",1,4,4),
(5,"Nguy???n B???nh Ph??t","1999-12-09","454363232",6000000,"0902341231","phatphat@gmail.com","43 Y??n B??i, ???? N???ng",2,1,1),
(6,"Kh??c Nguy???n An Nghi","2000-11-08","964542311",7000000,"0978653213","annghi20@gmail.com","294 Nguy???n T???t Th??nh, ???? N???ng",2,2,3),
(7,"Nguy???n H???u H??","1993-01-01","534323231",8000000,"0941234553","nhh0101@gmail.com","4 Nguy???n Ch?? Thanh, Hu???",2,3,2),
(8,"Nguy???n H?? ????ng","1989-09-03","234414123",9000000,"0642123111","donghanguyen@gmail.com","111 H??ng V????ng, H?? N???i",2,4,4),
(9,"T??ng Hoang","1982-09-03","256781231",6000000,"0245144444","hoangtong@gmail.com","213 H??m Nghi, ???? N???ng",2,4,4),
(10,"Nguy???n C??ng ?????o","1994-01-08","755434343",8000000,"0988767111","nguyencongdao12@gmail.com","6 Ho?? Kh??nh, ?????ng Nai",2,3,2);

insert into loai_khach values 
(1,"Dinamond"),
(2,"Platinium"),
(3,"Gold"),
(4,"Silver"),
(5,"Member");

insert into khach_hang values 
(1,"Nguy???n Th??? H??o","1970-11-07",0,"643431213","0945423362","thihao07@gmail.com","23 Nguy???n Ho??ng, ???? N???ng",5),
(2,"Ph???m Xu??n Di???u","1992-08-08",1,"865342123","0954333333","xuandieu92@gmail.com","K77/22 Th??i Phi??n, Qu???ng Tr???",3),
(3,"Tr????ng ????nh Ngh???","1990-02-27",1,"488645199","0373213122","nghenhan2702@gmail.com","K323/12 ??ng ??ch Khi??m, Vinh",1),
(4,"D????ng V??n Quan","1981-07-08",1,"543432111","0490039241","duongquan@gmail.com","K453/12 L?? L???i, ???? N???ng",1),
(5,"Ho??ng Tr???n Nhi Nhi","1995-12-09",0,"795453345","0312345678","nhinhi123@gmail.com","224 L?? Th??i T???, Gia Lai",4),
(6,"T??n N??? M???c Ch??u","2005-12-06",0,"732434215","0988888844","tonnuchau@gmail.com","37 Y??n Th???, ???? N???ng",4),
(7,"Nguy???n M??? Kim","1984-04-08",0,"856453123","0912345698","kimcuong84@gmail.com","K123/45 L?? L???i, H??? Ch?? Minh",1),
(9,"Tr???n ?????i Danh","1994-07-01",1,"432341235","0643343433","danhhai99@gmail.com","24 L?? Th?????ng Ki???t, Qu???ng Ng??i",1),
(10,"Nguy???n T??m ?????c","1989-07-01",1,"344343432","0987654321","dactam@gmail.com","22 Ng?? Quy???n, ???? N???ng",2);

insert into kieu_thue values 
(1,"year"),
(2,"month"),
(3,"day"),
(4,"hour");

insert into loai_dich_vu values 
(1,"Villa"),
(2,"House"),
(3,"Room");

insert into dich_vu values 
(1,"Villa Beach Front",25000,10000000,10,"vip","C?? h??? b??i",500,4,3,1),
(2,"House Princess 01",14000,5000000,7,"vip","C?? th??m b???p n?????ng",null,3,2,2),
(3,"Room Twin 01",5000,1000000,2,"normal","C?? tivi",null,null,4,3),
(4,"Villa No Beach Front",22000,9000000,8,"normal","C?? h??? b??i",300,3,3,1),
(5,"House Princess 02",10000,4000000,5,"normal","C?? th??m b???p n?????ng",null,2,3,2),
(6,"Room Twin 02",3000,900000,2,"normal","C?? tivi",null,null,4,3);

insert into dich_vu_di_kem values 
(1,"Karaoke",10000,"gi???","ti???n nghi hi???n t???i"),
(2,"Thu?? xe m??y",10000,"chi???c","h???ng 1 xe"),
(3,"Thu?? xe ?????p",20000,"chi???c","t???t"),
(4,"Buffet bu???i s??ng",15000,"su???t","?????y ????? ????? ??n, tr??ng mi???ng"),
(5,"Buffet bu???i tr??a",90000,"su???t","?????y ????? ????? ??n, tr??ng mi???ng"),
(6,"Buffet bu???i t???i",16000,"su???t","?????y ????? ????? ??n, tr??ng mi???ng");

insert into hop_dong values 
(1,"2020-12-08","2020-12-08",0,3,1,3),
(2,"2020-07-14","2020-07-21",200000,7,3,1),
(3,"2021-03-15","2021-03-17",50000,3,4,2),
(4,"2021-01-14","2021-01-18",100000,7,5,5),
(5,"2021-07-14","2021-07-15",0,7,2,6),
(6,"2021-06-01","2021-06-03",0,7,7,6),
(7,"2021-09-02","2021-09-05",100000,7,4,4),
(8,"2021-06-17","2021-06-18",150000,3,4,1),
(9,"2020-11-19","2020-11-19",0,3,4,3),
(10,"2021-04-12","2021-04-14",0,10,3,5),
(11,"2021-04-25","2021-04-25",0,2,2,1),
(12,"2021-05-25","2021-05-27",0,7,10,1);

insert into hop_dong_chi_tiet values 
(1,5,2,4),
(2,8,2,5),
(3,15,2,6),
(4,1,3,1),
(5,11,3,2),
(6, 1,1	,3),
(7,2,1,2),
(8,2,12,2);

-- 2.	Hi???n th??? th??ng tin c???a t???t c??? nh??n vi??n c?? trong h??? th???ng c?? t??n b???t ?????u l?? m???t trong c??c k?? t??? ???H???, ???T??? ho???c ???K??? v?? c?? t???i ??a 15 k?? t???.

select * from nhan_vien;

select * from nhan_vien where (ho_ten like "H%" or ho_ten like "T%" or ho_ten like "K%") and length(ho_ten) <= 15;

-- 3. 	Hi???n th??? th??ng tin c???a t???t c??? kh??ch h??ng c?? ????? tu???i t??? 18 ?????n 50 tu???i v?? c?? ?????a ch??? ??? ??????? N???ng??? ho???c ???Qu???ng Tr??????.
 
select * from khach_hang;

select * from khach_hang where ((datediff("2021-12-13",khach_hang.ngay_sinh)/365) between 18 and 50)
and dia_chi like "% ???? N??ng" or dia_chi like "% Qu???ng Tr???";

-- 4.?????m xem t????ng ???ng v???i m???i kh??ch h??ng ???? t???ng ?????t ph??ng bao nhi??u l???n.
-- K???t qu??? hi???n th??? ???????c s???p x???p t??ng d???n theo s??? l???n ?????t ph??ng c???a kh??ch h??ng.
-- Ch??? ?????m nh???ng kh??ch h??ng n??o c?? T??n lo???i kh??ch h??ng l?? ???Diamond???.

select * from khach_hang;
select * from loai_khach;
select * from loai_dich_vu;
select * from hop_dong;

select khach_hang.ho_ten as ho_ten_khach_hang, count(hop_dong.ma_hop_dong) as so_lan_dp from khach_hang 
inner join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang 
inner join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach 
where loai_khach.ten_loai_khach = "Dinamond" 
group by khach_hang.ma_khach_hang order by so_lan_dp;


-- 5.	Hi???n th??? ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien 
-- (V???i t???ng ti???n ???????c t??nh theo c??ng th???c nh?? sau: Chi Ph?? Thu?? + S??? L?????ng * Gi??, v???i S??? L?????ng v?? Gi?? l?? t??? b???ng dich_vu_di_kem, hop_dong_chi_tiet)
--  cho t???t c??? c??c kh??ch h??ng ???? t???ng ?????t ph??ng. (nh???ng kh??ch h??ng n??o ch??a t???ng ?????t ph??ng c??ng ph???i hi???n th??? ra).

select khach_hang.ma_khach_hang , khach_hang.ho_ten ,loai_khach.ten_loai_khach ,
 hop_dong.ma_hop_dong , dich_vu.ten_dich_vu , hop_dong.ngay_lam_hop_dong , hop_dong.ngay_ket_thuc,
(chi_phi_thue + (so_luong *gia)) as tong_tien from 
khach_hang left join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach 
left join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang 
left join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu 
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong 
left join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem =hop_dong_chi_tiet.ma_dich_vu_di_kem;
 
 
-- 6.	Hi???n th??? ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu c???a t???t c??? 
-- c??c lo???i d???ch v??? ch??a t???ng ???????c kh??ch h??ng th???c hi???n ?????t t??? qu?? 1 c???a n??m 2021 (Qu?? 1 l?? th??ng 1, 2, 3).

select *from hop_dong;

select dich_vu.ma_dich_vu ,dich_vu.ten_dich_vu ,dich_vu.dien_tich ,dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu 
from dich_vu join loai_dich_vu on loai_dich_vu.ma_loai_dich_vu =dich_vu.ma_loai_dich_vu 
where not exists (select hop_dong.ma_dich_vu from hop_dong where (hop_dong.ngay_lam_hop_dong between "2021-1-1" and "2021-3-31") and hop_dong.ma_dich_vu = dich_vu.ma_dich_vu);

-- 7.	Hi???n th??? th??ng tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, ten_loai_dich_vu 
-- c???a t???t c??? c??c lo???i d???ch v??? ???? t???ng ???????c kh??ch h??ng ?????t ph??ng trong n??m 2020
-- nh??ng ch??a t???ng ???????c kh??ch h??ng ?????t ph??ng trong n??m 2021.

select * from dich_vu;
select * from hop_dong;

select dich_vu.ma_dich_vu , dich_vu.ten_dich_vu , dich_vu.dien_tich , dich_vu.so_nguoi_toi_da , dich_vu.chi_phi_thue,
loai_dich_vu.ten_loai_dich_vu from dich_vu join loai_dich_vu on loai_dich_vu.ma_loai_dich_vu =dich_vu.ma_loai_dich_vu 
where exists(select hop_dong.ma_hop_dong from hop_dong where year(hop_dong.ngay_lam_hop_dong)="2020" and hop_dong.ma_dich_vu = dich_vu.ma_dich_vu) 
and not exists(select hop_dong.ma_hop_dong from hop_dong where year(hop_dong.ngay_lam_hop_dong)="2021" and hop_dong.ma_dich_vu = dich_vu.ma_dich_vu) ;

-- 8.	Hi???n th??? th??ng tin ho_ten kh??ch h??ng c?? trong h??? th???ng, v???i y??u c???u ho_ten kh??ng tr??ng nhau.

select * from khach_hang;

-- c1
select distinct khach_hang.ho_ten from khach_hang;
-- c2 
select khach_hang.ho_ten from khach_hang group by khach_hang.ho_ten;
-- c3 
select khach_hang.ho_ten from khach_hang union select khach_hang.ho_ten from khach_hang;

-- 9.	Th???c hi???n th???ng k?? doanh thu theo th??ng, ngh??a l?? t????ng ???ng v???i m???i th??ng trong n??m 2021 th?? s??? c?? bao nhi??u kh??ch h??ng th???c hi???n ?????t ph??ng.

select * from khach_hang ; 

select month(hop_dong.ngay_lam_hop_dong) as month, count(month(hop_dong.ngay_lam_hop_dong)) as so_khach from khach_hang 
right join hop_dong on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang where hop_dong.ngay_lam_hop_dong like "2021%" 
group by `month`
order by `month`;

-- 10.	Hi???n th??? th??ng tin t????ng ???ng v???i t???ng h???p ?????ng th?? ???? s??? d???ng bao nhi??u d???ch v??? ??i k??m. 
-- K???t qu??? hi???n th??? bao g???m ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, 
-- tien_dat_coc, so_luong_dich_vu_di_kem (???????c t??nh d???a tr??n vi???c sum so_luong ??? dich_vu_di_kem).

select * from hop_dong;
select * from dich_vu_di_kem;
select * from hop_dong_chi_tiet;

select hop_dong.ma_hop_dong , hop_dong.ngay_lam_hop_dong , hop_dong.ngay_ket_thuc , 
hop_dong.tien_dat_coc , sum(hop_dong_chi_tiet.so_luong) as sl_dv_di_kem from 
hop_dong left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong 
left join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem group by hop_dong.ma_hop_dong;

-- 11.	Hi???n th??? th??ng tin c??c d???ch v??? ??i k??m ???? ???????c s??? d???ng b???i nh???ng kh??ch h??ng c?? ten_loai_khach l?? ???Diamond??? v?? c?? dia_chi ??? ???Vinh??? ho???c ???Qu???ng Ng??i???.

select * from dich_vu_di_kem;
select * from loai_khach;
select * from khach_hang;
select * from hop_dong_chi_tiet;

select dich_vu_di_kem.ten_dich_vu_di_kem, dich_vu_di_kem.gia, loai_khach.ten_loai_khach , khach_hang.dia_chi from dich_vu_di_kem 
inner join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem 
inner join hop_dong on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong inner join khach_hang on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang 
inner join loai_khach on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach where loai_khach.ten_loai_khach = "Dinamond"
 and (khach_hang.dia_chi like "%, Vinh" or khach_hang.dia_chi like "%, Qu??ng Ng??i");
 
-- 12. Hi???n th??? th??ng tin ma_hop_dong, ho_ten (nh??n vi??n),
--  ho_ten (kh??ch h??ng), so_dien_thoai (kh??ch h??ng), ten_dich_vu, 
-- so_luong_dich_vu_di_kem (???????c t??nh d???a tr??n vi???c sum so_luong ??? dich_vu_di_kem), 
-- tien_dat_coc c???a t???t c??? c??c d???ch v??? ???? t???ng ???????c kh??ch h??ng ?????t v??o 3 th??ng cu???i n??m 2020 
-- nh??ng ch??a t???ng ???????c kh??ch h??ng ?????t v??o 6 th??ng ?????u n??m 2021.

select * from khach_hang;
select * from dich_vu;

select hop_dong.ma_hop_dong, nhan_vien.ho_ten , khach_hang.ho_ten , khach_hang.so_dien_thoai, dich_vu.ten_dich_vu , sum(hop_dong_chi_tiet.so_luong) as so_luong_dv_di_kem , hop_dong.tien_dat_coc from 
nhan_vien join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien 
inner join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
inner join khach_hang on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang 
inner join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong where exists (select hop_dong.ma_hop_dong where hop_dong.ngay_lam_hop_dong between "2020-10-1" and "2020-12-31")
and not exists (select hop_dong.ma_hop_dong where hop_dong.ngay_lam_hop_dong between "2021-1-1" and "2021-6-30") ; 

