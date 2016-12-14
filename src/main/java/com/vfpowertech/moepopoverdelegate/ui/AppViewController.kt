package com.vfpowertech.moepopoverdelegate.ui

import apple.coregraphics.struct.CGPoint
import apple.coregraphics.struct.CGRect
import apple.coregraphics.struct.CGSize
import apple.uikit.*
import apple.uikit.c.UIKit
import apple.uikit.enums.UIModalPresentationStyle
import apple.uikit.protocol.UIPopoverPresentationControllerDelegate
import com.vfpowertech.moepopoverdelegate.nsarray
import org.moe.natj.general.Pointer
import org.moe.natj.general.ann.Owned
import org.moe.natj.general.ann.RegisterOnStartup
import org.moe.natj.general.ptr.Ptr
import org.moe.natj.objc.ObjCRuntime
import org.moe.natj.objc.ann.ObjCClassName
import org.moe.natj.objc.ann.Selector

@org.moe.natj.general.ann.Runtime(ObjCRuntime::class)
@ObjCClassName("AppViewController")
@RegisterOnStartup
class AppViewController private constructor(peer: Pointer) : UIViewController(peer), UIPopoverPresentationControllerDelegate {
    companion object {
        @Owned
        @Selector("alloc")
        external fun alloc(): AppViewController
    }

    @Selector("init")
    override external fun init(): AppViewController

    @Selector("shareButton")
    external fun getShareButton(): UIButton

    override fun viewDidLoad() {
    }

    private fun calcSharePopoverRect(): CGRect {
        val frame = getShareButton().frame()
        val x = frame.size().width() / 2

        return CGRect(CGPoint(x, 0.0), CGSize(0.0, 20.0))
    }

    @Selector("onShareClicked:")
    fun onShareClicked(sender: UIButton) {
        val activityItems = nsarray("Share text")

        val activityController = UIActivityViewController.alloc().initWithActivityItemsApplicationActivities(activityItems, null)

        val excludedTypes = nsarray(UIKit.UIActivityTypeAddToReadingList(), UIKit.UIActivityTypeAirDrop())

        activityController.setExcludedActivityTypes(excludedTypes)

        activityController.setModalPresentationStyle(UIModalPresentationStyle.Popover)

        presentViewControllerAnimatedCompletion(activityController, true, null)

        val popoverController = activityController.popoverPresentationController()
        if (popoverController != null) {
            popoverController.setSourceView(getShareButton())
            popoverController.setSourceRect(calcSharePopoverRect())
            popoverController.setDelegate(this)
        }
    }

    override fun popoverPresentationControllerWillRepositionPopoverToRectInView(popoverPresentationController: UIPopoverPresentationController, rect: CGRect, view: Ptr<UIView>) {
        println("Repositioning")

        val newRect = calcSharePopoverRect()
        rect.setOrigin(newRect.origin())
        rect.setSize(newRect.size())
    }
}
