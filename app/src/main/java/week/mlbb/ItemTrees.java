package week.mlbb;

import java.util.HashMap;
import java.util.Map;

public class ItemTrees {
    private static ItemMechanism.ItemNode copyItem(String key, Map<String, ItemMechanism.ItemNode> dict) {
    ItemMechanism.ItemNode template = dict.get(key);
    if (template == null) return null;
    ItemMechanism.ItemNode newNode = new ItemMechanism.ItemNode(template.name, template.note);

    for (ItemMechanism.ItemNode child : template.children) {
        ItemMechanism.ItemNode childCopy = new ItemMechanism.ItemNode(child.name, child.note);
        newNode.addChild(childCopy);
    }
    
    return newNode; }
    public static ItemMechanism.ItemNode buildRecipeTree() {
        Map<String, ItemMechanism.ItemNode> dict = new HashMap<>();
        // 1. Basic Components
        dict.put("Dagger", new ItemMechanism.ItemNode("Dagger", "+15 Phys Attack"));
        dict.put("Vitality", new ItemMechanism.ItemNode("Vitality Crystal", "+230 HP"));
        dict.put("Javelin", new ItemMechanism.ItemNode("Javelin", "+8% Crit Chance"));
        dict.put("Necklace", new ItemMechanism.ItemNode("Magic Necklace", "+2 Mana Regen"));
        dict.put("Knife", new ItemMechanism.ItemNode("Knife", "+10% Attack Speed"));
        dict.put("Mallet", new ItemMechanism.ItemNode("Vampire Mallet", "+8% Lifesteal"));
        dict.put("Iron Hunting Bow", new ItemMechanism.ItemNode("Iron Hunting Bow", "+10 Phys Attack & 5% CDR"));
        dict.put("Expert Gloves", new ItemMechanism.ItemNode("Expert Gloves", "+30 Adaptive Attack"));
        dict.put("Ring", new ItemMechanism.ItemNode("Hero's Ring", "+150 HP & 5% CDR"));
        dict.put("LeatherArmor", new ItemMechanism.ItemNode("Leather Armor", "+15 Physical Defense"));

        // 2. Intermediate
        dict.put("Legion", new ItemMechanism.ItemNode("Legion Sword", "+60 Phys Attack"));
        dict.put("Regular Spear", new ItemMechanism.ItemNode("Regular Spear", "20 Physical Attack & 10% Attack Speed"));
        dict.put("Rogue", new ItemMechanism.ItemNode("Rogue Meteor", "15% Attack Speed & 10% Crit Chance"));
        dict.put("Ogre", new ItemMechanism.ItemNode("Ogre Tomahawk", "+30 Phys Attack, +230 HP"));
        dict.put("Magic Blade", new ItemMechanism.ItemNode("Magic Blade", "+10% Lifesteal, +35 Physical Attack, Shield on Low"));
        dict.put("Crossbow", new ItemMechanism.ItemNode("Swift Crossbow", "+20% Attack Speed"));
        dict.put("Azure", new ItemMechanism.ItemNode("Azure Blade", "True DMG"));
        dict.put("FuryHammer", new ItemMechanism.ItemNode("Fury Hammer", "+12 Physical Pen"));
        dict.put("AresBelt", new ItemMechanism.ItemNode("Ares Belt", "+600 HP"));


        // 3. Final Items
        dict.put("EB", new ItemMechanism.ItemNode("Endless Battle", "Lifesteal & True Damage"));
        dict.put("BOD", new ItemMechanism.ItemNode("Blade of Despair", "Max Damage"));
        dict.put("Berserker", new ItemMechanism.ItemNode("Berserker's Fury", "Crit DMG"));
        dict.put("Malefic Gun", new ItemMechanism.ItemNode("Malefic Gun", "Shred Armor & Basic ATK Increase"));
        dict.put("Great Dragon Spear", new ItemMechanism.ItemNode("Great Dragon Spear", "Crit Chance & Mov Speed on Ultimate"));
        dict.put("Sea Halberd", new ItemMechanism.ItemNode("Sea Halberd", "ATKS & Antiheal"));
        dict.put("Rose Gold Meteor", new ItemMechanism.ItemNode("Rose Gold Meteor", "Shield on Low HP"));
        dict.put("Hunter Strike", new ItemMechanism.ItemNode("Hunter Strike", "Mov Speed on concecutive damage"));
        dict.put("BOH", new ItemMechanism.ItemNode("Blade of the Heptaseas", "Ambush Damage"));
        dict.put("Windtalker", new ItemMechanism.ItemNode("Windtalker", "Mov Speed and Crit Chance"));
        dict.put("Haas Claw", new ItemMechanism.ItemNode("Haa's Claws", "Lifesteal & Crit"));
        dict.put("Malefic Roar", new ItemMechanism.ItemNode("Malefic Roar", "Massive Penetration"));
        dict.put("Winter Crown", new ItemMechanism.ItemNode("Winter Crown", "Freeze on Usage"));
        dict.put("Fleeting Time", new ItemMechanism.ItemNode("Fleeting Time", "Ultimate Cooldown Reduction per Kill/Assist"));
        dict.put("Sky Piercer", new ItemMechanism.ItemNode("Sky Piercer", "Execute Low HP Heroes"));
        dict.put("War Axe", new ItemMechanism.ItemNode("War Axe", "Surviveability and Damage"));
        dict.put("Wind of Nature", new ItemMechanism.ItemNode("Wind of Nature", "Physical Damage Immunity on Cast"));
        dict.put("Golden Staff", new ItemMechanism.ItemNode("Golden Staff", "Multiplies Basic Attack Instance"));
        dict.put("Corrosion Scythe", new ItemMechanism.ItemNode("Corrosion Scythe", "Attack Speed & Mov Speed Debuff"));
        dict.put("DHS", new ItemMechanism.ItemNode("Demon Hunter Sword", "Extra 8% of Enemy Current HP per Hit"));
        dict.put("Immortality", new ItemMechanism.ItemNode("Immortality", "Resurrect"));
        dict.put("Ultimate", new ItemMechanism.ItemNode("Ultimate Item", "The Ultimate Item with all the best stats"));

        // --- LINKING ---

        // Small Items
        // --- 1. INTERMEDIATE ITEM LINKING (TIER 2) ---
        // Azure Blade: Requires 2 Magic Necklaces
        ItemMechanism.ItemNode azure = dict.get("Azure");
        azure.addChild(dict.get("Necklace"));
        azure.addChild(copyItem("Necklace", dict));

        // Ogre Tomahawk: Requires 1 Dagger, 1 Vitality Crystal
        ItemMechanism.ItemNode ogre = dict.get("Ogre");
        ogre.addChild(dict.get("Dagger"));
        ogre.addChild(dict.get("Vitality"));

        // Legion Sword: Requires 2 Daggers
        ItemMechanism.ItemNode legion = dict.get("Legion");
        legion.addChild(dict.get("Dagger"));
        legion.addChild(copyItem("Dagger", dict));

        // Magic Blade: Requires 1 Dagger, 1 Vampire Mallet
        ItemMechanism.ItemNode magicBlade = dict.get("Magic Blade");
        magicBlade.addChild(dict.get("Dagger"));
        magicBlade.addChild(dict.get("Mallet"));

        // Rogue Meteor: Requires 1 Knife, 1 Javelin
        ItemMechanism.ItemNode rogue = dict.get("Rogue");
        rogue.addChild(dict.get("Knife"));
        rogue.addChild(dict.get("Javelin"));

        // Regular Spear: Requires 1 Dagger, 1 Knife
        ItemMechanism.ItemNode spear = dict.get("Regular Spear");
        spear.addChild(dict.get("Dagger"));
        spear.addChild(dict.get("Knife"));

        // Swift Crossbow: Requires 2 Knife
        ItemMechanism.ItemNode crossbow = dict.get("Crossbow");
        crossbow.addChild(dict.get("Knife"));
        crossbow.addChild(copyItem("Knife", dict));

        // Fury Hammer: Requires 2 Daggers
        ItemMechanism.ItemNode furyHammer = dict.get("FuryHammer");
        furyHammer.addChild(dict.get("Dagger"));

        // Ares Belt requires Vitality Crystal
        ItemMechanism.ItemNode aresBelt = dict.get("AresBelt");
        aresBelt.addChild(dict.get("Vitality"));

        // Big Bois Items
        // --- 2. FINAL ITEM LINKING (TIER 3) ---
        // 1. Endless Battle (EB)
        ItemMechanism.ItemNode eb = dict.get("EB");
        eb.addChild(dict.get("Azure"));
        eb.addChild(dict.get("Iron Hunting Bow"));
        eb.addChild(dict.get("Mallet"));

        // 2. Blade of Despair (BOD)
        ItemMechanism.ItemNode bod = dict.get("BOD");
        bod.addChild(dict.get("Legion"));
        bod.addChild(copyItem("Legion", dict));

        // 3. Berserker's Fury (Berserker)
        ItemMechanism.ItemNode berserker = dict.get("Berserker");
        berserker.addChild(dict.get("Legion"));
        berserker.addChild(dict.get("Javelin"));
        berserker.addChild(copyItem("Javelin", dict));

        // 4. Rose Gold Meteor (Rose Gold Meteor)
        ItemMechanism.ItemNode roseGold = dict.get("Rose Gold Meteor");
        roseGold.addChild(dict.get("Magic Blade"));
        roseGold.addChild(dict.get("Knife"));

        // 5. Hunter Strike (Hunter Strike)
        ItemMechanism.ItemNode hunter = dict.get("Hunter Strike");
        hunter.addChild(dict.get("FuryHammer"));
        hunter.addChild(dict.get("Iron Hunting Bow"));
        hunter.addChild(dict.get("Dagger"));

        // 6. Blade of the Heptaseas (BOH)
        ItemMechanism.ItemNode boh = dict.get("BOH");
        boh.addChild(dict.get("FuryHammer"));
        boh.addChild(dict.get("Ogre"));

        // 7. Sea Halberd (Sea Halberd)
        ItemMechanism.ItemNode seaHalberd = dict.get("Sea Halberd");
        seaHalberd.addChild(dict.get("Regular Spear"));
        seaHalberd.addChild(dict.get("Legion"));

        // 8. Malefic Roar (Malefic Roar)
        ItemMechanism.ItemNode maleficRoar = dict.get("Malefic Roar");
        maleficRoar.addChild(dict.get("Legion"));

        // 9. Windtalker (Windtalker)
        ItemMechanism.ItemNode windtalker = dict.get("Windtalker");
        windtalker.addChild(dict.get("Rogue"));
        windtalker.addChild(dict.get("Knife"));

        // 10. Haas Claw (Haas Claw)
        ItemMechanism.ItemNode haas = dict.get("Haas Claw");
        haas.addChild(dict.get("Rogue"));
        haas.addChild(dict.get("Mallet"));
        haas.addChild(dict.get("Dagger"));

        // 11. Demon Hunter Sword (DHS)
        ItemMechanism.ItemNode dhs = dict.get("DHS");
        dhs.addChild(dict.get("Regular Spear"));
        dhs.addChild(dict.get("Mallet"));
        dhs.addChild(dict.get("Knife"));

        // 12. Corrosion Scythe (Corrosion Scythe)
        ItemMechanism.ItemNode corrosion = dict.get("Corrosion Scythe");
        corrosion.addChild(dict.get("Crossbow"));
        corrosion.addChild(dict.get("Regular Spear"));

        // 13. Golden Staff (Golden Staff)
        ItemMechanism.ItemNode golden = dict.get("Golden Staff");
        golden.addChild(dict.get("Regular Spear"));
        golden.addChild(dict.get("Dagger"));
        golden.addChild(copyItem("Dagger", dict));

        // 14. Malefic Gun (Malefic Gun)
        ItemMechanism.ItemNode maleficGun = dict.get("Malefic Gun");
        maleficGun.addChild(dict.get("FuryHammer"));
        maleficGun.addChild(dict.get("Knife"));
        maleficGun.addChild(copyItem("Knife", dict));

        // 15. Great Dragon Spear (Great Dragon Spear)
        ItemMechanism.ItemNode gds = dict.get("Great Dragon Spear");
        gds.addChild(dict.get("Legion"));
        gds.addChild(dict.get("Iron Hunting Bow"));
        gds.addChild(dict.get("Javelin"));

        // 16. War Axe (War Axe)
        ItemMechanism.ItemNode warAxe = dict.get("War Axe");
        warAxe.addChild(dict.get("Ogre"));
        warAxe.addChild(dict.get("Iron Hunting Bow"));
        warAxe.addChild(dict.get("Ring"));

        // 17. Sky Piercer 
        ItemMechanism.ItemNode skyPiercer = dict.get("Sky Piercer");
        skyPiercer.addChild(dict.get("Expert Gloves"));
        skyPiercer.addChild(copyItem("Expert Gloves", dict));

        // 18. Wind of Nature (Wind of Nature)
        ItemMechanism.ItemNode won = dict.get("Wind of Nature");
        won.addChild(dict.get("Regular Spear"));
        won.addChild(dict.get("Mallet"));

        // 19. Fleeting Time (Fleeting Time)
        ItemMechanism.ItemNode fleetingTime = dict.get("Fleeting Time");
        fleetingTime.addChild(dict.get("Ring"));
        fleetingTime.addChild(copyItem("Ring", dict));
        fleetingTime.addChild(dict.get("Expert Gloves"));

        // 20. Winter Crown (Winter Crown)
        ItemMechanism.ItemNode winterCrown = dict.get("Winter Crown");
        winterCrown.addChild(dict.get("Ring"));
        winterCrown.addChild(dict.get("Vitality"));
        winterCrown.addChild(dict.get("Expert Gloves"));

        // 21. Immortality (Immortality)
        ItemMechanism.ItemNode immortality = dict.get("Immortality");
        immortality.addChild(dict.get("AresBelt"));
        immortality.addChild(dict.get("LeatherArmor"));

        // 22. The Ultimate Item
        ItemMechanism.ItemNode ultimateItem = dict.get("Ultimate");
        ultimateItem.addChild(dict.get("BOD"));
        ultimateItem.addChild(dict.get("EB"));
        ultimateItem.addChild(dict.get("Berserker"));
        ultimateItem.addChild(dict.get("Rose Gold Meteor"));

        ItemMechanism.ItemNode root = new ItemMechanism.ItemNode("Start Build", "Physical Attack Tree");
        root.addChild(eb);
        root.addChild(bod);
        root.addChild(berserker);
        root.addChild(roseGold);
        root.addChild(hunter);
        root.addChild(boh);
        root.addChild(seaHalberd);
        root.addChild(maleficRoar);
        root.addChild(windtalker);
        root.addChild(haas);
        root.addChild(dhs);
        root.addChild(corrosion);
        root.addChild(golden);
        root.addChild(maleficGun);
        root.addChild(gds);
        root.addChild(warAxe);
        root.addChild(skyPiercer);
        root.addChild(won);
        root.addChild(fleetingTime);
        root.addChild(winterCrown);
        root.addChild(immortality);
        root.addChild(ultimateItem);
        return root;
    }
}