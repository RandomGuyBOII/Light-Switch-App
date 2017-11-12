package com.mrcrayfish.lightswitch.init;

import com.mrcrayfish.lightswitch.Reference;
import com.mrcrayfish.lightswitch.block.BlockLight;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.IForgeRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Author: MrCrayfish
 */
public class ModBlocks
{
    public static Block light;

    public static void init()
    {
        light = new BlockLight();
    }

    @Mod.EventBusSubscriber(modid = Reference.MOD_ID)
    public static class RegistrationHandler
    {
        @SubscribeEvent
        public static void onRegisterBlocks(RegistryEvent.Register<Block> event)
        {
            init();
            event.getRegistry().register(light);
        }

        @SubscribeEvent
        public static void onRegisterItems(RegistryEvent.Register<Item> event)
        {
            ItemBlock item = new ItemBlock(light);
            item.setRegistryName(light.getRegistryName());
            event.getRegistry().register(item);
        }

        @SideOnly(Side.CLIENT)
        @SubscribeEvent
        public static void onRegisterModels(ModelRegistryEvent event)
        {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(light), 0, new ModelResourceLocation(light.getRegistryName(), "inventory"));
        }
    }
}
