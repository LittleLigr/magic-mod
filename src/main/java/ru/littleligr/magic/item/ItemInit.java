package ru.littleligr.magic.item;

import io.wispforest.owo.registration.reflect.ItemRegistryContainer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolMaterials;
import ru.littleligr.magic.item.weapon.Staff;

public class ItemInit implements ItemRegistryContainer {
    public static final Staff STAFF = new Staff(ToolMaterials.IRON, 4, 2, new FabricItemSettings().group(ItemGroup.COMBAT));
    public static final MagicBook MAGIC_BOOK = new MagicBook(new FabricItemSettings().group(ItemGroup.TOOLS));
}
