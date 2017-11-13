package me.plumstar.territorywars.events;

import org.bukkit.event.Listener;

public class PlayerInteractEntity implements Listener {

	/*@EventHandler
    public void onEntityInteract(PlayerInteractEntityEvent e) {
		Player p = (Player) e.getPlayer();
		if (e.getRightClicked().getType() == EntityType.VILLAGER) {
			Villager entity = (Villager) e.getRightClicked();
			if (entity.getCustomName().equals(ChatColor.GOLD + "Shop Keeper Isaac")) {
				Inventory shopPG1 = Bukkit.createInventory(null, 54, ChatColor.GOLD + "Shop Keeper Isaac - Page 1");
	
				ItemStack diaHelm = new ItemStack(Material.DIAMOND_HELMET);
				ItemMeta diaHelmMeta = diaHelm.getItemMeta();
				ArrayList<String> diaHelmLore = new ArrayList<String>();
				diaHelmLore.add(ChatColor.GOLD + "Purchase: 7 Gold");
				diaHelmMeta.setLore(diaHelmLore);
				diaHelm.setItemMeta(diaHelmMeta);
				shopPG1.setItem(0, diaHelm);
	
				ItemStack ironHelm = new ItemStack(Material.IRON_HELMET);
				ItemMeta ironHelmMeta = ironHelm.getItemMeta();
				ArrayList<String> ironHelmLore = new ArrayList<String>();
				ironHelmLore.add(ChatColor.GOLD + "Purchase: 7 Iron");
				ironHelmMeta.setLore(ironHelmLore);
				ironHelm.setItemMeta(ironHelmMeta);
				shopPG1.setItem(2, ironHelm);
	
				ItemStack chainHelm = new ItemStack(Material.CHAINMAIL_HELMET);
				ItemMeta chainHelmMeta = chainHelm.getItemMeta();
				ArrayList<String> chainHelmLore = new ArrayList<String>();
				chainHelmLore.add(ChatColor.GOLD + "Purchase: 7 Coal");
				chainHelmMeta.setLore(chainHelmLore);
				chainHelm.setItemMeta(chainHelmMeta);
				shopPG1.setItem(4, chainHelm);
	
				ItemStack leatherHelm = new ItemStack(Material.LEATHER_HELMET);
				ItemMeta leatherHelmMeta = leatherHelm.getItemMeta();
				ArrayList<String> leatherHelmLore = new ArrayList<String>();
				leatherHelmLore.add(ChatColor.GOLD + "Purchase: 7 Leather");
				leatherHelmMeta.setLore(leatherHelmLore);
				leatherHelm.setItemMeta(leatherHelmMeta);
				shopPG1.setItem(6, leatherHelm);
	
				ItemStack diaChestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
				ItemMeta diaChestplateMeta = diaChestplate.getItemMeta();
				ArrayList<String> diaChestplateLore = new ArrayList<String>();
				diaChestplateLore.add(ChatColor.GOLD + "Purchase: 10 Gold");
				diaChestplateMeta.setLore(diaChestplateLore);
				diaChestplate.setItemMeta(diaChestplateMeta);
				shopPG1.setItem(9, diaChestplate);
	
				ItemStack ironChestplate = new ItemStack(Material.IRON_CHESTPLATE);
				ItemMeta ironChestplateMeta = ironChestplate.getItemMeta();
				ArrayList<String> ironChestplateLore = new ArrayList<String>();
				ironChestplateLore.add(ChatColor.GOLD + "Purchase: 10 Iron");
				ironChestplateMeta.setLore(ironChestplateLore);
				ironChestplate.setItemMeta(ironChestplateMeta);
				shopPG1.setItem(11, ironChestplate);
	
				ItemStack chainChestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
				ItemMeta chainChestplateMeta = chainChestplate.getItemMeta();
				ArrayList<String> chainChestplateLore = new ArrayList<String>();
				chainChestplateLore.add(ChatColor.GOLD + "Purchase: 10 Coal");
				chainChestplateMeta.setLore(chainChestplateLore);
				chainChestplate.setItemMeta(chainChestplateMeta);
				shopPG1.setItem(13, chainChestplate);
	
				ItemStack leatherChestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
				ItemMeta leatherChestplateMeta = leatherChestplate.getItemMeta();
				ArrayList<String> leatherChestplateLore = new ArrayList<String>();
				leatherChestplateLore.add(ChatColor.GOLD + "Purchase: 10 Leather");
				leatherChestplateMeta.setLore(leatherChestplateLore);
				leatherChestplate.setItemMeta(leatherChestplateMeta);
				shopPG1.setItem(15, leatherChestplate);
	
				ItemStack diaLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
				ItemMeta diaLeggingsMeta = diaLeggings.getItemMeta();
				ArrayList<String> diaLeggingsLore = new ArrayList<String>();
				diaLeggingsLore.add(ChatColor.GOLD + "Purchase: 9 Gold");
				diaLeggingsMeta.setLore(diaLeggingsLore);
				diaLeggings.setItemMeta(diaLeggingsMeta);
				shopPG1.setItem(18, diaLeggings);
	
				ItemStack ironLeggings = new ItemStack(Material.IRON_LEGGINGS);
				ItemMeta ironLeggingsMeta = ironLeggings.getItemMeta();
				ArrayList<String> ironLeggingsLore = new ArrayList<String>();
				ironLeggingsLore.add(ChatColor.GOLD + "Purchase: 9 Iron");
				ironLeggingsMeta.setLore(ironLeggingsLore);
				ironLeggings.setItemMeta(ironLeggingsMeta);
				shopPG1.setItem(20, ironLeggings);
	
				ItemStack chainLeggings = new ItemStack(Material.CHAINMAIL_LEGGINGS);
				ItemMeta chainLeggingsMeta = chainLeggings.getItemMeta();
				ArrayList<String> chainLeggingsLore = new ArrayList<String>();
				chainLeggingsLore.add(ChatColor.GOLD + "Purchase: 9 Coal");
				chainLeggingsMeta.setLore(chainLeggingsLore);
				chainLeggings.setItemMeta(chainLeggingsMeta);
				shopPG1.setItem(22, chainLeggings);
	
				ItemStack leatherLeggings = new ItemStack(Material.LEATHER_LEGGINGS);
				ItemMeta leatherLeggingsMeta = leatherLeggings.getItemMeta();
				ArrayList<String> leatherLeggingsLore = new ArrayList<String>();
				leatherLeggingsLore.add(ChatColor.GOLD + "Purchase: 9 Leather");
				leatherLeggingsMeta.setLore(leatherLeggingsLore);
				leatherLeggings.setItemMeta(leatherLeggingsMeta);
				shopPG1.setItem(24, leatherLeggings);
	
				ItemStack diaBoots = new ItemStack(Material.DIAMOND_BOOTS);
				ItemMeta diaBootsMeta = diaBoots.getItemMeta();
				ArrayList<String> diaBootsLore = new ArrayList<String>();
				diaBootsLore.add(ChatColor.GOLD + "Purchase: 6 Gold");
				diaBootsMeta.setLore(diaBootsLore);
				diaBoots.setItemMeta(diaBootsMeta);
				shopPG1.setItem(27, diaBoots);
	
				ItemStack ironBoots = new ItemStack(Material.IRON_BOOTS);
				ItemMeta ironBootsMeta = ironBoots.getItemMeta();
				ArrayList<String> ironBootsLore = new ArrayList<String>();
				ironBootsLore.add(ChatColor.GOLD + "Purchase: 6 Iron");
				ironBootsMeta.setLore(ironBootsLore);
				ironBoots.setItemMeta(ironBootsMeta);
				shopPG1.setItem(29, ironBoots);
	
				ItemStack chainBoots = new ItemStack(Material.CHAINMAIL_BOOTS);
				ItemMeta chainBootsMeta = chainBoots.getItemMeta();
				ArrayList<String> chainBootsLore = new ArrayList<String>();
				chainBootsLore.add(ChatColor.GOLD + "Purchase: 6 Coal");
				chainBootsMeta.setLore(chainBootsLore);
				chainBoots.setItemMeta(chainBootsMeta);
				shopPG1.setItem(31, chainBoots);
	
				ItemStack leatherBoots = new ItemStack(Material.LEATHER_BOOTS);
				ItemMeta leatherBootsMeta = leatherBoots.getItemMeta();
				ArrayList<String> leatherBootsLore = new ArrayList<String>();
				leatherBootsLore.add(ChatColor.GOLD + "Purchase: 6 Leather");
				leatherBootsMeta.setLore(leatherBootsLore);
				leatherBoots.setItemMeta(leatherBootsMeta);
				shopPG1.setItem(33, leatherBoots);
	
				ItemStack bow = new ItemStack(Material.BOW);
				ItemMeta bowMeta = bow.getItemMeta();
				ArrayList<String> bowLore = new ArrayList<String>();
				bowLore.add(ChatColor.GOLD + "Purchase: 6 Wood");
				bowMeta.setLore(bowLore);
				bow.setItemMeta(bowMeta);
				shopPG1.setItem(36, bow);
				shopPG1.setItem(38, bow);
				shopPG1.setItem(40, bow);
				shopPG1.setItem(42, bow);
	
				ItemStack diaSword = new ItemStack(Material.DIAMOND_SWORD);
				ItemMeta diaSwordMeta = diaSword.getItemMeta();
				ArrayList<String> diaSwordLore = new ArrayList<String>();
				diaSwordLore.add(ChatColor.GOLD + "Purchase: 4 Gold");
				diaSwordMeta.setLore(diaSwordLore);
				diaSword.setItemMeta(diaSwordMeta);
				shopPG1.setItem(45, diaSword);
	
				ItemStack arrow64 = new ItemStack(Material.ARROW);
				ItemMeta arrow64Meta = arrow64.getItemMeta();
				ArrayList<String> arrow64Lore = new ArrayList<String>();
				arrow64Lore.add(ChatColor.GOLD + "Purchase: 12 Wood");
				arrow64Meta.setLore(arrow64Lore);
				arrow64.setItemMeta(arrow64Meta);
				arrow64.setAmount(64);
				shopPG1.setItem(46, arrow64);
	
				ItemStack arrow32 = new ItemStack(Material.ARROW);
				ItemMeta arrow32Meta = arrow32.getItemMeta();
				ArrayList<String> arrow32Lore = new ArrayList<String>();
				arrow32Lore.add(ChatColor.GOLD + "Purchase: 6 Wood");
				arrow32Meta.setLore(arrow32Lore);
				arrow32.setItemMeta(arrow32Meta);
				arrow32.setAmount(32);
				shopPG1.setItem(48, arrow32);
	
				ItemStack arrow16 = new ItemStack(Material.ARROW);
				ItemMeta arrow16Meta = arrow16.getItemMeta();
				ArrayList<String> arrow16Lore = new ArrayList<String>();
				arrow16Lore.add(ChatColor.GOLD + "Purchase: 4 Wood");
				arrow16Meta.setLore(arrow16Lore);
				arrow16.setItemMeta(arrow16Meta);
				arrow16.setAmount(16);
				shopPG1.setItem(50, arrow16);
	
				ItemStack arrow8 = new ItemStack(Material.ARROW);
				ItemMeta arrow8Meta = arrow8.getItemMeta();
				ArrayList<String> arrow8Lore = new ArrayList<String>();
				arrow8Lore.add(ChatColor.GOLD + "Purchase: 2 Wood");
				arrow8Meta.setLore(arrow8Lore);
				arrow8.setItemMeta(arrow8Meta);
				arrow8.setAmount(8);
				shopPG1.setItem(52, arrow8);
	
				ItemStack ironSword = new ItemStack(Material.IRON_SWORD);
				ItemMeta ironSwordMeta = ironSword.getItemMeta();
				ArrayList<String> ironSwordLore = new ArrayList<String>();
				ironSwordLore.add(ChatColor.GOLD + "Purchase: 4 Iron");
				ironSwordMeta.setLore(ironSwordLore);
				ironSword.setItemMeta(ironSwordMeta);
				shopPG1.setItem(47, ironSword);
	
				ItemStack stoneSword = new ItemStack(Material.STONE_SWORD);
				ItemMeta stoneSwordMeta = stoneSword.getItemMeta();
				ArrayList<String> stoneSwordLore = new ArrayList<String>();
				stoneSwordLore.add(ChatColor.GOLD + "Purchase: 4 Coal");
				stoneSwordMeta.setLore(stoneSwordLore);
				stoneSword.setItemMeta(stoneSwordMeta);
				shopPG1.setItem(49, stoneSword);
	
				ItemStack woodSword = new ItemStack(Material.WOOD_SWORD);
				ItemMeta woodSwordMeta = woodSword.getItemMeta();
				ArrayList<String> woodSwordLore = new ArrayList<String>();
				woodSwordLore.add(ChatColor.GOLD + "Purchase: 4 Wood");
				woodSwordMeta.setLore(woodSwordLore);
				woodSword.setItemMeta(woodSwordMeta);
				shopPG1.setItem(51, woodSword);
				
				ItemStack emeraldBlock = new ItemStack(Material.EMERALD_BLOCK);
				ItemMeta emeraldBlockMeta = emeraldBlock.getItemMeta();
				ArrayList<String> emeraldBlockLore = new ArrayList<String>();
				emeraldBlockLore.add(ChatColor.GOLD + "Go to the next page of Isaac.");
				emeraldBlockMeta.setDisplayName(ChatColor.DARK_GREEN + "Next Page");
				emeraldBlockMeta.setLore(emeraldBlockLore);
				emeraldBlock.setItemMeta(emeraldBlockMeta);
				shopPG1.setItem(53, emeraldBlock);
	
				e.setCancelled(true);
				p.openInventory(shopPG1);
			}
		}
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		if (e.getClickedInventory().getName().equals(ChatColor.GOLD + "Shop Keeper Isaac - Page 1")) {
			if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_GREEN + "Next Page")) {
				Inventory shopPG2 = Bukkit.createInventory(null, 54, ChatColor.GOLD + "Shop Keeper Isaac - Page 2");
				
				ItemStack woodShovel = new ItemStack(Material.WOOD_SPADE);
				ItemMeta woodShovelMeta = woodShovel.getItemMeta();
				ArrayList<String> woodShovelLore = new ArrayList<String>();
				woodShovelLore.add(ChatColor.GOLD + "Purchase: 3 Wood");
				woodShovelMeta.setLore(woodShovelLore);
				woodShovel.setItemMeta(woodShovelMeta);
				shopPG2.setItem(0, woodShovel);
				
				ItemStack stoneShovel = new ItemStack(Material.STONE_SPADE);
				ItemMeta stoneShovelMeta = stoneShovel.getItemMeta();
				ArrayList<String> stoneShovelLore = new ArrayList<String>();
				stoneShovelLore.add(ChatColor.GOLD + "Purchase: 3 Coal");
				stoneShovelMeta.setLore(stoneShovelLore);
				stoneShovel.setItemMeta(stoneShovelMeta);
				shopPG2.setItem(2, stoneShovel);
			}
		}
	}*/

}
