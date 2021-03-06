package me.TahaCheji.itemData;

import me.TahaCheji.gameData.GamePlayer;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MasterAbility {

    private final String name;
    private final List<String> description;
    private final AbilityType type;
    private final int manaCost;
    private int abilityDamage;

    public MasterAbility(String name, AbilityType type, int manaCost, int damage, String... description) {
        this.name = name;
        this.description = Arrays.asList(description);
        this.type = type;
        this.manaCost = manaCost;
        this.abilityDamage = damage;
    }

    public List<String> toLore(GamePlayer gamePlayer) {
        List<String> lore = new ArrayList();
        lore.add(ChatColor.GOLD + "Item Ability: " + this.name + " " + ChatColor.GOLD + ChatColor.DARK_GREEN + "[" +  this.type.getText() + "]");
        if(abilityDamage == 0) {
            lore.add(ChatColor.RED + "Ability Damage: " + abilityDamage + ChatColor.DARK_GRAY + " | " + ChatColor.AQUA + "ManaCost: " + manaCost);
        } else {
            lore.add(ChatColor.RED + "Ability Damage: " + abilityDamage + ChatColor.DARK_GRAY + " [+ " + gamePlayer.getLevels().getLevel() / 2 + "]" + " | " + ChatColor.AQUA + "ManaCost: " + manaCost);
        }
        lore.add("");
        for(String string : description) {
            lore.add(ChatColor.DARK_GRAY + string);
        }
        return lore;
    }

    public void setAbilityDamage(int abilityDamage) {
        this.abilityDamage = abilityDamage;
    }

    public String getName() {
        return name;
    }

    public List<String> getDescription() {
        return description;
    }

    public AbilityType getType() {
        return type;
    }

    public int getManaCost() {
        return manaCost;
    }

    public int getAbilityDamage() {
        return abilityDamage;
    }
}
