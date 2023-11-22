package ng.edu.binghamuni.inventory.sevices;

import ng.edu.binghamuni.inventory.domain.Drink;
import ng.edu.binghamuni.inventory.repository.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrinkServiceImpl implements DrinkService{

    @Autowired
    DrinkRepository drinkRepository;
    @Override
    public Drink saveDrink(Drink drink) {
        return drinkRepository.save(Drink);

    }

    @Override
    public Drink getDrinkById(long id) {
        Optional<Drink> drink = return drinkRepository.findById(id);

        Drink emptyDrink = null;
        if (drink.isEmpty()){
            emptyDrink = drink.get();
            return emptyDrink;
        }else {
            throw new RuntimeException("Drink not found");
        }

    }

    @Override
    public List<Drink> getAllDrink() {
        return null;
    }


    @Override
    public Drink updateDrink(Drink drink) {
        Drink drink;
        Optional<Drink>  optionalDrink = drinkRepository.findById(drink.getId());

        if (optionalDrink.isPresent()){
            Drink updateDrink = new Drink();
            updateDrink.setCapacity(drink.getCapacity());
            updateDrink.setColor(drink.getColor());
            updateDrink.setCompany(drink.getCompany());
            updateDrink.setName(drink.getName());
            updateDrink.setType(drink.getType());
            updateDrink.setId(drink.getId());
            updateDrink.setIngredientList(drink.getIngredientList());

            drinkRepository.save(updateDrink);
        }else {
            throw new RuntimeException("Drink does not exist")
        }
    }

    @Override
    public void deleteDrink(long id){
        drinkRepository.deleteById(id);
    }
}
