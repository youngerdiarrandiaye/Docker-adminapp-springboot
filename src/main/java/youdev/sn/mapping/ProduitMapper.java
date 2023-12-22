package youdev.sn.mapping;

import org.mapstruct.Mapper;
import youdev.sn.dto.ProduitDto;
import youdev.sn.entities.ProduitEntity;


@Mapper
public interface ProduitMapper {
    ProduitDto toProduitDto(ProduitEntity produitEntity);
    ProduitEntity fromProduitDto(ProduitDto produitDto);
}
