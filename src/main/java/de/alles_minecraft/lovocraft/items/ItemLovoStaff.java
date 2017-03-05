package de.alles_minecraft.lovocraft.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ItemLovoStaff extends ItemBasic {

	public ItemLovoStaff() {
		super("lovo_staff");
		
	}
@Override
public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn,
		EnumHand hand) {
	 if (!worldIn.isRemote)
     {
         double d0 = playerIn.posX;
         double d1 = playerIn.posY;
         double d2 = playerIn.posZ;

         for (int i = 0; i < 16; ++i)
         {
             double d3 = playerIn.posX + (playerIn.getRNG().nextDouble() - 0.5D) * 16.0D;
             double d4 = MathHelper.clamp_double(playerIn.posY + (double)(playerIn.getRNG().nextInt(16) - 8), 0.0D, (double)(worldIn.getActualHeight() - 1));
             double d5 = playerIn.posZ + (playerIn.getRNG().nextDouble() - 0.5D) * 16.0D;

             if (playerIn.isRiding())
             {
                 playerIn.dismountRidingEntity();
             }

             if (playerIn.attemptTeleport(d3, d4, d5))
             {
                 worldIn.playSound((EntityPlayer)null, d0, d1, d2, SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, SoundCategory.PLAYERS, 1.0F, 1.0F);
                 playerIn.playSound(SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, 1.0F, 1.0F);
                 break;
             }
         }

         if (playerIn instanceof EntityPlayer)
         {
             ((EntityPlayer)playerIn).getCooldownTracker().setCooldown(this, 20);
         }
     }
	return super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
}
}
