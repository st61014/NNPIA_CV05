package cz.upce.fei.NNPIA_CV05.graphql;

import cz.upce.fei.NNPIA_CV05.dto.AppUserInputQLDto;
import cz.upce.fei.NNPIA_CV05.dto.AppUserResponseDtoV1;
import cz.upce.fei.NNPIA_CV05.service.AppUserService;
import cz.upce.fei.NNPIA_CV05.service.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
//N+1 je problém tažení dat z databáze s dotazem na entity vztažené k jinému objektu (např. objekt Auto má odkaz na objekty Pneu, čím více aut tím více dotazů pro jednotlivé pneu)
//@BatchMapping je pro metodu která na vstupu příjímá List objektů a vrací Map jednotlivých objektů a jejich vztažených entit, takto se vyhneme posílání nového dotazu pro každý objekt
//@SchemaMapping je anotace pro metodu která připraví všechny data postupně, ale zavolá dotaz pouze jednou

//GraphQL subscription je funkcionalita graphql, která umožňuje serveru poslat data klientu když nastane určitá situace
//příjemce je klient, odesílatel je server
//používá se @SubscriptionMapping
//nový post na sociálních sítí, klient se nedotazuje pořád na nová data, když je server má rovnou je pošle
//periodické posílání dat, která se mohou měnit průběhem času, například změna kurzu mezi měnami
//websocket je způsob vytvoření a udržování subscribtion, toto spojení lze kdykoliv ukončit, grahpql subscr. přes websocket komunikuje a posílá data
@Controller
@AllArgsConstructor
public class AppUserQLController {
    private final AppUserService appUserService;

    @QueryMapping
    public AppUserResponseDtoV1 appUser(@Argument Long id) throws ResourceNotFoundException {
        return appUserService.findById(id).toDto();
    }

    @MutationMapping
    public AppUserResponseDtoV1 createAppUser(@Argument AppUserInputQLDto appUser) {
        return appUserService.create(appUser.toEntity())
                .toDto();
    }
}
