/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  developpeur
 * Created: 30 nov. 2020
 */

-- Question3
 select * from Visiteur inner join Travailler on Visiteur.vis_matricule=Travailler.vis_matricule where tra_role='Délégué';
-- Question4
select *  from Travailler inner join Visiteur on Travailler.vis_matricule=Visiteur.vis_matricule  where tra_role='Délégué' and jjmmaa=(select max(jjmmaa) from Travailler where Travailler.vis_matricule=Visiteur.vis_matricule);

--Question5
select *  from Travailler inner join Visiteur on Travailler.vis_matricule=Visiteur.vis_matricule  where tra_role='Délégué' and jjmmaa=(select max(jjmmaa) from Travailler where Travailler.vis_matricule=Visiteur.vis_matricule);

