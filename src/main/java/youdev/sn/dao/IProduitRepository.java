package youdev.sn.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import youdev.sn.entities.ProduitEntity;

public interface IProduitRepository extends JpaRepository<ProduitEntity, Integer> {
}
