create procedure find_artist (in inTitle varchar(50), out oArtist varchar(30))
select artist from compact_discs
where title = inTitle
into oArtist;